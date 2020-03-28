package com.lcwork.multimall.db.service;

import com.github.pagehelper.PageHelper;
import com.lcwork.multimall.db.dao.generate.MultimallSysadminNoticeMapper;
import com.lcwork.multimall.db.domain.generate.MultimallSysadminNotice;
import com.lcwork.multimall.db.domain.generate.MultimallSysadminNoticeExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MultimallSysadminNoticeService {
    @Resource
    private MultimallSysadminNoticeMapper noticeMapper;


    public List<MultimallSysadminNotice> querySelective(String title, String content, Integer page, Integer limit, String sort, String order) {
        MultimallSysadminNoticeExample example = new MultimallSysadminNoticeExample();
        MultimallSysadminNoticeExample.Criteria criteria = example.createCriteria();

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

    public int updateById(MultimallSysadminNotice notice) {
        notice.setUpdateTime(LocalDateTime.now());
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    public void deleteById(Integer id) {
        noticeMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(MultimallSysadminNotice notice) {
        notice.setAddTime(LocalDateTime.now());
        notice.setUpdateTime(LocalDateTime.now());
        noticeMapper.insertSelective(notice);
    }

    public MultimallSysadminNotice findById(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    public void deleteByIds(List<Integer> ids) {
        MultimallSysadminNoticeExample example = new MultimallSysadminNoticeExample();
        example.or().andIdIn(ids).andDeletedEqualTo(false);
        MultimallSysadminNotice notice = new MultimallSysadminNotice();
        notice.setUpdateTime(LocalDateTime.now());
        notice.setDeleted(true);
        noticeMapper.updateByExampleSelective(notice, example);
    }
}
