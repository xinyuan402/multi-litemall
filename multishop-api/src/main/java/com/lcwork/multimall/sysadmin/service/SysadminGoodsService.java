package com.lcwork.multimall.sysadmin.service;

import com.lcwork.multimall.core.util.ResponseUtil;
import com.lcwork.multimall.db.domain.generate.MultimallGoods;
import com.lcwork.multimall.db.service.MultimallGoodsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysadminGoodsService {
    private final Log logger = LogFactory.getLog(SysadminGoodsService.class);

    @Autowired
    private MultimallGoodsService goodsService;

    public Object list(Integer goodsId, String goodsSn, String name,
                       Integer page, Integer limit, String sort, String order) {
        List<MultimallGoods> goodsList = goodsService.querySelective(goodsId, goodsSn, name, page, limit, sort, order);
        return ResponseUtil.okList(goodsList);
    }

}
