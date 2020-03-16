package org.linlinjava.litemall.admin.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.generate.LitemallShop;
import org.linlinjava.litemall.db.enums.ShopStatus;
import org.linlinjava.litemall.db.service.LitemallShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.linlinjava.litemall.admin.util.AdminResponseCode.SHOP_NAME_EXIT;

@Service
public class AdminShopService {
    private final Log logger = LogFactory.getLog(AdminShopService.class);

    @Autowired
    LitemallShopService shopService;

    public Object list(String name, Integer page, Integer limit, String sort, String order) {
        List<LitemallShop> goodsList = shopService.querySelective(name, page, limit, sort, order);
        return ResponseUtil.okList(goodsList);
    }

    public Object create(LitemallShop shop) {
        if (shopService.checkExistByName(shop.getName())) {
            return ResponseUtil.fail(SHOP_NAME_EXIT, "商铺名称已存在");
        }
        shop.setDeleted(false);
        shop.setStatus(ShopStatus.TO_CHECK);

        shopService.add(shop);

        return ResponseUtil.ok();
    }
}
