package com.lcwork.multishop.db.service;

import com.lcwork.multishop.db.dao.generate.LitemallAdminPermissionMapper;
import com.lcwork.multishop.db.domain.generate.LitemallAdminPermission;
import com.lcwork.multishop.db.domain.generate.LitemallAdminPermissionExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LitemallAdminPermissionService {
    @Resource
    private LitemallAdminPermissionMapper permissionMapper;

    public Set<String> queryByRoleIds(Integer[] roleIds) {
        Set<String> permissions = new HashSet<String>();
        if (roleIds.length == 0) {
            return permissions;
        }

        LitemallAdminPermissionExample example = new LitemallAdminPermissionExample();
        example.or().andRoleIdIn(Arrays.asList(roleIds)).andDeletedEqualTo(false);
        List<LitemallAdminPermission> permissionList = permissionMapper.selectByExample(example);

        for (LitemallAdminPermission permission : permissionList) {
            permissions.add(permission.getPermission());
        }

        return permissions;
    }


    public Set<String> queryByRoleId(Integer roleId) {
        Set<String> permissions = new HashSet<String>();
        if (roleId == null) {
            return permissions;
        }

        LitemallAdminPermissionExample example = new LitemallAdminPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        List<LitemallAdminPermission> permissionList = permissionMapper.selectByExample(example);

        for (LitemallAdminPermission permission : permissionList) {
            permissions.add(permission.getPermission());
        }

        return permissions;
    }

    public boolean checkSuperPermission(Integer roleId) {
        if (roleId == null) {
            return false;
        }

        LitemallAdminPermissionExample example = new LitemallAdminPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andPermissionEqualTo("*").andDeletedEqualTo(false);
        return permissionMapper.countByExample(example) != 0;
    }

    public void deleteByRoleId(Integer roleId) {
        LitemallAdminPermissionExample example = new LitemallAdminPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        permissionMapper.logicalDeleteByExample(example);
    }

    public void add(LitemallAdminPermission litemallAdminPermission) {
        litemallAdminPermission.setAddTime(LocalDateTime.now());
        litemallAdminPermission.setUpdateTime(LocalDateTime.now());
        permissionMapper.insertSelective(litemallAdminPermission);
    }
}
