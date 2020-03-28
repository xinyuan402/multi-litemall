package com.lcwork.multimall.sysadmin.web;

import com.lcwork.multimall.core.annotation.RequiresPermissionsDesc;
import com.lcwork.multimall.core.util.ResponseUtil;
import com.lcwork.multimall.core.util.response.DataList;
import com.lcwork.multimall.core.util.response.ResponseData;
import com.lcwork.multimall.core.validator.Order;
import com.lcwork.multimall.core.validator.Sort;
import com.lcwork.multimall.db.domain.generate.MultimallAdminLog;
import com.lcwork.multimall.db.service.MultimallAdminLogService;
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

@RestController
@RequestMapping("/sysadmin/log")
@Validated
public class SysadminLogController {
    private final Log logger = LogFactory.getLog(SysadminLogController.class);

    @Autowired
    private MultimallAdminLogService logService;

    @RequiresPermissions("sysadmin:log:list")
    @RequiresPermissionsDesc(menu = {"系统管理", "操作日志"}, button = "查询")
    @GetMapping("/list")
    public ResponseData<DataList<MultimallAdminLog>> list(String name,
                                                         @RequestParam(defaultValue = "1") Integer page,
                                                         @RequestParam(defaultValue = "10") Integer limit,
                                                         @Sort @RequestParam(defaultValue = "add_time") String sort,
                                                         @Order @RequestParam(defaultValue = "desc") String order) {
        List<MultimallAdminLog> logList = logService.querySelective(name, page, limit, sort, order);
        return ResponseUtil.okList(logList);
    }
}
