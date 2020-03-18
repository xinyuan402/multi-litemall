package org.linlinjava.litemall.sysadmin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.linlinjava.litemall.core.annotation.RequiresPermissionsDesc;
import org.linlinjava.litemall.sysadmin.service.AdminShopService;
import org.linlinjava.litemall.core.util.response.DataList;
import org.linlinjava.litemall.core.util.response.ResponseData;
import org.linlinjava.litemall.core.validator.Order;
import org.linlinjava.litemall.core.validator.Sort;
import org.linlinjava.litemall.db.domain.generate.LitemallShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sysadmin/shop")
@Validated
public class AdminShopController {
    private final Log logger = LogFactory.getLog(AdminShopController.class);

    @Autowired
    AdminShopService shopService;

    @RequiresPermissions("sysadmin:shop:list")
    @RequiresPermissionsDesc(menu = {"商铺", "商铺管理"}, button = "查询")
    @GetMapping("/list")
    public ResponseData<DataList<LitemallShop>> list(String name,
                                                     @RequestParam(defaultValue = "1") Integer page,
                                                     @RequestParam(defaultValue = "10") Integer limit,
                                                     @Sort @RequestParam(defaultValue = "add_time") String sort,
                                                     @Order @RequestParam(defaultValue = "desc") String order) {
        return shopService.list(name, page, limit, sort, order);
    }

    @RequiresPermissions("sysadmin:shop:create")
    @RequiresPermissionsDesc(menu = {"商铺", "商铺管理"}, button = "创建")
    @PostMapping("/create")
    public ResponseData<Object> create(@RequestBody LitemallShop shop) {
        return shopService.create(shop);
    }

    @RequiresPermissions("sysadmin:shop:update")
    @RequiresPermissionsDesc(menu = {"商铺", "商铺管理"}, button = "更新")
    @PostMapping("/update")
    public ResponseData<Object> update(@RequestBody LitemallShop shop) {
        return shopService.update(shop);
    }

    @RequiresPermissions("sysadmin:shop:delete")
    @RequiresPermissionsDesc(menu = {"商铺", "商铺管理"}, button = "删除")
    @PostMapping("/delete")
    public ResponseData<Object> delete(@RequestBody LitemallShop shop) {
        return shopService.delete(shop);
    }

    @RequiresPermissions("sysadmin:shop:changeStatus")
    @RequiresPermissionsDesc(menu = {"商铺", "商铺管理"}, button = "禁用")
    @PostMapping("/changeStatus")
    public ResponseData<Object> changeStatus( @RequestBody LitemallShop shop) {
        return shopService.changeStatus(shop.getId(), shop.getStatus());
    }
}
