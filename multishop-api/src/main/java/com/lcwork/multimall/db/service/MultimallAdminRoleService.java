package com.lcwork.multimall.db.service;

import com.github.pagehelper.PageHelper;
import com.lcwork.multimall.db.dao.generate.MultimallAdminRoleMapper;
import com.lcwork.multimall.db.domain.generate.MultimallAdminRole;
import com.lcwork.multimall.db.domain.generate.MultimallAdminRoleExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MultimallAdminRoleService {
    @Resource
    private MultimallAdminRoleMapper roleMapper;


    public Set<String> queryByIds(Integer[] roleIds) {
        Set<String> roles = new HashSet<String>();
        if (roleIds.length == 0) {
            return roles;
        }

        MultimallAdminRoleExample example = new MultimallAdminRoleExample();
        example.or().andIdIn(Arrays.asList(roleIds)).andEnabledEqualTo(true).andDeletedEqualTo(false);
        List<MultimallAdminRole> roleList = roleMapper.selectByExample(example);

        for (MultimallAdminRole role : roleList) {
            roles.add(role.getName());
        }

        return roles;

    }

    public List<MultimallAdminRole> querySelective(String name, Integer page, Integer limit, String sort, String order) {
        MultimallAdminRoleExample example = new MultimallAdminRoleExample();
        MultimallAdminRoleExample.Criteria criteria = example.createCriteria();

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

    public MultimallAdminRole findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public void add(MultimallAdminRole role) {
        role.setAddTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.insertSelective(role);
    }

    public void deleteById(Integer id) {
        roleMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(MultimallAdminRole role) {
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.updateByPrimaryKeySelective(role);
    }

    public boolean checkExist(String name) {
        MultimallAdminRoleExample example = new MultimallAdminRoleExample();
        example.or().andNameEqualTo(name).andDeletedEqualTo(false);
        return roleMapper.countByExample(example) != 0;
    }

    public List<MultimallAdminRole> queryAll() {
        MultimallAdminRoleExample example = new MultimallAdminRoleExample();
        example.or().andDeletedEqualTo(false);
        return roleMapper.selectByExample(example);
    }
}
