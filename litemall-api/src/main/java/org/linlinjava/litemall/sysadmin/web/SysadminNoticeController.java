package org.linlinjava.litemall.sysadmin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.linlinjava.litemall.core.annotation.RequiresPermissionsDesc;
import org.linlinjava.litemall.core.util.JacksonUtil;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.core.validator.Order;
import org.linlinjava.litemall.core.validator.Sort;
import org.linlinjava.litemall.db.domain.generate.LitemallAdmin;
import org.linlinjava.litemall.db.domain.generate.LitemallAdminNotice;
import org.linlinjava.litemall.db.domain.generate.LitemallAdminNoticeAdmin;
import org.linlinjava.litemall.db.service.LitemallAdminService;
import org.linlinjava.litemall.db.service.LitemallAdminNoticeAdminService;
import org.linlinjava.litemall.db.service.LitemallAdminNoticeService;
import org.linlinjava.litemall.sysadmin.util.SysadminResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sysadmin/notice")
@Validated
public class SysadminNoticeController {
    private final Log logger = LogFactory.getLog(SysadminNoticeController.class);

    @Autowired
    private LitemallAdminNoticeService noticeService;
    @Autowired
    private LitemallAdminService adminService;
    @Autowired
    private LitemallAdminNoticeAdminService noticeAdminService;

    @RequiresPermissions("sysadmin:notice:list")
    @RequiresPermissionsDesc(menu = {"系统管理", "通知管理"}, button = "查询")
    @GetMapping("/list")
    public Object list(String title, String content,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<LitemallAdminNotice> noticeList = noticeService.querySelective(title, content, page, limit, sort, order);
        return ResponseUtil.okList(noticeList);
    }

    private Object validate(LitemallAdminNotice notice) {
        String title = notice.getTitle();
        if (StringUtils.isEmpty(title)) {
            return ResponseUtil.badArgument();
        }
        return null;
    }

    private Integer getAdminId() {
        Subject currentUser = SecurityUtils.getSubject();
        LitemallAdmin admin = (LitemallAdmin) currentUser.getPrincipal();
        return admin.getId();
    }

    @RequiresPermissions("sysadmin:notice:create")
    @RequiresPermissionsDesc(menu = {"推广管理", "通知管理"}, button = "添加")
    @PostMapping("/create")
    public Object create(@RequestBody LitemallAdminNotice notice) {
        Object error = validate(notice);
        if (error != null) {
            return error;
        }
        // 1. 添加通知记录
        notice.setAdminId(getAdminId());
        noticeService.add(notice);
        // 2. 添加管理员通知记录
        List<LitemallAdmin> adminList = adminService.all();
        LitemallAdminNoticeAdmin noticeAdmin = new LitemallAdminNoticeAdmin();
        noticeAdmin.setNoticeId(notice.getId());
        noticeAdmin.setNoticeTitle(notice.getTitle());
        for (LitemallAdmin admin : adminList) {
            noticeAdmin.setAdminId(admin.getId());
            noticeAdminService.add(noticeAdmin);
        }
        return ResponseUtil.ok(notice);
    }

    @RequiresPermissions("sysadmin:notice:read")
    @RequiresPermissionsDesc(menu = {"推广管理", "通知管理"}, button = "详情")
    @GetMapping("/read")
    public Object read(@NotNull Integer id) {
        LitemallAdminNotice notice = noticeService.findById(id);
        List<LitemallAdminNoticeAdmin> noticeAdminList = noticeAdminService.queryByNoticeId(id);
        Map<String, Object> data = new HashMap<>(2);
        data.put("notice", notice);
        data.put("noticeAdminList", noticeAdminList);
        return ResponseUtil.ok(data);
    }

    @RequiresPermissions("sysadmin:notice:update")
    @RequiresPermissionsDesc(menu = {"推广管理", "通知管理"}, button = "编辑")
    @PostMapping("/update")
    public Object update(@RequestBody LitemallAdminNotice notice) {
        Object error = validate(notice);
        if (error != null) {
            return error;
        }
        LitemallAdminNotice originalNotice = noticeService.findById(notice.getId());
        if (originalNotice == null) {
            return ResponseUtil.badArgument();
        }
        // 如果通知已经有人阅读过，则不支持编辑
        if (noticeAdminService.countReadByNoticeId(notice.getId()) > 0) {
            return ResponseUtil.fail(SysadminResponseCode.NOTICE_UPDATE_NOT_ALLOWED, "通知已被阅读，不能重新编辑");
        }
        // 1. 更新通知记录
        notice.setAdminId(getAdminId());
        noticeService.updateById(notice);
        // 2. 更新管理员通知记录
        if (!originalNotice.getTitle().equals(notice.getTitle())) {
            LitemallAdminNoticeAdmin noticeAdmin = new LitemallAdminNoticeAdmin();
            noticeAdmin.setNoticeTitle(notice.getTitle());
            noticeAdminService.updateByNoticeId(noticeAdmin, notice.getId());
        }
        return ResponseUtil.ok(notice);
    }

    @RequiresPermissions("sysadmin:notice:delete")
    @RequiresPermissionsDesc(menu = {"推广管理", "通知管理"}, button = "删除")
    @PostMapping("/delete")
    public Object delete(@RequestBody LitemallAdminNotice notice) {
        // 1. 删除通知管理员记录
        noticeAdminService.deleteByNoticeId(notice.getId());
        // 2. 删除通知记录
        noticeService.deleteById(notice.getId());
        return ResponseUtil.ok();
    }

    @RequiresPermissions("sysadmin:notice:batch-delete")
    @RequiresPermissionsDesc(menu = {"推广管理", "通知管理"}, button = "批量删除")
    @PostMapping("/batch-delete")
    public Object batchDelete(@RequestBody String body) {
        List<Integer> ids = JacksonUtil.parseIntegerList(body, "ids");
        // 1. 删除通知管理员记录
        noticeAdminService.deleteByNoticeIds(ids);
        // 2. 删除通知记录
        noticeService.deleteByIds(ids);
        return ResponseUtil.ok();
    }
}
