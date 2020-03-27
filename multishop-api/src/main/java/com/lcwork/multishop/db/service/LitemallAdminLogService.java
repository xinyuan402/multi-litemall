package com.lcwork.multishop.db.service;

import com.github.pagehelper.PageHelper;
import com.lcwork.multishop.db.dao.generate.LitemallAdminLogMapper;
import com.lcwork.multishop.db.domain.generate.LitemallAdminLog;
import com.lcwork.multishop.db.domain.generate.LitemallAdminLogExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LitemallAdminLogService {
    @Resource
    private LitemallAdminLogMapper logMapper;

    public void deleteById(Integer id) {
        logMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LitemallAdminLog log) {
        log.setAddTime(LocalDateTime.now());
        log.setUpdateTime(LocalDateTime.now());
        logMapper.insertSelective(log);
    }

    public List<LitemallAdminLog> querySelective(String name, Integer page, Integer size, String sort, String order) {
        LitemallAdminLogExample example = new LitemallAdminLogExample();
        LitemallAdminLogExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andAdminLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return logMapper.selectByExample(example);
    }
}
