package org.linlinjava.litemall.sysadmin.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.core.util.response.DataList;
import org.linlinjava.litemall.core.util.response.ResponseData;
import org.linlinjava.litemall.db.domain.generate.LitemallShop;
import org.linlinjava.litemall.db.enums.ShopStatus;
import org.linlinjava.litemall.db.service.LitemallShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.linlinjava.litemall.sysadmin.util.SysadminResponseCode.SHOP_NAME_EXIT;

@Service
public class AdminShopService {
    private final Log logger = LogFactory.getLog(AdminShopService.class);

    @Autowired
    LitemallShopService shopService;

    public ResponseData<DataList<LitemallShop>> list(String name, Integer page, Integer limit, String sort, String order) {
        List<LitemallShop> goodsList = shopService.querySelective(name, page, limit, sort, order);
        return ResponseUtil.okList(goodsList);
    }

    public ResponseData<Object> create(LitemallShop shop) {
        if (shopService.checkExistByName(shop.getName())) {
            return ResponseUtil.fail(SHOP_NAME_EXIT, "商铺名称已存在");
        }
        shop.setDeleted(false);
        shop.setStatus(ShopStatus.TO_CHECK);

        shopService.add(shop);

        return ResponseUtil.ok();
    }

    public ResponseData<Object> update(LitemallShop shop) {

        shop.setStatus(ShopStatus.TO_CHECK);
        if (shopService.updateById(shop) == 0) {
            throw new RuntimeException("更新数据失败");
        }
        return ResponseUtil.ok();
    }

    public ResponseData<Object> delete(LitemallShop shop) {
        int result = shopService.deleteById(shop.getId());
        if (result == 0) {
            throw new RuntimeException("更新数据失败");
        }

        return ResponseUtil.ok();
    }

    public ResponseData<Object> changeStatus(Integer id, ShopStatus status) {
        int result =shopService.updateStatusById(id, status);
        if (result == 0){
            throw new RuntimeException("更新数据失败");
        }
        return ResponseUtil.ok();
    }
}
