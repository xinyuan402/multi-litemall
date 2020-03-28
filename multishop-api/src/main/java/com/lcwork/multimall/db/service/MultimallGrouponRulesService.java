package com.lcwork.multimall.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.lcwork.multimall.db.dao.generate.MultimallGoodsMapper;
import com.lcwork.multimall.db.dao.generate.MultimallGrouponRulesMapper;
import com.lcwork.multimall.db.domain.generate.MultimallGoods;
import com.lcwork.multimall.db.domain.generate.MultimallGrouponRules;
import com.lcwork.multimall.db.domain.generate.MultimallGrouponRulesExample;
import com.lcwork.multimall.db.util.GrouponConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MultimallGrouponRulesService {
    @Resource
    private MultimallGrouponRulesMapper mapper;
    @Resource
    private MultimallGoodsMapper goodsMapper;
    private MultimallGoods.Column[] goodsColumns = new MultimallGoods.Column[]{MultimallGoods.Column.id, MultimallGoods.Column.name, MultimallGoods.Column.brief, MultimallGoods.Column.picUrl, MultimallGoods.Column.counterPrice, MultimallGoods.Column.retailPrice};

    public int createRules(MultimallGrouponRules rules) {
        rules.setAddTime(LocalDateTime.now());
        rules.setUpdateTime(LocalDateTime.now());
        return mapper.insertSelective(rules);
    }

    /**
     * 根据ID查找对应团购项
     *
     * @param id
     * @return
     */
    public MultimallGrouponRules findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询某个商品关联的团购规则
     *
     * @param goodsId
     * @return
     */
    public List<MultimallGrouponRules> queryByGoodsId(Integer goodsId) {
        MultimallGrouponRulesExample example = new MultimallGrouponRulesExample();
        example.or().andGoodsIdEqualTo(goodsId).andStatusEqualTo(GrouponConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }

    public int countByGoodsId(Integer goodsId) {
        MultimallGrouponRulesExample example = new MultimallGrouponRulesExample();
        example.or().andGoodsIdEqualTo(goodsId).andStatusEqualTo(GrouponConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        return (int) mapper.countByExample(example);
    }

    public List<MultimallGrouponRules> queryByStatus(Short status) {
        MultimallGrouponRulesExample example = new MultimallGrouponRulesExample();
        example.or().andStatusEqualTo(status).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }

    /**
     * 获取首页团购规则列表
     *
     * @param page
     * @param limit
     * @return
     */
    public List<MultimallGrouponRules> queryList(Integer page, Integer limit) {
        return queryList(page, limit, "add_time", "desc");
    }

    public List<MultimallGrouponRules> queryList(Integer page, Integer limit, String sort, String order) {
        MultimallGrouponRulesExample example = new MultimallGrouponRulesExample();
        example.or().andStatusEqualTo(GrouponConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(page, limit);
        return mapper.selectByExample(example);
    }

    /**
     * 判断某个团购规则是否已经过期
     *
     * @return
     */
    public boolean isExpired(MultimallGrouponRules rules) {
        return (rules == null || rules.getExpireTime().isBefore(LocalDateTime.now()));
    }

    /**
     * 获取团购规则列表
     *
     * @param goodsId
     * @param page
     * @param size
     * @param sort
     * @param order
     * @return
     */
    public List<MultimallGrouponRules> querySelective(String goodsId, Integer page, Integer size, String sort, String order) {
        MultimallGrouponRulesExample example = new MultimallGrouponRulesExample();
        example.setOrderByClause(sort + " " + order);

        MultimallGrouponRulesExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(Integer.parseInt(goodsId));
        }
        criteria.andDeletedEqualTo(false);

        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }

    public void delete(Integer id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }

    public int updateById(MultimallGrouponRules grouponRules) {
        grouponRules.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(grouponRules);
    }
}
