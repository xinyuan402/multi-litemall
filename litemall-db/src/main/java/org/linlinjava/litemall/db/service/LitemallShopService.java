package org.linlinjava.litemall.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.litemall.db.dao.generate.LitemallShopMapper;
import org.linlinjava.litemall.db.domain.generate.LitemallShop;
import org.linlinjava.litemall.db.domain.generate.LitemallShopExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LitemallShopService {

    @Resource
    LitemallShopMapper shopMapper;

    public void add(LitemallShop shop) {
        shop.setAddTime(LocalDateTime.now());
        shop.setUpdateTime(LocalDateTime.now());
        shopMapper.insertSelective(shop);
    }

    public List<LitemallShop> querySelective(String name, Integer page, Integer limit, String sort, String order) {

        LitemallShopExample example = new LitemallShopExample();
        LitemallShopExample.Criteria criteria = example.createCriteria();

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
        LitemallShopExample example = new LitemallShopExample();
        example.createCriteria().andNameEqualTo(name);
        return shopMapper.countByExample(example) != 0;
    }
}
