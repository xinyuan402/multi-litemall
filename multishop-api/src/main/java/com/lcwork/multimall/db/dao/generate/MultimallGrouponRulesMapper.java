package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallGrouponRules;
import com.lcwork.multimall.db.domain.generate.MultimallGrouponRulesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallGrouponRulesMapper {
    long countByExample(MultimallGrouponRulesExample example);

    int deleteByExample(MultimallGrouponRulesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallGrouponRules record);

    int insertSelective(MultimallGrouponRules record);

    MultimallGrouponRules selectOneByExample(MultimallGrouponRulesExample example);

    MultimallGrouponRules selectOneByExampleSelective(@Param("example") MultimallGrouponRulesExample example, @Param("selective") MultimallGrouponRules.Column ... selective);

    List<MultimallGrouponRules> selectByExampleSelective(@Param("example") MultimallGrouponRulesExample example, @Param("selective") MultimallGrouponRules.Column ... selective);

    List<MultimallGrouponRules> selectByExample(MultimallGrouponRulesExample example);

    MultimallGrouponRules selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallGrouponRules.Column ... selective);

    MultimallGrouponRules selectByPrimaryKey(Integer id);

    MultimallGrouponRules selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallGrouponRules record, @Param("example") MultimallGrouponRulesExample example);

    int updateByExample(@Param("record") MultimallGrouponRules record, @Param("example") MultimallGrouponRulesExample example);

    int updateByPrimaryKeySelective(MultimallGrouponRules record);

    int updateByPrimaryKey(MultimallGrouponRules record);

    int logicalDeleteByExample(@Param("example") MultimallGrouponRulesExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}