package com.lcwork.multimall.db.service;

import com.lcwork.multimall.db.dao.generate.MultimallOrderGoodsMapper;
import com.lcwork.multimall.db.domain.generate.MultimallOrderGoods;
import com.lcwork.multimall.db.domain.generate.MultimallOrderGoodsExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MultimallOrderGoodsService {
    @Resource
    private MultimallOrderGoodsMapper orderGoodsMapper;

    public int add(MultimallOrderGoods orderGoods) {
        orderGoods.setAddTime(LocalDateTime.now());
        orderGoods.setUpdateTime(LocalDateTime.now());
        return orderGoodsMapper.insertSelective(orderGoods);
    }

    public List<MultimallOrderGoods> queryByOid(Integer orderId) {
        MultimallOrderGoodsExample example = new MultimallOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        return orderGoodsMapper.selectByExample(example);
    }

    public List<MultimallOrderGoods> findByOidAndGid(Integer orderId, Integer goodsId) {
        MultimallOrderGoodsExample example = new MultimallOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return orderGoodsMapper.selectByExample(example);
    }

    public MultimallOrderGoods findById(Integer id) {
        return orderGoodsMapper.selectByPrimaryKey(id);
    }

    public void updateById(MultimallOrderGoods orderGoods) {
        orderGoods.setUpdateTime(LocalDateTime.now());
        orderGoodsMapper.updateByPrimaryKeySelective(orderGoods);
    }

    public Short getComments(Integer orderId) {
        MultimallOrderGoodsExample example = new MultimallOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        long count = orderGoodsMapper.countByExample(example);
        return (short) count;
    }

    public boolean checkExist(Integer goodsId) {
        MultimallOrderGoodsExample example = new MultimallOrderGoodsExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return orderGoodsMapper.countByExample(example) != 0;
    }
}
