package com.lcwork.multishop.sysadmin.web;

import com.lcwork.multishop.core.annotation.RequiresPermissionsDesc;
import com.lcwork.multishop.core.util.ResponseUtil;
import com.lcwork.multishop.core.util.response.DataList;
import com.lcwork.multishop.core.util.response.ResponseData;
import com.lcwork.multishop.core.validator.Order;
import com.lcwork.multishop.core.validator.Sort;
import com.lcwork.multishop.db.domain.generate.LitemallAdminLog;
import com.lcwork.multishop.db.service.LitemallAdminLogService;
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
    private LitemallAdminLogService logService;

    @RequiresPermissions("sysadmin:log:list")
    @RequiresPermissionsDesc(menu = {"系统管理", "操作日志"}, button = "查询")
    @GetMapping("/list")
    public ResponseData<DataList<LitemallAdminLog>> list(String name,
                                                         @RequestParam(defaultValue = "1") Integer page,
                                                         @RequestParam(defaultValue = "10") Integer limit,
                                                         @Sort @RequestParam(defaultValue = "add_time") String sort,
                                                         @Order @RequestParam(defaultValue = "desc") String order) {
        List<LitemallAdminLog> logList = logService.querySelective(name, page, limit, sort, order);
        return ResponseUtil.okList(logList);
    }
}