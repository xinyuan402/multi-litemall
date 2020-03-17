package org.linlinjava.litemall.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.litemall.db.dao.generate.LitemallAdminNoticeAdminMapper;
import org.linlinjava.litemall.db.domain.generate.LitemallAdminNoticeAdmin;
import org.linlinjava.litemall.db.domain.generate.LitemallAdminNoticeAdminExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LitemallNoticeAdminService {
    @Resource
    private LitemallAdminNoticeAdminMapper noticeAdminMapper;

    public List<LitemallAdminNoticeAdmin> querySelective(String title, String type, Integer adminId, Integer page, Integer limit, String sort, String order) {
        LitemallAdminNoticeAdminExample example = new LitemallAdminNoticeAdminExample();
        LitemallAdminNoticeAdminExample.Criteria criteria = example.createCriteria();

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

    public LitemallAdminNoticeAdmin find(Integer noticeId, Integer adminId) {
        LitemallAdminNoticeAdminExample example = new LitemallAdminNoticeAdminExample();
        example.or().andNoticeIdEqualTo(noticeId).andAdminIdEqualTo(adminId).andDeletedEqualTo(false);
        return noticeAdminMapper.selectOneByExample(example);
    }

    public void add(LitemallAdminNoticeAdmin noticeAdmin) {
        noticeAdmin.setAddTime(LocalDateTime.now());
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdminMapper.insertSelective(noticeAdmin);
    }

    public void update(LitemallAdminNoticeAdmin noticeAdmin) {
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdminMapper.updateByPrimaryKeySelective(noticeAdmin);
    }

    public void markReadByIds(List<Integer> ids, Integer adminId) {
        LitemallAdminNoticeAdminExample example = new LitemallAdminNoticeAdminExample();
        example.or().andIdIn(ids).andAdminIdEqualTo(adminId).andDeletedEqualTo(false);
        LitemallAdminNoticeAdmin noticeAdmin = new LitemallAdminNoticeAdmin();
        LocalDateTime now = LocalDateTime.now();
        noticeAdmin.setReadTime(now);
        noticeAdmin.setUpdateTime(now);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public void deleteById(Integer id, Integer adminId) {
        LitemallAdminNoticeAdminExample example = new LitemallAdminNoticeAdminExample();
        example.or().andIdEqualTo(id).andAdminIdEqualTo(adminId).andDeletedEqualTo(false);
        LitemallAdminNoticeAdmin noticeAdmin = new LitemallAdminNoticeAdmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public void deleteByIds(List<Integer> ids, Integer adminId) {
        LitemallAdminNoticeAdminExample example = new LitemallAdminNoticeAdminExample();
        example.or().andIdIn(ids).andAdminIdEqualTo(adminId).andDeletedEqualTo(false);
        LitemallAdminNoticeAdmin noticeAdmin = new LitemallAdminNoticeAdmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public int countUnread(Integer adminId) {
        LitemallAdminNoticeAdminExample example = new LitemallAdminNoticeAdminExample();
        example.or().andAdminIdEqualTo(adminId).andReadTimeIsNull().andDeletedEqualTo(false);
        return (int) noticeAdminMapper.countByExample(example);
    }

    public List<LitemallAdminNoticeAdmin> queryByNoticeId(Integer noticeId) {
        LitemallAdminNoticeAdminExample example = new LitemallAdminNoticeAdminExample();
        example.or().andNoticeIdEqualTo(noticeId).andDeletedEqualTo(false);
        return noticeAdminMapper.selectByExample(example);
    }

    public void deleteByNoticeId(Integer id) {
        LitemallAdminNoticeAdminExample example = new LitemallAdminNoticeAdminExample();
        example.or().andNoticeIdEqualTo(id).andDeletedEqualTo(false);
        LitemallAdminNoticeAdmin noticeAdmin = new LitemallAdminNoticeAdmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public void deleteByNoticeIds(List<Integer> ids) {
        LitemallAdminNoticeAdminExample example = new LitemallAdminNoticeAdminExample();
        example.or().andNoticeIdIn(ids).andDeletedEqualTo(false);
        LitemallAdminNoticeAdmin noticeAdmin = new LitemallAdminNoticeAdmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public int countReadByNoticeId(Integer noticeId) {
        LitemallAdminNoticeAdminExample example = new LitemallAdminNoticeAdminExample();
        example.or().andNoticeIdEqualTo(noticeId).andReadTimeIsNotNull().andDeletedEqualTo(false);
        return (int) noticeAdminMapper.countByExample(example);
    }

    public void updateByNoticeId(LitemallAdminNoticeAdmin noticeAdmin, Integer noticeId) {
        LitemallAdminNoticeAdminExample example = new LitemallAdminNoticeAdminExample();
        example.or().andNoticeIdEqualTo(noticeId).andDeletedEqualTo(false);
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }
}
