package com.lcwork.multimall.sysadmin.web;

import com.lcwork.multimall.core.util.ResponseUtil;
import com.lcwork.multimall.db.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sysadmin/dashboard")
@Validated
public class SysadminDashboardController {
    private final Log logger = LogFactory.getLog(SysadminDashboardController.class);

    @Autowired
    private MultimallUserService userService;
    @Autowired
    private MultimallGoodsService goodsService;
    @Autowired
    private MultimallGoodsProductService productService;
    @Autowired
    private MultimallOrderService orderService;
    @Autowired
    private MultimallShopService shopService;

    @GetMapping("")
    public Object info() {
        int userTotal = userService.count();
        int goodsTotal = goodsService.count();
        int productTotal = productService.count();
        int orderTotal = orderService.count();
        int shopTotal = shopService.count();
        Map<String, Integer> data = new HashMap<>();
        data.put("userTotal", userTotal);
        data.put("goodsTotal", goodsTotal);
        data.put("productTotal", productTotal);
        data.put("orderTotal", orderTotal);
        data.put("shopTotal", shopTotal);

        return ResponseUtil.ok(data);
    }

}
