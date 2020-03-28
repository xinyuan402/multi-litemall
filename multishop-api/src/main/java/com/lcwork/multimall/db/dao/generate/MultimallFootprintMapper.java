package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallFootprint;
import com.lcwork.multimall.db.domain.generate.MultimallFootprintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallFootprintMapper {
    long countByExample(MultimallFootprintExample example);

    int deleteByExample(MultimallFootprintExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallFootprint record);

    int insertSelective(MultimallFootprint record);

    MultimallFootprint selectOneByExample(MultimallFootprintExample example);

    MultimallFootprint selectOneByExampleSelective(@Param("example") MultimallFootprintExample example, @Param("selective") MultimallFootprint.Column ... selective);

    List<MultimallFootprint> selectByExampleSelective(@Param("example") MultimallFootprintExample example, @Param("selective") MultimallFootprint.Column ... selective);

    List<MultimallFootprint> selectByExample(MultimallFootprintExample example);

    MultimallFootprint selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallFootprint.Column ... selective);

    MultimallFootprint selectByPrimaryKey(Integer id);

    MultimallFootprint selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallFootprint record, @Param("example") MultimallFootprintExample example);

    int updateByExample(@Param("record") MultimallFootprint record, @Param("example") MultimallFootprintExample example);

    int updateByPrimaryKeySelective(MultimallFootprint record);

    int updateByPrimaryKey(MultimallFootprint record);

    int logicalDeleteByExample(@Param("example") MultimallFootprintExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}