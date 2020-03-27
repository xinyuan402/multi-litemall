package com.lcwork.multishop.sysadmin.web;

import com.lcwork.multishop.core.annotation.RequiresPermissionsDesc;
import com.lcwork.multishop.core.util.ResponseUtil;
import com.lcwork.multishop.core.validator.Order;
import com.lcwork.multishop.core.validator.Sort;
import com.lcwork.multishop.db.domain.generate.LitemallFeedback;
import com.lcwork.multishop.db.service.LitemallFeedbackService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yogeek
 * @date 2018/8/26 1:11
 */
@RestController
@RequestMapping("/sysadmin/feedback")
@Validated
public class SysadminFeedbackController {
    private final Log logger = LogFactory.getLog(SysadminFeedbackController.class);

    @Autowired
    private LitemallFeedbackService feedbackService;

    @RequiresPermissions("sysadmin:feedback:list")
    @RequiresPermissionsDesc(menu = {"用户管理", "意见反馈"}, button = "查询")
    @GetMapping("/list")
    public Object list(Integer userId, String username,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<LitemallFeedback> feedbackList = feedbackService.querySelective(userId, username, page, limit, sort,
                order);
        return ResponseUtil.okList(feedbackList);
    }
}
