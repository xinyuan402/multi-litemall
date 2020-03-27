package com.lcwork.multishop.sysadmin.service;

import com.lcwork.multishop.core.util.ResponseUtil;
import com.lcwork.multishop.db.domain.generate.LitemallGoods;
import com.lcwork.multishop.db.service.LitemallGoodsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysadminGoodsService {
    private final Log logger = LogFactory.getLog(SysadminGoodsService.class);

    @Autowired
    private LitemallGoodsService goodsService;

    public Object list(Integer goodsId, String goodsSn, String name,
                       Integer page, Integer limit, String sort, String order) {
        List<LitemallGoods> goodsList = goodsService.querySelective(goodsId, goodsSn, name, page, limit, sort, order);
        return ResponseUtil.okList(goodsList);
    }

}
