package com.lcwork.multimall.db.service;

import com.github.pagehelper.PageHelper;
import com.lcwork.multimall.db.dao.generate.MultimallBrandMapper;
import com.lcwork.multimall.db.domain.generate.MultimallBrand;
import com.lcwork.multimall.db.domain.generate.MultimallBrandExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MultimallBrandService {
    @Resource
    private MultimallBrandMapper brandMapper;
    private MultimallBrand.Column[] columns = new MultimallBrand.Column[]{MultimallBrand.Column.id, MultimallBrand.Column.name, MultimallBrand.Column.desc, MultimallBrand.Column.picUrl, MultimallBrand.Column.floorPrice};

    public List<MultimallBrand> query(Integer page, Integer limit, String sort, String order) {
        MultimallBrandExample example = new MultimallBrandExample();
        example.or().andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, limit);
        return brandMapper.selectByExampleSelective(example, columns);
    }

    public List<MultimallBrand> query(Integer page, Integer limit) {
        return query(page, limit, null, null);
    }

    public MultimallBrand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    public List<MultimallBrand> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        MultimallBrandExample example = new MultimallBrandExample();
        MultimallBrandExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(id)) {
            criteria.andIdEqualTo(Integer.valueOf(id));
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return brandMapper.selectByExample(example);
    }

    public int updateById(MultimallBrand brand) {
        brand.setUpdateTime(LocalDateTime.now());
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    public void deleteById(Integer id) {
        brandMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(MultimallBrand brand) {
        brand.setAddTime(LocalDateTime.now());
        brand.setUpdateTime(LocalDateTime.now());
        brandMapper.insertSelective(brand);
    }

    public List<MultimallBrand> all() {
        MultimallBrandExample example = new MultimallBrandExample();
        example.or().andDeletedEqualTo(false);
        return brandMapper.selectByExample(example);
    }
}
