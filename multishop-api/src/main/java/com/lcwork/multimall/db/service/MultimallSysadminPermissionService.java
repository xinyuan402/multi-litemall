package com.lcwork.multimall.db.service;

import com.lcwork.multimall.db.dao.generate.MultimallSysadminPermissionMapper;
import com.lcwork.multimall.db.domain.generate.MultimallSysadminPermission;
import com.lcwork.multimall.db.domain.generate.MultimallSysadminPermissionExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MultimallSysadminPermissionService {
    @Resource
    private MultimallSysadminPermissionMapper permissionMapper;

    public Set<String> queryByRoleIds(Integer[] roleIds) {
        Set<String> permissions = new HashSet<String>();
        if (roleIds.length == 0) {
            return permissions;
        }

        MultimallSysadminPermissionExample example = new MultimallSysadminPermissionExample();
        example.or().andRoleIdIn(Arrays.asList(roleIds)).andDeletedEqualTo(false);
        List<MultimallSysadminPermission> permissionList = permissionMapper.selectByExample(example);

        for (MultimallSysadminPermission permission : permissionList) {
            permissions.add(permission.getPermission());
        }

        return permissions;
    }


    public Set<String> queryByRoleId(Integer roleId) {
        Set<String> permissions = new HashSet<String>();
        if (roleId == null) {
            return permissions;
        }

        MultimallSysadminPermissionExample example = new MultimallSysadminPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        List<MultimallSysadminPermission> permissionList = permissionMapper.selectByExample(example);

        for (MultimallSysadminPermission permission : permissionList) {
            permissions.add(permission.getPermission());
        }

        return permissions;
    }

    public boolean checkSuperPermission(Integer roleId) {
        if (roleId == null) {
            return false;
        }

        MultimallSysadminPermissionExample example = new MultimallSysadminPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andPermissionEqualTo("*").andDeletedEqualTo(false);
        return permissionMapper.countByExample(example) != 0;
    }

    public void deleteByRoleId(Integer roleId) {
        MultimallSysadminPermissionExample example = new MultimallSysadminPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        permissionMapper.logicalDeleteByExample(example);
    }

    public void add(MultimallSysadminPermission MultimallSysadminPermission) {
        MultimallSysadminPermission.setAddTime(LocalDateTime.now());
        MultimallSysadminPermission.setUpdateTime(LocalDateTime.now());
        permissionMapper.insertSelective(MultimallSysadminPermission);
    }
}
