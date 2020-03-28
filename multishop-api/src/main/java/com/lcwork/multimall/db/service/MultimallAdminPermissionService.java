package com.lcwork.multimall.db.service;

import com.lcwork.multimall.db.dao.generate.MultimallAdminPermissionMapper;
import com.lcwork.multimall.db.domain.generate.MultimallAdminPermission;
import com.lcwork.multimall.db.domain.generate.MultimallAdminPermissionExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MultimallAdminPermissionService {
    @Resource
    private MultimallAdminPermissionMapper permissionMapper;

    public Set<String> queryByRoleIds(Integer[] roleIds) {
        Set<String> permissions = new HashSet<String>();
        if (roleIds.length == 0) {
            return permissions;
        }

        MultimallAdminPermissionExample example = new MultimallAdminPermissionExample();
        example.or().andRoleIdIn(Arrays.asList(roleIds)).andDeletedEqualTo(false);
        List<MultimallAdminPermission> permissionList = permissionMapper.selectByExample(example);

        for (MultimallAdminPermission permission : permissionList) {
            permissions.add(permission.getPermission());
        }

        return permissions;
    }


    public Set<String> queryByRoleId(Integer roleId) {
        Set<String> permissions = new HashSet<String>();
        if (roleId == null) {
            return permissions;
        }

        MultimallAdminPermissionExample example = new MultimallAdminPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        List<MultimallAdminPermission> permissionList = permissionMapper.selectByExample(example);

        for (MultimallAdminPermission permission : permissionList) {
            permissions.add(permission.getPermission());
        }

        return permissions;
    }

    public boolean checkSuperPermission(Integer roleId) {
        if (roleId == null) {
            return false;
        }

        MultimallAdminPermissionExample example = new MultimallAdminPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andPermissionEqualTo("*").andDeletedEqualTo(false);
        return permissionMapper.countByExample(example) != 0;
    }

    public void deleteByRoleId(Integer roleId) {
        MultimallAdminPermissionExample example = new MultimallAdminPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        permissionMapper.logicalDeleteByExample(example);
    }

    public void add(MultimallAdminPermission litemallAdminPermission) {
        litemallAdminPermission.setAddTime(LocalDateTime.now());
        litemallAdminPermission.setUpdateTime(LocalDateTime.now());
        permissionMapper.insertSelective(litemallAdminPermission);
    }
}
