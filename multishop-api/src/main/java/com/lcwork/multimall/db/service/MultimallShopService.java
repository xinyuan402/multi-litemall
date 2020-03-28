package com.lcwork.multimall.db.service;

import com.github.pagehelper.PageHelper;
import com.lcwork.multimall.db.dao.generate.MultimallShopMapper;
import com.lcwork.multimall.db.domain.generate.MultimallShop;
import com.lcwork.multimall.db.domain.generate.MultimallShopExample;
import com.lcwork.multimall.db.enums.ShopStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MultimallShopService {

    @Resource
    MultimallShopMapper shopMapper;

    public void add(MultimallShop shop) {
        shop.setAddTime(LocalDateTime.now());
        shop.setUpdateTime(LocalDateTime.now());
        shopMapper.insertSelective(shop);
    }

    public List<MultimallShop> querySelective(String name, Integer page, Integer limit, String sort, String order) {

        MultimallShopExample example = new MultimallShopExample();
        MultimallShopExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return shopMapper.selectByExample(example);
    }

    public boolean checkExistByName(String name) {
        MultimallShopExample example = new MultimallShopExample();
        example.createCriteria().andNameEqualTo(name);
        return shopMapper.countByExample(example) != 0;
    }

    public int updateById(MultimallShop shop) {
        shop.setUpdateTime(LocalDateTime.now());
        return shopMapper.updateByPrimaryKeySelective(shop);
    }

    public int deleteById(int id) {
        return shopMapper.logicalDeleteByPrimaryKey(id);
    }

    public int updateStatusById(Integer id, ShopStatus status) {
        MultimallShop shop = new MultimallShop();
        shop.setId(id);
        shop.setStatus(status);
        return shopMapper.updateByPrimaryKeySelective(shop);
    }

    public int count() {
        MultimallShopExample example = new MultimallShopExample();
        example.or().andDeletedEqualTo(false);
        return (int) shopMapper.countByExample(example);
    }
}
