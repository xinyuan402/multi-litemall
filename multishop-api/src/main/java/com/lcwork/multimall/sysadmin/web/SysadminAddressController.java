package com.lcwork.multimall.sysadmin.web;

import com.lcwork.multimall.core.annotation.RequiresPermissionsDesc;
import com.lcwork.multimall.core.util.ResponseUtil;
import com.lcwork.multimall.core.validator.Order;
import com.lcwork.multimall.core.validator.Sort;
import com.lcwork.multimall.db.domain.generate.MultimallAddress;
import com.lcwork.multimall.db.service.MultimallAddressService;
import com.lcwork.multimall.db.service.MultimallRegionService;
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
@RequestMapping("/sysadmin/address")
@Validated
public class SysadminAddressController {
    private final Log logger = LogFactory.getLog(SysadminAddressController.class);

    @Autowired
    private MultimallAddressService addressService;
    @Autowired
    private MultimallRegionService regionService;

    @RequiresPermissions("sysadmin:address:list")
    @RequiresPermissionsDesc(menu = {"用户管理", "收货地址"}, button = "查询")
    @GetMapping("/list")
    public Object list(Integer userId, String name,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {

        List<MultimallAddress> addressList = addressService.querySelective(userId, name, page, limit, sort, order);
        return ResponseUtil.okList(addressList);
    }
}
