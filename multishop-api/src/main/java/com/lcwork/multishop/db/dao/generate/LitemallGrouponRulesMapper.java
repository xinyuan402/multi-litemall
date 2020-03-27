package com.lcwork.multishop.db.dao.generate;

import com.lcwork.multishop.db.domain.generate.LitemallGrouponRules;
import com.lcwork.multishop.db.domain.generate.LitemallGrouponRulesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallGrouponRulesMapper {
    long countByExample(LitemallGrouponRulesExample example);

    int deleteByExample(LitemallGrouponRulesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallGrouponRules record);

    int insertSelective(LitemallGrouponRules record);

    LitemallGrouponRules selectOneByExample(LitemallGrouponRulesExample example);

    LitemallGrouponRules selectOneByExampleSelective(@Param("example") LitemallGrouponRulesExample example, @Param("selective") LitemallGrouponRules.Column... selective);

    List<LitemallGrouponRules> selectByExampleSelective(@Param("example") LitemallGrouponRulesExample example, @Param("selective") LitemallGrouponRules.Column... selective);

    List<LitemallGrouponRules> selectByExample(LitemallGrouponRulesExample example);

    LitemallGrouponRules selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallGrouponRules.Column... selective);

    LitemallGrouponRules selectByPrimaryKey(Integer id);

    LitemallGrouponRules selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallGrouponRules record, @Param("example") LitemallGrouponRulesExample example);

    int updateByExample(@Param("record") LitemallGrouponRules record, @Param("example") LitemallGrouponRulesExample example);

    int updateByPrimaryKeySelective(LitemallGrouponRules record);

    int updateByPrimaryKey(LitemallGrouponRules record);

    int logicalDeleteByExample(@Param("example") LitemallGrouponRulesExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
