package org.linlinjava.litemall.db.service;

import org.linlinjava.litemall.db.dao.generate.LitemallSysadminPermissionMapper;
import org.linlinjava.litemall.db.domain.generate.LitemallSysadminPermission;
import org.linlinjava.litemall.db.domain.generate.LitemallSysadminPermissionExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LitemallSysadminPermissionService {
    @Resource
    private LitemallSysadminPermissionMapper permissionMapper;

    public Set<String> queryByRoleIds(Integer[] roleIds) {
        Set<String> permissions = new HashSet<String>();
        if (roleIds.length == 0) {
            return permissions;
        }

        LitemallSysadminPermissionExample example = new LitemallSysadminPermissionExample();
        example.or().andRoleIdIn(Arrays.asList(roleIds)).andDeletedEqualTo(false);
        List<LitemallSysadminPermission> permissionList = permissionMapper.selectByExample(example);

        for (LitemallSysadminPermission permission : permissionList) {
            permissions.add(permission.getPermission());
        }

        return permissions;
    }


    public Set<String> queryByRoleId(Integer roleId) {
        Set<String> permissions = new HashSet<String>();
        if (roleId == null) {
            return permissions;
        }

        LitemallSysadminPermissionExample example = new LitemallSysadminPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        List<LitemallSysadminPermission> permissionList = permissionMapper.selectByExample(example);

        for (LitemallSysadminPermission permission : permissionList) {
            permissions.add(permission.getPermission());
        }

        return permissions;
    }

    public boolean checkSuperPermission(Integer roleId) {
        if (roleId == null) {
            return false;
        }

        LitemallSysadminPermissionExample example = new LitemallSysadminPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andPermissionEqualTo("*").andDeletedEqualTo(false);
        return permissionMapper.countByExample(example) != 0;
    }

    public void deleteByRoleId(Integer roleId) {
        LitemallSysadminPermissionExample example = new LitemallSysadminPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        permissionMapper.logicalDeleteByExample(example);
    }

    public void add(LitemallSysadminPermission LitemallSysadminPermission) {
        LitemallSysadminPermission.setAddTime(LocalDateTime.now());
        LitemallSysadminPermission.setUpdateTime(LocalDateTime.now());
        permissionMapper.insertSelective(LitemallSysadminPermission);
    }
}
