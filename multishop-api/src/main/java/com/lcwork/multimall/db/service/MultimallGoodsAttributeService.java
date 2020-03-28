package com.lcwork.multimall.db.service;

import com.lcwork.multimall.db.dao.generate.MultimallGoodsAttributeMapper;
import com.lcwork.multimall.db.domain.generate.MultimallGoodsAttribute;
import com.lcwork.multimall.db.domain.generate.MultimallGoodsAttributeExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MultimallGoodsAttributeService {
    @Resource
    private MultimallGoodsAttributeMapper goodsAttributeMapper;

    public List<MultimallGoodsAttribute> queryByGid(Integer goodsId) {
        MultimallGoodsAttributeExample example = new MultimallGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return goodsAttributeMapper.selectByExample(example);
    }

    public void add(MultimallGoodsAttribute goodsAttribute) {
        goodsAttribute.setAddTime(LocalDateTime.now());
        goodsAttribute.setUpdateTime(LocalDateTime.now());
        goodsAttributeMapper.insertSelective(goodsAttribute);
    }

    public MultimallGoodsAttribute findById(Integer id) {
        return goodsAttributeMapper.selectByPrimaryKey(id);
    }

    public void deleteByGid(Integer gid) {
        MultimallGoodsAttributeExample example = new MultimallGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(gid);
        goodsAttributeMapper.logicalDeleteByExample(example);
    }

    public void deleteById(Integer id) {
        goodsAttributeMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(MultimallGoodsAttribute attribute) {
        attribute.setUpdateTime(LocalDateTime.now());
        goodsAttributeMapper.updateByPrimaryKeySelective(attribute);
    }
}
