package com.lcwork.multimall.sysadmin.web;

import com.lcwork.multimall.core.annotation.RequiresPermissionsDesc;
import com.lcwork.multimall.core.util.response.DataList;
import com.lcwork.multimall.core.util.response.ResponseData;
import com.lcwork.multimall.core.validator.Order;
import com.lcwork.multimall.core.validator.Sort;
import com.lcwork.multimall.db.domain.generate.MultimallShop;
import com.lcwork.multimall.sysadmin.service.SysadminShopService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sysadmin/shop")
@Validated
public class SysadminShopController {
    private final Log logger = LogFactory.getLog(SysadminShopController.class);

    @Autowired
    SysadminShopService shopService;

    @RequiresPermissions("sysadmin:shop:list")
    @RequiresPermissionsDesc(menu = {"商铺", "商铺管理"}, button = "查询")
    @GetMapping("/list")
    public ResponseData<DataList<MultimallShop>> list(String name,
                                                     @RequestParam(defaultValue = "1") Integer page,
                                                     @RequestParam(defaultValue = "10") Integer limit,
                                                     @Sort @RequestParam(defaultValue = "add_time") String sort,
                                                     @Order @RequestParam(defaultValue = "desc") String order) {
        return shopService.list(name, page, limit, sort, order);
    }

    @RequiresPermissions("sysadmin:shop:create")
    @RequiresPermissionsDesc(menu = {"商铺", "商铺管理"}, button = "创建")
    @PostMapping("/create")
    public ResponseData<Object> create(@RequestBody MultimallShop shop) {
        return shopService.create(shop);
    }

    @RequiresPermissions("sysadmin:shop:update")
    @RequiresPermissionsDesc(menu = {"商铺", "商铺管理"}, button = "更新")
    @PostMapping("/update")
    public ResponseData<Object> update(@RequestBody MultimallShop shop) {
        return shopService.update(shop);
    }

    @RequiresPermissions("sysadmin:shop:delete")
    @RequiresPermissionsDesc(menu = {"商铺", "商铺管理"}, button = "删除")
    @PostMapping("/delete")
    public ResponseData<Object> delete(@RequestBody MultimallShop shop) {
        return shopService.delete(shop);
    }

    @RequiresPermissions("sysadmin:shop:changeStatus")
    @RequiresPermissionsDesc(menu = {"商铺", "商铺管理"}, button = "禁用")
    @PostMapping("/changeStatus")
    public ResponseData<Object> changeStatus(@RequestBody MultimallShop shop) {
        return shopService.changeStatus(shop.getId(), shop.getStatus());
    }
}
