package com.lcwork.multimall.db.service;

import com.github.pagehelper.PageHelper;
import com.lcwork.multimall.db.dao.generate.MultimallAdminNoticeAdminMapper;
import com.lcwork.multimall.db.domain.generate.MultimallAdminNoticeAdmin;
import com.lcwork.multimall.db.domain.generate.MultimallAdminNoticeAdminExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MultimallAdminNoticeAdminService {
    @Resource
    private MultimallAdminNoticeAdminMapper noticeAdminMapper;

    public List<MultimallAdminNoticeAdmin> querySelective(String title, String type, Integer adminId, Integer page, Integer limit, String sort, String order) {
        MultimallAdminNoticeAdminExample example = new MultimallAdminNoticeAdminExample();
        MultimallAdminNoticeAdminExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(title)) {
            criteria.andNoticeTitleLike("%" + title + "%");
        }

        if (type.equals("read")) {
            criteria.andReadTimeIsNotNull();
        } else if (type.equals("unread")) {
            criteria.andReadTimeIsNull();
        }
        criteria.andAdminIdEqualTo(adminId);
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return noticeAdminMapper.selectByExample(example);
    }

    public MultimallAdminNoticeAdmin find(Integer noticeId, Integer adminId) {
        MultimallAdminNoticeAdminExample example = new MultimallAdminNoticeAdminExample();
        example.or().andNoticeIdEqualTo(noticeId).andAdminIdEqualTo(adminId).andDeletedEqualTo(false);
        return noticeAdminMapper.selectOneByExample(example);
    }

    public void add(MultimallAdminNoticeAdmin noticeAdmin) {
        noticeAdmin.setAddTime(LocalDateTime.now());
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdminMapper.insertSelective(noticeAdmin);
    }

    public void update(MultimallAdminNoticeAdmin noticeAdmin) {
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdminMapper.updateByPrimaryKeySelective(noticeAdmin);
    }

    public void markReadByIds(List<Integer> ids, Integer adminId) {
        MultimallAdminNoticeAdminExample example = new MultimallAdminNoticeAdminExample();
        example.or().andIdIn(ids).andAdminIdEqualTo(adminId).andDeletedEqualTo(false);
        MultimallAdminNoticeAdmin noticeAdmin = new MultimallAdminNoticeAdmin();
        LocalDateTime now = LocalDateTime.now();
        noticeAdmin.setReadTime(now);
        noticeAdmin.setUpdateTime(now);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public void deleteById(Integer id, Integer adminId) {
        MultimallAdminNoticeAdminExample example = new MultimallAdminNoticeAdminExample();
        example.or().andIdEqualTo(id).andAdminIdEqualTo(adminId).andDeletedEqualTo(false);
        MultimallAdminNoticeAdmin noticeAdmin = new MultimallAdminNoticeAdmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public void deleteByIds(List<Integer> ids, Integer adminId) {
        MultimallAdminNoticeAdminExample example = new MultimallAdminNoticeAdminExample();
        example.or().andIdIn(ids).andAdminIdEqualTo(adminId).andDeletedEqualTo(false);
        MultimallAdminNoticeAdmin noticeAdmin = new MultimallAdminNoticeAdmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public int countUnread(Integer adminId) {
        MultimallAdminNoticeAdminExample example = new MultimallAdminNoticeAdminExample();
        example.or().andAdminIdEqualTo(adminId).andReadTimeIsNull().andDeletedEqualTo(false);
        return (int) noticeAdminMapper.countByExample(example);
    }

    public List<MultimallAdminNoticeAdmin> queryByNoticeId(Integer noticeId) {
        MultimallAdminNoticeAdminExample example = new MultimallAdminNoticeAdminExample();
        example.or().andNoticeIdEqualTo(noticeId).andDeletedEqualTo(false);
        return noticeAdminMapper.selectByExample(example);
    }

    public void deleteByNoticeId(Integer id) {
        MultimallAdminNoticeAdminExample example = new MultimallAdminNoticeAdminExample();
        example.or().andNoticeIdEqualTo(id).andDeletedEqualTo(false);
        MultimallAdminNoticeAdmin noticeAdmin = new MultimallAdminNoticeAdmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public void deleteByNoticeIds(List<Integer> ids) {
        MultimallAdminNoticeAdminExample example = new MultimallAdminNoticeAdminExample();
        example.or().andNoticeIdIn(ids).andDeletedEqualTo(false);
        MultimallAdminNoticeAdmin noticeAdmin = new MultimallAdminNoticeAdmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public int countReadByNoticeId(Integer noticeId) {
        MultimallAdminNoticeAdminExample example = new MultimallAdminNoticeAdminExample();
        example.or().andNoticeIdEqualTo(noticeId).andReadTimeIsNotNull().andDeletedEqualTo(false);
        return (int) noticeAdminMapper.countByExample(example);
    }

    public void updateByNoticeId(MultimallAdminNoticeAdmin noticeAdmin, Integer noticeId) {
        MultimallAdminNoticeAdminExample example = new MultimallAdminNoticeAdminExample();
        example.or().andNoticeIdEqualTo(noticeId).andDeletedEqualTo(false);
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }
}
