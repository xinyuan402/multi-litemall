package com.lcwork.multishop.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.lcwork.multishop.db.dao.generate.LitemallAdminRoleMapper;
import com.lcwork.multishop.db.domain.generate.LitemallAdminRole;
import com.lcwork.multishop.db.domain.generate.LitemallAdminRoleExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LitemallAdminRoleService {
    @Resource
    private LitemallAdminRoleMapper roleMapper;


    public Set<String> queryByIds(Integer[] roleIds) {
        Set<String> roles = new HashSet<String>();
        if (roleIds.length == 0) {
            return roles;
        }

        LitemallAdminRoleExample example = new LitemallAdminRoleExample();
        example.or().andIdIn(Arrays.asList(roleIds)).andEnabledEqualTo(true).andDeletedEqualTo(false);
        List<LitemallAdminRole> roleList = roleMapper.selectByExample(example);

        for (LitemallAdminRole role : roleList) {
            roles.add(role.getName());
        }

        return roles;

    }

    public List<LitemallAdminRole> querySelective(String name, Integer page, Integer limit, String sort, String order) {
        LitemallAdminRoleExample example = new LitemallAdminRoleExample();
        LitemallAdminRoleExample.Criteria criteria = example.createCriteria();

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

    public LitemallAdminRole findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public void add(LitemallAdminRole role) {
        role.setAddTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.insertSelective(role);
    }

    public void deleteById(Integer id) {
        roleMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(LitemallAdminRole role) {
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.updateByPrimaryKeySelective(role);
    }

    public boolean checkExist(String name) {
        LitemallAdminRoleExample example = new LitemallAdminRoleExample();
        example.or().andNameEqualTo(name).andDeletedEqualTo(false);
        return roleMapper.countByExample(example) != 0;
    }

    public List<LitemallAdminRole> queryAll() {
        LitemallAdminRoleExample example = new LitemallAdminRoleExample();
        example.or().andDeletedEqualTo(false);
        return roleMapper.selectByExample(example);
    }
}
