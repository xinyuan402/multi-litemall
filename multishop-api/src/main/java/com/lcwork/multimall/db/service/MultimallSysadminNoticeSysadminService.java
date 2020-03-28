package com.lcwork.multimall.db.service;

import com.github.pagehelper.PageHelper;
import com.lcwork.multimall.db.dao.generate.MultimallSysadminNoticeSysadminMapper;
import com.lcwork.multimall.db.domain.generate.MultimallSysadminNoticeSysadmin;
import com.lcwork.multimall.db.domain.generate.MultimallSysadminNoticeSysadminExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MultimallSysadminNoticeSysadminService {
    @Resource
    private MultimallSysadminNoticeSysadminMapper noticeAdminMapper;

    public List<MultimallSysadminNoticeSysadmin> querySelective(String title, String type, Integer adminId, Integer page, Integer limit, String sort, String order) {
        MultimallSysadminNoticeSysadminExample example = new MultimallSysadminNoticeSysadminExample();
        MultimallSysadminNoticeSysadminExample.Criteria criteria = example.createCriteria();

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

    public MultimallSysadminNoticeSysadmin find(Integer noticeId, Integer adminId) {
        MultimallSysadminNoticeSysadminExample example = new MultimallSysadminNoticeSysadminExample();
        example.or().andNoticeIdEqualTo(noticeId).andSysadminIdEqualTo(adminId).andDeletedEqualTo(false);
        return noticeAdminMapper.selectOneByExample(example);
    }

    public void add(MultimallSysadminNoticeSysadmin noticeAdmin) {
        noticeAdmin.setAddTime(LocalDateTime.now());
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdminMapper.insertSelective(noticeAdmin);
    }

    public void update(MultimallSysadminNoticeSysadmin noticeAdmin) {
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdminMapper.updateByPrimaryKeySelective(noticeAdmin);
    }

    public void markReadByIds(List<Integer> ids, Integer adminId) {
        MultimallSysadminNoticeSysadminExample example = new MultimallSysadminNoticeSysadminExample();
        example.or().andIdIn(ids).andSysadminIdEqualTo(adminId).andDeletedEqualTo(false);
        MultimallSysadminNoticeSysadmin noticeAdmin = new MultimallSysadminNoticeSysadmin();
        LocalDateTime now = LocalDateTime.now();
        noticeAdmin.setReadTime(now);
        noticeAdmin.setUpdateTime(now);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public void deleteById(Integer id, Integer adminId) {
        MultimallSysadminNoticeSysadminExample example = new MultimallSysadminNoticeSysadminExample();
        example.or().andIdEqualTo(id).andSysadminIdEqualTo(adminId).andDeletedEqualTo(false);
        MultimallSysadminNoticeSysadmin noticeAdmin = new MultimallSysadminNoticeSysadmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public void deleteByIds(List<Integer> ids, Integer adminId) {
        MultimallSysadminNoticeSysadminExample example = new MultimallSysadminNoticeSysadminExample();
        example.or().andIdIn(ids).andSysadminIdEqualTo(adminId).andDeletedEqualTo(false);
        MultimallSysadminNoticeSysadmin noticeAdmin = new MultimallSysadminNoticeSysadmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public int countUnread(Integer adminId) {
        MultimallSysadminNoticeSysadminExample example = new MultimallSysadminNoticeSysadminExample();
        example.or().andSysadminIdEqualTo(adminId).andReadTimeIsNull().andDeletedEqualTo(false);
        return (int) noticeAdminMapper.countByExample(example);
    }

    public List<MultimallSysadminNoticeSysadmin> queryByNoticeId(Integer noticeId) {
        MultimallSysadminNoticeSysadminExample example = new MultimallSysadminNoticeSysadminExample();
        example.or().andNoticeIdEqualTo(noticeId).andDeletedEqualTo(false);
        return noticeAdminMapper.selectByExample(example);
    }

    public void deleteByNoticeId(Integer id) {
        MultimallSysadminNoticeSysadminExample example = new MultimallSysadminNoticeSysadminExample();
        example.or().andNoticeIdEqualTo(id).andDeletedEqualTo(false);
        MultimallSysadminNoticeSysadmin noticeAdmin = new MultimallSysadminNoticeSysadmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public void deleteByNoticeIds(List<Integer> ids) {
        MultimallSysadminNoticeSysadminExample example = new MultimallSysadminNoticeSysadminExample();
        example.or().andNoticeIdIn(ids).andDeletedEqualTo(false);
        MultimallSysadminNoticeSysadmin noticeAdmin = new MultimallSysadminNoticeSysadmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public int countReadByNoticeId(Integer noticeId) {
        MultimallSysadminNoticeSysadminExample example = new MultimallSysadminNoticeSysadminExample();
        example.or().andNoticeIdEqualTo(noticeId).andReadTimeIsNotNull().andDeletedEqualTo(false);
        return (int) noticeAdminMapper.countByExample(example);
    }

    public void updateByNoticeId(MultimallSysadminNoticeSysadmin noticeAdmin, Integer noticeId) {
        MultimallSysadminNoticeSysadminExample example = new MultimallSysadminNoticeSysadminExample();
        example.or().andNoticeIdEqualTo(noticeId).andDeletedEqualTo(false);
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }
}
