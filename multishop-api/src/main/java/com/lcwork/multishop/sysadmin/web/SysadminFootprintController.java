package com.lcwork.multishop.sysadmin.web;

import com.lcwork.multishop.core.annotation.RequiresPermissionsDesc;
import com.lcwork.multishop.core.util.ResponseUtil;
import com.lcwork.multishop.core.validator.Order;
import com.lcwork.multishop.core.validator.Sort;
import com.lcwork.multishop.db.domain.generate.LitemallFootprint;
import com.lcwork.multishop.db.service.LitemallFootprintService;
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
@RequestMapping("/sysadmin/footprint")
@Validated
public class SysadminFootprintController {
    private final Log logger = LogFactory.getLog(SysadminFootprintController.class);

    @Autowired
    private LitemallFootprintService footprintService;

    @RequiresPermissions("sysadmin:footprint:list")
    @RequiresPermissionsDesc(menu = {"用户管理", "用户足迹"}, button = "查询")
    @GetMapping("/list")
    public Object list(String userId, String goodsId,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<LitemallFootprint> footprintList = footprintService.querySelective(userId, goodsId, page, limit, sort,
                order);
        return ResponseUtil.okList(footprintList);
    }
}
