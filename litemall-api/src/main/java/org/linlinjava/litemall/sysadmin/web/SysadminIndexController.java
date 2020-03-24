package org.linlinjava.litemall.sysadmin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.*;
import org.linlinjava.litemall.core.annotation.RequiresPermissionsDesc;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sysadmin/index")
public class SysadminIndexController {
    private final Log logger = LogFactory.getLog(SysadminIndexController.class);

    @RequestMapping("/index")
    public Object index() {
        return ResponseUtil.ok("hello world, this is admin service");
    }

    @RequiresGuest
    @RequestMapping("/guest")
    public Object guest() {
        return ResponseUtil.ok("hello world, this is admin service");
    }

    @RequiresAuthentication
    @RequestMapping("/authn")
    public Object authn() {
        return ResponseUtil.ok("hello world, this is admin service");
    }

    @RequiresUser
    @RequestMapping("/user")
    public Object user() {
        return ResponseUtil.ok("hello world, this is admin service");
    }

    @RequiresRoles("admin")
    @RequestMapping("/admin")
    public Object admin() {
        return ResponseUtil.ok("hello world, this is admin service");
    }

    @RequiresRoles("admin2")
    @RequestMapping("/admin2")
    public Object admin2() {
        return ResponseUtil.ok("hello world, this is admin service");
    }

    @RequiresPermissions("index:permission:read")
    @RequiresPermissionsDesc(menu = {"其他", "权限测试"}, button = "权限读")
    @GetMapping("/read")
    public Object read() {
        return ResponseUtil.ok("hello world, this is admin service");
    }

    @RequiresPermissions("index:permission:write")
    @RequiresPermissionsDesc(menu = {"其他", "权限测试"}, button = "权限写")
    @PostMapping("/write")
    public Object write() {
        return ResponseUtil.ok("hello world, this is admin service");
    }

}
