package com.lcwork.multishop.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.lcwork.multishop.db.dao.generate.LitemallSysadminRoleMapper;
import com.lcwork.multishop.db.domain.generate.LitemallSysadminRole;
import com.lcwork.multishop.db.domain.generate.LitemallSysadminRoleExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LitemallSysadminRoleService {
    @Resource
    private LitemallSysadminRoleMapper roleMapper;


    public Set<String> queryByIds(Integer[] roleIds) {
        Set<String> roles = new HashSet<String>();
        if (roleIds.length == 0) {
            return roles;
        }

        LitemallSysadminRoleExample example = new LitemallSysadminRoleExample();
        example.or().andIdIn(Arrays.asList(roleIds)).andEnabledEqualTo(true).andDeletedEqualTo(false);
        List<LitemallSysadminRole> roleList = roleMapper.selectByExample(example);

        for (LitemallSysadminRole role : roleList) {
            roles.add(role.getName());
        }

        return roles;

    }

    public List<LitemallSysadminRole> querySelective(String name, Integer page, Integer limit, String sort, String order) {
        LitemallSysadminRoleExample example = new LitemallSysadminRoleExample();
        LitemallSysadminRoleExample.Criteria criteria = example.createCriteria();

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

    public LitemallSysadminRole findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public void add(LitemallSysadminRole role) {
        role.setAddTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.insertSelective(role);
    }

    public void deleteById(Integer id) {
        roleMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(LitemallSysadminRole role) {
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.updateByPrimaryKeySelective(role);
    }

    public boolean checkExist(String name) {
        LitemallSysadminRoleExample example = new LitemallSysadminRoleExample();
        example.or().andNameEqualTo(name).andDeletedEqualTo(false);
        return roleMapper.countByExample(example) != 0;
    }

    public List<LitemallSysadminRole> queryAll() {
        LitemallSysadminRoleExample example = new LitemallSysadminRoleExample();
        example.or().andDeletedEqualTo(false);
        return roleMapper.selectByExample(example);
    }
}
