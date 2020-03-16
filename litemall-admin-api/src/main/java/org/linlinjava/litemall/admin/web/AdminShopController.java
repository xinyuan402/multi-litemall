package org.linlinjava.litemall.admin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.linlinjava.litemall.admin.annotation.RequiresPermissionsDesc;
import org.linlinjava.litemall.admin.service.AdminShopService;
import org.linlinjava.litemall.core.validator.Order;
import org.linlinjava.litemall.core.validator.Sort;
import org.linlinjava.litemall.db.domain.generate.LitemallShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/shop")
@Validated
public class AdminShopController {
    private final Log logger = LogFactory.getLog(AdminShopController.class);

    @Autowired
    AdminShopService shopService;

    @RequiresPermissions("admin:shop:list")
    @RequiresPermissionsDesc(menu = {"商铺", "商铺管理"}, button = "查询")
    @GetMapping("/list")
    public Object list(String name,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        return shopService.list(name, page, limit, sort, order);
    }

    @RequiresPermissions("admin:shop:create")
    @RequiresPermissionsDesc(menu = {"商铺", "商铺管理"}, button = "创建")
    @PostMapping("/create")
    public Object create(@RequestBody LitemallShop shop){
        return shopService.create(shop);
    }
}
