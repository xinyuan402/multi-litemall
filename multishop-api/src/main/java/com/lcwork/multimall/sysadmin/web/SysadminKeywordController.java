package com.lcwork.multimall.sysadmin.web;

import com.lcwork.multimall.core.annotation.RequiresPermissionsDesc;
import com.lcwork.multimall.core.util.ResponseUtil;
import com.lcwork.multimall.core.validator.Order;
import com.lcwork.multimall.core.validator.Sort;
import com.lcwork.multimall.db.domain.generate.MultimallKeyword;
import com.lcwork.multimall.db.service.MultimallKeywordService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/sysadmin/keyword")
@Validated
public class SysadminKeywordController {
    private final Log logger = LogFactory.getLog(SysadminKeywordController.class);

    @Autowired
    private MultimallKeywordService keywordService;

    @RequiresPermissions("sysadmin:keyword:list")
    @RequiresPermissionsDesc(menu = {"商场管理", "关键词"}, button = "查询")
    @GetMapping("/list")
    public Object list(String keyword, String url,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<MultimallKeyword> keywordList = keywordService.querySelective(keyword, url, page, limit, sort, order);
        return ResponseUtil.okList(keywordList);
    }

    private Object validate(MultimallKeyword keywords) {
        String keyword = keywords.getKeyword();
        if (StringUtils.isEmpty(keyword)) {
            return ResponseUtil.badArgument();
        }
        return null;
    }

    @RequiresPermissions("sysadmin:keyword:create")
    @RequiresPermissionsDesc(menu = {"商场管理", "关键词"}, button = "添加")
    @PostMapping("/create")
    public Object create(@RequestBody MultimallKeyword keyword) {
        Object error = validate(keyword);
        if (error != null) {
            return error;
        }
        keywordService.add(keyword);
        return ResponseUtil.ok(keyword);
    }

    @RequiresPermissions("sysadmin:keyword:read")
    @RequiresPermissionsDesc(menu = {"商场管理", "关键词"}, button = "详情")
    @GetMapping("/read")
    public Object read(@NotNull Integer id) {
        MultimallKeyword keyword = keywordService.findById(id);
        return ResponseUtil.ok(keyword);
    }

    @RequiresPermissions("sysadmin:keyword:update")
    @RequiresPermissionsDesc(menu = {"商场管理", "关键词"}, button = "编辑")
    @PostMapping("/update")
    public Object update(@RequestBody MultimallKeyword keyword) {
        Object error = validate(keyword);
        if (error != null) {
            return error;
        }
        if (keywordService.updateById(keyword) == 0) {
            return ResponseUtil.updatedDataFailed();
        }
        return ResponseUtil.ok(keyword);
    }

    @RequiresPermissions("sysadmin:keyword:delete")
    @RequiresPermissionsDesc(menu = {"商场管理", "关键词"}, button = "删除")
    @PostMapping("/delete")
    public Object delete(@RequestBody MultimallKeyword keyword) {
        Integer id = keyword.getId();
        if (id == null) {
            return ResponseUtil.badArgument();
        }
        keywordService.deleteById(id);
        return ResponseUtil.ok();
    }

}
