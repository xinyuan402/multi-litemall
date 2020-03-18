package org.linlinjava.litemall.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.litemall.db.dao.generate.LitemallAdminNoticeMapper;
import org.linlinjava.litemall.db.dao.generate.LitemallSysadminNoticeMapper;
import org.linlinjava.litemall.db.domain.generate.LitemallAdminNotice;
import org.linlinjava.litemall.db.domain.generate.LitemallAdminNoticeExample;
import org.linlinjava.litemall.db.domain.generate.LitemallSysadminNotice;
import org.linlinjava.litemall.db.domain.generate.LitemallSysadminNoticeExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LitemallSysadminNoticeService {
    @Resource
    private LitemallSysadminNoticeMapper noticeMapper;


    public List<LitemallSysadminNotice> querySelective(String title, String content, Integer page, Integer limit, String sort, String order) {
        LitemallSysadminNoticeExample example = new LitemallSysadminNoticeExample();
        LitemallSysadminNoticeExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (!StringUtils.isEmpty(content)) {
            criteria.andContentLike("%" + content + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return noticeMapper.selectByExample(example);
    }

    public int updateById(LitemallSysadminNotice notice) {
        notice.setUpdateTime(LocalDateTime.now());
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    public void deleteById(Integer id) {
        noticeMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LitemallSysadminNotice notice) {
        notice.setAddTime(LocalDateTime.now());
        notice.setUpdateTime(LocalDateTime.now());
        noticeMapper.insertSelective(notice);
    }

    public LitemallSysadminNotice findById(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    public void deleteByIds(List<Integer> ids) {
        LitemallSysadminNoticeExample example = new LitemallSysadminNoticeExample();
        example.or().andIdIn(ids).andDeletedEqualTo(false);
        LitemallSysadminNotice notice = new LitemallSysadminNotice();
        notice.setUpdateTime(LocalDateTime.now());
        notice.setDeleted(true);
        noticeMapper.updateByExampleSelective(notice, example);
    }
}
