package com.lcwork.multimall.db.service;

import com.github.pagehelper.PageHelper;
import com.lcwork.multimall.db.dao.generate.MultimallFootprintMapper;
import com.lcwork.multimall.db.domain.generate.MultimallFootprint;
import com.lcwork.multimall.db.domain.generate.MultimallFootprintExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MultimallFootprintService {
    @Resource
    private MultimallFootprintMapper footprintMapper;

    public List<MultimallFootprint> queryByAddTime(Integer userId, Integer page, Integer size) {
        MultimallFootprintExample example = new MultimallFootprintExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        example.setOrderByClause(MultimallFootprint.Column.addTime.desc());
        PageHelper.startPage(page, size);
        return footprintMapper.selectByExample(example);
    }

    public MultimallFootprint findById(Integer id) {
        return footprintMapper.selectByPrimaryKey(id);
    }

    public MultimallFootprint findById(Integer userId, Integer id) {
        MultimallFootprintExample example = new MultimallFootprintExample();
        example.or().andIdEqualTo(id).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return footprintMapper.selectOneByExample(example);
    }

    public void deleteById(Integer id) {
        footprintMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(MultimallFootprint footprint) {
        footprint.setAddTime(LocalDateTime.now());
        footprint.setUpdateTime(LocalDateTime.now());
        footprintMapper.insertSelective(footprint);
    }

    public List<MultimallFootprint> querySelective(String userId, String goodsId, Integer page, Integer size, String sort, String order) {
        MultimallFootprintExample example = new MultimallFootprintExample();
        MultimallFootprintExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(Integer.valueOf(goodsId));
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return footprintMapper.selectByExample(example);
    }
}
