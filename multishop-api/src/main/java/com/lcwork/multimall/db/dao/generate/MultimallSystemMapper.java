package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallSystem;
import com.lcwork.multimall.db.domain.generate.MultimallSystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallSystemMapper {
    long countByExample(MultimallSystemExample example);

    int deleteByExample(MultimallSystemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallSystem record);

    int insertSelective(MultimallSystem record);

    MultimallSystem selectOneByExample(MultimallSystemExample example);

    MultimallSystem selectOneByExampleSelective(@Param("example") MultimallSystemExample example, @Param("selective") MultimallSystem.Column ... selective);

    List<MultimallSystem> selectByExampleSelective(@Param("example") MultimallSystemExample example, @Param("selective") MultimallSystem.Column ... selective);

    List<MultimallSystem> selectByExample(MultimallSystemExample example);

    MultimallSystem selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallSystem.Column ... selective);

    MultimallSystem selectByPrimaryKey(Integer id);

    MultimallSystem selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallSystem record, @Param("example") MultimallSystemExample example);

    int updateByExample(@Param("record") MultimallSystem record, @Param("example") MultimallSystemExample example);

    int updateByPrimaryKeySelective(MultimallSystem record);

    int updateByPrimaryKey(MultimallSystem record);

    int logicalDeleteByExample(@Param("example") MultimallSystemExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}