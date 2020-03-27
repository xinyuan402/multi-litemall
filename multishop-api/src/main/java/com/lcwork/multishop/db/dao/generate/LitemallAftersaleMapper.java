package com.lcwork.multishop.db.dao.generate;

import com.lcwork.multishop.db.domain.generate.LitemallAftersale;
import com.lcwork.multishop.db.domain.generate.LitemallAftersaleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallAftersaleMapper {
    long countByExample(LitemallAftersaleExample example);

    int deleteByExample(LitemallAftersaleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallAftersale record);

    int insertSelective(LitemallAftersale record);

    LitemallAftersale selectOneByExample(LitemallAftersaleExample example);

    LitemallAftersale selectOneByExampleSelective(@Param("example") LitemallAftersaleExample example, @Param("selective") LitemallAftersale.Column... selective);

    List<LitemallAftersale> selectByExampleSelective(@Param("example") LitemallAftersaleExample example, @Param("selective") LitemallAftersale.Column... selective);

    List<LitemallAftersale> selectByExample(LitemallAftersaleExample example);

    LitemallAftersale selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallAftersale.Column... selective);

    LitemallAftersale selectByPrimaryKey(Integer id);

    LitemallAftersale selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallAftersale record, @Param("example") LitemallAftersaleExample example);

    int updateByExample(@Param("record") LitemallAftersale record, @Param("example") LitemallAftersaleExample example);

    int updateByPrimaryKeySelective(LitemallAftersale record);

    int updateByPrimaryKey(LitemallAftersale record);

    int logicalDeleteByExample(@Param("example") LitemallAftersaleExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
