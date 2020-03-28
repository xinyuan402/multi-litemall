package com.lcwork.multimall.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.lcwork.multimall.db.dao.generate.MultimallSysadminRoleMapper;
import com.lcwork.multimall.db.domain.generate.MultimallSysadminRole;
import com.lcwork.multimall.db.domain.generate.MultimallSysadminRoleExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MultimallSysadminRoleService {
    @Resource
    private MultimallSysadminRoleMapper roleMapper;


    public Set<String> queryByIds(Integer[] roleIds) {
        Set<String> roles = new HashSet<String>();
        if (roleIds.length == 0) {
            return roles;
        }

        MultimallSysadminRoleExample example = new MultimallSysadminRoleExample();
        example.or().andIdIn(Arrays.asList(roleIds)).andEnabledEqualTo(true).andDeletedEqualTo(false);
        List<MultimallSysadminRole> roleList = roleMapper.selectByExample(example);

        for (MultimallSysadminRole role : roleList) {
            roles.add(role.getName());
        }

        return roles;

    }

    public List<MultimallSysadminRole> querySelective(String name, Integer page, Integer limit, String sort, String order) {
        MultimallSysadminRoleExample example = new MultimallSysadminRoleExample();
        MultimallSysadminRoleExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return roleMapper.selectByExample(example);
    }

    public MultimallSysadminRole findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public void add(MultimallSysadminRole role) {
        role.setAddTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.insertSelective(role);
    }

    public void deleteById(Integer id) {
        roleMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(MultimallSysadminRole role) {
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.updateByPrimaryKeySelective(role);
    }

    public boolean checkExist(String name) {
        MultimallSysadminRoleExample example = new MultimallSysadminRoleExample();
        example.or().andNameEqualTo(name).andDeletedEqualTo(false);
        return roleMapper.countByExample(example) != 0;
    }

    public List<MultimallSysadminRole> queryAll() {
        MultimallSysadminRoleExample example = new MultimallSysadminRoleExample();
        example.or().andDeletedEqualTo(false);
        return roleMapper.selectByExample(example);
    }
}
