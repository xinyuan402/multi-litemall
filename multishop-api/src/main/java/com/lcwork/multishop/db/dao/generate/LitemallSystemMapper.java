package com.lcwork.multishop.db.dao.generate;

import com.lcwork.multishop.db.domain.generate.LitemallSystem;
import com.lcwork.multishop.db.domain.generate.LitemallSystemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallSystemMapper {
    long countByExample(LitemallSystemExample example);

    int deleteByExample(LitemallSystemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallSystem record);

    int insertSelective(LitemallSystem record);

    LitemallSystem selectOneByExample(LitemallSystemExample example);

    LitemallSystem selectOneByExampleSelective(@Param("example") LitemallSystemExample example, @Param("selective") LitemallSystem.Column... selective);

    List<LitemallSystem> selectByExampleSelective(@Param("example") LitemallSystemExample example, @Param("selective") LitemallSystem.Column... selective);

    List<LitemallSystem> selectByExample(LitemallSystemExample example);

    LitemallSystem selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallSystem.Column... selective);

    LitemallSystem selectByPrimaryKey(Integer id);

    LitemallSystem selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallSystem record, @Param("example") LitemallSystemExample example);

    int updateByExample(@Param("record") LitemallSystem record, @Param("example") LitemallSystemExample example);

    int updateByPrimaryKeySelective(LitemallSystem record);

    int updateByPrimaryKey(LitemallSystem record);

    int logicalDeleteByExample(@Param("example") LitemallSystemExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
