package com.lcwork.multimall.db.service;

import com.github.pagehelper.PageHelper;
import com.lcwork.multimall.db.dao.generate.MultimallSearchHistoryMapper;
import com.lcwork.multimall.db.domain.generate.MultimallSearchHistory;
import com.lcwork.multimall.db.domain.generate.MultimallSearchHistoryExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MultimallSearchHistoryService {
    @Resource
    private MultimallSearchHistoryMapper searchHistoryMapper;

    public void save(MultimallSearchHistory searchHistory) {
        searchHistory.setAddTime(LocalDateTime.now());
        searchHistory.setUpdateTime(LocalDateTime.now());
        searchHistoryMapper.insertSelective(searchHistory);
    }

    public List<MultimallSearchHistory> queryByUid(int uid) {
        MultimallSearchHistoryExample example = new MultimallSearchHistoryExample();
        example.or().andUserIdEqualTo(uid).andDeletedEqualTo(false);
        example.setDistinct(true);
        return searchHistoryMapper.selectByExampleSelective(example, MultimallSearchHistory.Column.keyword);
    }

    public void deleteByUid(int uid) {
        MultimallSearchHistoryExample example = new MultimallSearchHistoryExample();
        example.or().andUserIdEqualTo(uid);
        searchHistoryMapper.logicalDeleteByExample(example);
    }

    public List<MultimallSearchHistory> querySelective(String userId, String keyword, Integer page, Integer size, String sort, String order) {
        MultimallSearchHistoryExample example = new MultimallSearchHistoryExample();
        MultimallSearchHistoryExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andKeywordLike("%" + keyword + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return searchHistoryMapper.selectByExample(example);
    }
}
