package com.lcwork.multimall.db.service;

import com.github.pagehelper.PageHelper;
import com.lcwork.multimall.db.dao.generate.MultimallCategoryMapper;
import com.lcwork.multimall.db.domain.generate.MultimallCategory;
import com.lcwork.multimall.db.domain.generate.MultimallCategoryExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MultimallCategoryService {
    @Resource
    private MultimallCategoryMapper categoryMapper;
    private MultimallCategory.Column[] CHANNEL = {MultimallCategory.Column.id, MultimallCategory.Column.name, MultimallCategory.Column.iconUrl};

    public List<MultimallCategory> queryL1WithoutRecommend(int offset, int limit) {
        MultimallCategoryExample example = new MultimallCategoryExample();
        example.or().andLevelEqualTo("L1").andNameNotEqualTo("推荐").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<MultimallCategory> queryL1(int offset, int limit) {
        MultimallCategoryExample example = new MultimallCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<MultimallCategory> queryL1() {
        MultimallCategoryExample example = new MultimallCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<MultimallCategory> queryByPid(Integer pid) {
        MultimallCategoryExample example = new MultimallCategoryExample();
        example.or().andPidEqualTo(pid).andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<MultimallCategory> queryL2ByIds(List<Integer> ids) {
        MultimallCategoryExample example = new MultimallCategoryExample();
        example.or().andIdIn(ids).andLevelEqualTo("L2").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public MultimallCategory findById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    public List<MultimallCategory> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        MultimallCategoryExample example = new MultimallCategoryExample();
        MultimallCategoryExample.Criteria criteria = example.createCriteria();

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
        return categoryMapper.selectByExample(example);
    }

    public int updateById(MultimallCategory category) {
        category.setUpdateTime(LocalDateTime.now());
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    public void deleteById(Integer id) {
        categoryMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(MultimallCategory category) {
        category.setAddTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.insertSelective(category);
    }

    public List<MultimallCategory> queryChannel() {
        MultimallCategoryExample example = new MultimallCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExampleSelective(example, CHANNEL);
    }
}
