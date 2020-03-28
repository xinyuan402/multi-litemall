package com.lcwork.multimall.sysadmin.web;

import com.lcwork.multimall.core.annotation.RequiresPermissionsDesc;
import com.lcwork.multimall.core.util.ResponseUtil;
import com.lcwork.multimall.core.validator.Order;
import com.lcwork.multimall.core.validator.Sort;
import com.lcwork.multimall.db.domain.generate.MultimallSearchHistory;
import com.lcwork.multimall.db.service.MultimallSearchHistoryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sysadmin/history")
public class SysadminHistoryController {
    private final Log logger = LogFactory.getLog(SysadminHistoryController.class);

    @Autowired
    private MultimallSearchHistoryService searchHistoryService;

    @RequiresPermissions("sysadmin:history:list")
    @RequiresPermissionsDesc(menu = {"用户管理", "搜索历史"}, button = "查询")
    @GetMapping("/list")
    public Object list(String userId, String keyword,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<MultimallSearchHistory> historyList = searchHistoryService.querySelective(userId, keyword, page, limit,
                sort, order);
        return ResponseUtil.okList(historyList);
    }
}
