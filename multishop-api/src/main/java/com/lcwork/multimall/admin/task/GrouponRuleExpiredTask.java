package com.lcwork.multimall.admin.task;

import com.lcwork.multimall.core.task.Task;
import com.lcwork.multimall.core.util.BeanUtil;
import com.lcwork.multimall.db.domain.generate.MultimallGroupon;
import com.lcwork.multimall.db.domain.generate.MultimallGrouponRules;
import com.lcwork.multimall.db.domain.generate.MultimallOrder;
import com.lcwork.multimall.db.service.MultimallGrouponRulesService;
import com.lcwork.multimall.db.service.MultimallGrouponService;
import com.lcwork.multimall.db.service.MultimallOrderService;
import com.lcwork.multimall.db.util.GrouponConstant;
import com.lcwork.multimall.db.util.OrderUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

public class GrouponRuleExpiredTask extends Task {
    private final Log logger = LogFactory.getLog(GrouponRuleExpiredTask.class);
    private int grouponRuleId = -1;

    public GrouponRuleExpiredTask(Integer grouponRuleId, long delayInMilliseconds) {
        super("GrouponRuleExpiredTask-" + grouponRuleId, delayInMilliseconds);
        this.grouponRuleId = grouponRuleId;
    }

    @Override
    public void run() {
        logger.info("系统开始处理延时任务---团购规则过期---" + this.grouponRuleId);

        MultimallOrderService orderService = BeanUtil.getBean(MultimallOrderService.class);
        MultimallGrouponService grouponService = BeanUtil.getBean(MultimallGrouponService.class);
        MultimallGrouponRulesService grouponRulesService = BeanUtil.getBean(MultimallGrouponRulesService.class);

        MultimallGrouponRules grouponRules = grouponRulesService.findById(grouponRuleId);
        if (grouponRules == null) {
            return;
        }
        if (!grouponRules.getStatus().equals(GrouponConstant.RULE_STATUS_ON)) {
            return;
        }

        // 团购活动取消
        grouponRules.setStatus(GrouponConstant.RULE_STATUS_DOWN_EXPIRE);
        grouponRulesService.updateById(grouponRules);

        List<MultimallGroupon> grouponList = grouponService.queryByRuleId(grouponRuleId);
        // 用户团购处理
        for (MultimallGroupon groupon : grouponList) {
            Short status = groupon.getStatus();
            MultimallOrder order = orderService.findById(groupon.getOrderId());
            if (status.equals(GrouponConstant.STATUS_NONE)) {
                groupon.setStatus(GrouponConstant.STATUS_FAIL);
                grouponService.updateById(groupon);
            } else if (status.equals(GrouponConstant.STATUS_ON)) {
                // 如果团购进行中
                // (1) 团购设置团购失败等待退款状态
                groupon.setStatus(GrouponConstant.STATUS_FAIL);
                grouponService.updateById(groupon);
                // (2) 团购订单申请退款
                if (OrderUtil.isPayStatus(order)) {
                    order.setOrderStatus(OrderUtil.STATUS_REFUND);
                    orderService.updateWithOptimisticLocker(order);
                }
            }
        }
        logger.info("系统结束处理延时任务---团购规则过期---" + this.grouponRuleId);
    }
}
