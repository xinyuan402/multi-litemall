package com.lcwork.multimall.db.service;

import com.github.pagehelper.PageHelper;
import com.lcwork.multimall.db.dao.generate.MultimallCommentMapper;
import com.lcwork.multimall.db.domain.generate.MultimallComment;
import com.lcwork.multimall.db.domain.generate.MultimallCommentExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MultimallCommentService {
    @Resource
    private MultimallCommentMapper commentMapper;

    public List<MultimallComment> queryGoodsByGid(Integer id, int offset, int limit) {
        MultimallCommentExample example = new MultimallCommentExample();
        example.setOrderByClause(MultimallComment.Column.addTime.desc());
        example.or().andValueIdEqualTo(id).andTypeEqualTo((byte) 0).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return commentMapper.selectByExample(example);
    }

    public List<MultimallComment> query(Byte type, Integer valueId, Integer showType, Integer offset, Integer limit) {
        MultimallCommentExample example = new MultimallCommentExample();
        example.setOrderByClause(MultimallComment.Column.addTime.desc());
        if (showType == 0) {
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andDeletedEqualTo(false);
        } else if (showType == 1) {
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andHasPictureEqualTo(true).andDeletedEqualTo(false);
        } else {
            throw new RuntimeException("showType不支持");
        }
        PageHelper.startPage(offset, limit);
        return commentMapper.selectByExample(example);
    }

    public int count(Byte type, Integer valueId, Integer showType) {
        MultimallCommentExample example = new MultimallCommentExample();
        if (showType == 0) {
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andDeletedEqualTo(false);
        } else if (showType == 1) {
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andHasPictureEqualTo(true).andDeletedEqualTo(false);
        } else {
            throw new RuntimeException("showType不支持");
        }
        return (int) commentMapper.countByExample(example);
    }

    public int save(MultimallComment comment) {
        comment.setAddTime(LocalDateTime.now());
        comment.setUpdateTime(LocalDateTime.now());
        return commentMapper.insertSelective(comment);
    }

    public List<MultimallComment> querySelective(String userId, String valueId, Integer page, Integer size, String sort, String order) {
        MultimallCommentExample example = new MultimallCommentExample();
        MultimallCommentExample.Criteria criteria = example.createCriteria();

        // type=2 是订单商品回复，这里过滤
        criteria.andTypeNotEqualTo((byte) 2);

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(valueId)) {
            criteria.andValueIdEqualTo(Integer.valueOf(valueId)).andTypeEqualTo((byte) 0);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return commentMapper.selectByExample(example);
    }

    public void deleteById(Integer id) {
        commentMapper.logicalDeleteByPrimaryKey(id);
    }

    public MultimallComment findById(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    public int updateById(MultimallComment comment) {
        return commentMapper.updateByPrimaryKeySelective(comment);
    }
}
