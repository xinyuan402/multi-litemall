package com.lcwork.multimall.admin.service;

import com.lcwork.multimall.core.util.ResponseUtil;
import com.lcwork.multimall.core.util.response.DataList;
import com.lcwork.multimall.core.util.response.ResponseData;
import com.lcwork.multimall.db.domain.generate.MultimallShop;
import com.lcwork.multimall.db.enums.ShopStatus;
import com.lcwork.multimall.db.service.MultimallShopService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.lcwork.multimall.admin.util.AdminResponseCode.SHOP_NAME_EXIT;

@Service
public class AdminShopService {
    private final Log logger = LogFactory.getLog(AdminShopService.class);

    @Autowired
    MultimallShopService shopService;

    public ResponseData<DataList<MultimallShop>> list(String name, Integer page, Integer limit, String sort, String order) {
        List<MultimallShop> goodsList = shopService.querySelective(name, page, limit, sort, order);
        return ResponseUtil.okList(goodsList);
    }

    public ResponseData<Object> create(MultimallShop shop) {
        if (shopService.checkExistByName(shop.getName())) {
            return ResponseUtil.fail(SHOP_NAME_EXIT, "商铺名称已存在");
        }
        shop.setDeleted(false);
        shop.setStatus(ShopStatus.TO_CHECK);

        shopService.add(shop);

        return ResponseUtil.ok();
    }

    public ResponseData<Object> update(MultimallShop shop) {

        shop.setStatus(ShopStatus.TO_CHECK);
        if (shopService.updateById(shop) == 0) {
            throw new RuntimeException("更新数据失败");
        }
        return ResponseUtil.ok();
    }

    public ResponseData<Object> delete(MultimallShop shop) {
        int result = shopService.deleteById(shop.getId());
        if (result == 0) {
            throw new RuntimeException("更新数据失败");
        }

        return ResponseUtil.ok();
    }

    public ResponseData<Object> changeStatus(Integer id, ShopStatus status) {
        int result = shopService.updateStatusById(id, status);
        if (result == 0) {
            throw new RuntimeException("更新数据失败");
        }
        return ResponseUtil.ok();
    }
}
