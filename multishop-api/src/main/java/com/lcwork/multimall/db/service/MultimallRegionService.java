package com.lcwork.multimall.db.service;

import com.github.pagehelper.PageHelper;
import com.lcwork.multimall.db.dao.generate.MultimallRegionMapper;
import com.lcwork.multimall.db.domain.generate.MultimallRegion;
import com.lcwork.multimall.db.domain.generate.MultimallRegionExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MultimallRegionService {

    @Resource
    private MultimallRegionMapper regionMapper;

    public List<MultimallRegion> getAll() {
        MultimallRegionExample example = new MultimallRegionExample();
        byte b = 4;
        example.or().andTypeNotEqualTo(b);
        return regionMapper.selectByExample(example);
    }

    public List<MultimallRegion> queryByPid(Integer parentId) {
        MultimallRegionExample example = new MultimallRegionExample();
        example.or().andPidEqualTo(parentId);
        return regionMapper.selectByExample(example);
    }

    public MultimallRegion findById(Integer id) {
        return regionMapper.selectByPrimaryKey(id);
    }

    public List<MultimallRegion> querySelective(String name, Integer code, Integer page, Integer size, String sort, String order) {
        MultimallRegionExample example = new MultimallRegionExample();
        MultimallRegionExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (!StringUtils.isEmpty(code)) {
            criteria.andCodeEqualTo(code);
        }

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return regionMapper.selectByExample(example);
    }

}
