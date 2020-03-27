package com.lcwork.multishop.db.service;

import com.github.pagehelper.PageHelper;
import com.lcwork.multishop.db.dao.generate.LitemallSysadminNoticeSysadminMapper;
import com.lcwork.multishop.db.domain.generate.LitemallSysadminNoticeSysadmin;
import com.lcwork.multishop.db.domain.generate.LitemallSysadminNoticeSysadminExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LitemallSysadminNoticeSysadminService {
    @Resource
    private LitemallSysadminNoticeSysadminMapper noticeAdminMapper;

    public List<LitemallSysadminNoticeSysadmin> querySelective(String title, String type, Integer adminId, Integer page, Integer limit, String sort, String order) {
        LitemallSysadminNoticeSysadminExample example = new LitemallSysadminNoticeSysadminExample();
        LitemallSysadminNoticeSysadminExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(title)) {
            criteria.andNoticeTitleLike("%" + title + "%");
        }

        if (type.equals("read")) {
            criteria.andReadTimeIsNotNull();
        } else if (type.equals("unread")) {
            criteria.andReadTimeIsNull();
        }
        criteria.andSysadminIdEqualTo(adminId);
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return noticeAdminMapper.selectByExample(example);
    }

    public LitemallSysadminNoticeSysadmin find(Integer noticeId, Integer adminId) {
        LitemallSysadminNoticeSysadminExample example = new LitemallSysadminNoticeSysadminExample();
        example.or().andNoticeIdEqualTo(noticeId).andSysadminIdEqualTo(adminId).andDeletedEqualTo(false);
        return noticeAdminMapper.selectOneByExample(example);
    }

    public void add(LitemallSysadminNoticeSysadmin noticeAdmin) {
        noticeAdmin.setAddTime(LocalDateTime.now());
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdminMapper.insertSelective(noticeAdmin);
    }

    public void update(LitemallSysadminNoticeSysadmin noticeAdmin) {
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdminMapper.updateByPrimaryKeySelective(noticeAdmin);
    }

    public void markReadByIds(List<Integer> ids, Integer adminId) {
        LitemallSysadminNoticeSysadminExample example = new LitemallSysadminNoticeSysadminExample();
        example.or().andIdIn(ids).andSysadminIdEqualTo(adminId).andDeletedEqualTo(false);
        LitemallSysadminNoticeSysadmin noticeAdmin = new LitemallSysadminNoticeSysadmin();
        LocalDateTime now = LocalDateTime.now();
        noticeAdmin.setReadTime(now);
        noticeAdmin.setUpdateTime(now);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public void deleteById(Integer id, Integer adminId) {
        LitemallSysadminNoticeSysadminExample example = new LitemallSysadminNoticeSysadminExample();
        example.or().andIdEqualTo(id).andSysadminIdEqualTo(adminId).andDeletedEqualTo(false);
        LitemallSysadminNoticeSysadmin noticeAdmin = new LitemallSysadminNoticeSysadmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public void deleteByIds(List<Integer> ids, Integer adminId) {
        LitemallSysadminNoticeSysadminExample example = new LitemallSysadminNoticeSysadminExample();
        example.or().andIdIn(ids).andSysadminIdEqualTo(adminId).andDeletedEqualTo(false);
        LitemallSysadminNoticeSysadmin noticeAdmin = new LitemallSysadminNoticeSysadmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public int countUnread(Integer adminId) {
        LitemallSysadminNoticeSysadminExample example = new LitemallSysadminNoticeSysadminExample();
        example.or().andSysadminIdEqualTo(adminId).andReadTimeIsNull().andDeletedEqualTo(false);
        return (int) noticeAdminMapper.countByExample(example);
    }

    public List<LitemallSysadminNoticeSysadmin> queryByNoticeId(Integer noticeId) {
        LitemallSysadminNoticeSysadminExample example = new LitemallSysadminNoticeSysadminExample();
        example.or().andNoticeIdEqualTo(noticeId).andDeletedEqualTo(false);
        return noticeAdminMapper.selectByExample(example);
    }

    public void deleteByNoticeId(Integer id) {
        LitemallSysadminNoticeSysadminExample example = new LitemallSysadminNoticeSysadminExample();
        example.or().andNoticeIdEqualTo(id).andDeletedEqualTo(false);
        LitemallSysadminNoticeSysadmin noticeAdmin = new LitemallSysadminNoticeSysadmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public void deleteByNoticeIds(List<Integer> ids) {
        LitemallSysadminNoticeSysadminExample example = new LitemallSysadminNoticeSysadminExample();
        example.or().andNoticeIdIn(ids).andDeletedEqualTo(false);
        LitemallSysadminNoticeSysadmin noticeAdmin = new LitemallSysadminNoticeSysadmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public int countReadByNoticeId(Integer noticeId) {
        LitemallSysadminNoticeSysadminExample example = new LitemallSysadminNoticeSysadminExample();
        example.or().andNoticeIdEqualTo(noticeId).andReadTimeIsNotNull().andDeletedEqualTo(false);
        return (int) noticeAdminMapper.countByExample(example);
    }

    public void updateByNoticeId(LitemallSysadminNoticeSysadmin noticeAdmin, Integer noticeId) {
        LitemallSysadminNoticeSysadminExample example = new LitemallSysadminNoticeSysadminExample();
        example.or().andNoticeIdEqualTo(noticeId).andDeletedEqualTo(false);
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }
}
