package com.lcwork.multimall.db.service;

import com.github.pagehelper.PageHelper;
import com.lcwork.multimall.db.dao.generate.MultimallSysadminLogMapper;
import com.lcwork.multimall.db.domain.generate.MultimallSysadminLog;
import com.lcwork.multimall.db.domain.generate.MultimallSysadminLogExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MultimallSysadminLogService {
    @Resource
    private MultimallSysadminLogMapper logMapper;

    public void deleteById(Integer id) {
        logMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(MultimallSysadminLog log) {
        log.setAddTime(LocalDateTime.now());
        log.setUpdateTime(LocalDateTime.now());
        logMapper.insertSelective(log);
    }

    public List<MultimallSysadminLog> querySelective(String name, Integer page, Integer size, String sort, String order) {
        MultimallSysadminLogExample example = new MultimallSysadminLogExample();
        MultimallSysadminLogExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andSysadminLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return logMapper.selectByExample(example);
    }
}
