package com.lcwork.multimall.db.service;

import com.lcwork.multimall.db.dao.GoodsProductMapper;
import com.lcwork.multimall.db.dao.generate.MultimallGoodsProductMapper;
import com.lcwork.multimall.db.domain.generate.MultimallGoodsProduct;
import com.lcwork.multimall.db.domain.generate.MultimallGoodsProductExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MultimallGoodsProductService {
    @Resource
    private MultimallGoodsProductMapper litemallGoodsProductMapper;
    @Resource
    private GoodsProductMapper goodsProductMapper;

    public List<MultimallGoodsProduct> queryByGid(Integer gid) {
        MultimallGoodsProductExample example = new MultimallGoodsProductExample();
        example.or().andGoodsIdEqualTo(gid).andDeletedEqualTo(false);
        return litemallGoodsProductMapper.selectByExample(example);
    }

    public MultimallGoodsProduct findById(Integer id) {
        return litemallGoodsProductMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        litemallGoodsProductMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(MultimallGoodsProduct goodsProduct) {
        goodsProduct.setAddTime(LocalDateTime.now());
        goodsProduct.setUpdateTime(LocalDateTime.now());
        litemallGoodsProductMapper.insertSelective(goodsProduct);
    }

    public int count() {
        MultimallGoodsProductExample example = new MultimallGoodsProductExample();
        example.or().andDeletedEqualTo(false);
        return (int) litemallGoodsProductMapper.countByExample(example);
    }

    public void deleteByGid(Integer gid) {
        MultimallGoodsProductExample example = new MultimallGoodsProductExample();
        example.or().andGoodsIdEqualTo(gid);
        litemallGoodsProductMapper.logicalDeleteByExample(example);
    }

    public int addStock(Integer id, Short num) {
        return goodsProductMapper.addStock(id, num);
    }

    public int reduceStock(Integer id, Short num) {
        return goodsProductMapper.reduceStock(id, num);
    }

    public void updateById(MultimallGoodsProduct product) {
        product.setUpdateTime(LocalDateTime.now());
        litemallGoodsProductMapper.updateByPrimaryKeySelective(product);
    }
}
