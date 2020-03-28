package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallCollect;
import com.lcwork.multimall.db.domain.generate.MultimallCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallCollectMapper {
    long countByExample(MultimallCollectExample example);

    int deleteByExample(MultimallCollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallCollect record);

    int insertSelective(MultimallCollect record);

    MultimallCollect selectOneByExample(MultimallCollectExample example);

    MultimallCollect selectOneByExampleSelective(@Param("example") MultimallCollectExample example, @Param("selective") MultimallCollect.Column ... selective);

    List<MultimallCollect> selectByExampleSelective(@Param("example") MultimallCollectExample example, @Param("selective") MultimallCollect.Column ... selective);

    List<MultimallCollect> selectByExample(MultimallCollectExample example);

    MultimallCollect selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallCollect.Column ... selective);

    MultimallCollect selectByPrimaryKey(Integer id);

    MultimallCollect selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallCollect record, @Param("example") MultimallCollectExample example);

    int updateByExample(@Param("record") MultimallCollect record, @Param("example") MultimallCollectExample example);

    int updateByPrimaryKeySelective(MultimallCollect record);

    int updateByPrimaryKey(MultimallCollect record);

    int logicalDeleteByExample(@Param("example") MultimallCollectExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}