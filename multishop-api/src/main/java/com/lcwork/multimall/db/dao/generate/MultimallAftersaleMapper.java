package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallAftersale;
import com.lcwork.multimall.db.domain.generate.MultimallAftersaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallAftersaleMapper {
    long countByExample(MultimallAftersaleExample example);

    int deleteByExample(MultimallAftersaleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallAftersale record);

    int insertSelective(MultimallAftersale record);

    MultimallAftersale selectOneByExample(MultimallAftersaleExample example);

    MultimallAftersale selectOneByExampleSelective(@Param("example") MultimallAftersaleExample example, @Param("selective") MultimallAftersale.Column ... selective);

    List<MultimallAftersale> selectByExampleSelective(@Param("example") MultimallAftersaleExample example, @Param("selective") MultimallAftersale.Column ... selective);

    List<MultimallAftersale> selectByExample(MultimallAftersaleExample example);

    MultimallAftersale selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallAftersale.Column ... selective);

    MultimallAftersale selectByPrimaryKey(Integer id);

    MultimallAftersale selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallAftersale record, @Param("example") MultimallAftersaleExample example);

    int updateByExample(@Param("record") MultimallAftersale record, @Param("example") MultimallAftersaleExample example);

    int updateByPrimaryKeySelective(MultimallAftersale record);

    int updateByPrimaryKey(MultimallAftersale record);

    int logicalDeleteByExample(@Param("example") MultimallAftersaleExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}