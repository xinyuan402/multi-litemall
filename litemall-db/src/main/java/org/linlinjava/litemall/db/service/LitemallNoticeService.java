package org.linlinjava.litemall.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.litemall.db.dao.generate.LitemallAdminNoticeMapper;
import org.linlinjava.litemall.db.domain.generate.LitemallAdminNotice;
import org.linlinjava.litemall.db.domain.generate.LitemallAdminNoticeExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LitemallNoticeService {
    @Resource
    private LitemallAdminNoticeMapper noticeMapper;


    public List<LitemallAdminNotice> querySelective(String title, String content, Integer page, Integer limit, String sort, String order) {
        LitemallAdminNoticeExample example = new LitemallAdminNoticeExample();
        LitemallAdminNoticeExample.Criteria criteria = example.createCriteria();

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

    public int updateById(LitemallAdminNotice notice) {
        notice.setUpdateTime(LocalDateTime.now());
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    public void deleteById(Integer id) {
        noticeMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LitemallAdminNotice notice) {
        notice.setAddTime(LocalDateTime.now());
        notice.setUpdateTime(LocalDateTime.now());
        noticeMapper.insertSelective(notice);
    }

    public LitemallAdminNotice findById(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    public void deleteByIds(List<Integer> ids) {
        LitemallAdminNoticeExample example = new LitemallAdminNoticeExample();
        example.or().andIdIn(ids).andDeletedEqualTo(false);
        LitemallAdminNotice notice = new LitemallAdminNotice();
        notice.setUpdateTime(LocalDateTime.now());
        notice.setDeleted(true);
        noticeMapper.updateByExampleSelective(notice, example);
    }
}
