package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallRegion;
import com.lcwork.multimall.db.domain.generate.MultimallRegionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallRegionMapper {
    long countByExample(MultimallRegionExample example);

    int deleteByExample(MultimallRegionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallRegion record);

    int insertSelective(MultimallRegion record);

    MultimallRegion selectOneByExample(MultimallRegionExample example);

    MultimallRegion selectOneByExampleSelective(@Param("example") MultimallRegionExample example, @Param("selective") MultimallRegion.Column ... selective);

    List<MultimallRegion> selectByExampleSelective(@Param("example") MultimallRegionExample example, @Param("selective") MultimallRegion.Column ... selective);

    List<MultimallRegion> selectByExample(MultimallRegionExample example);

    MultimallRegion selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallRegion.Column ... selective);

    MultimallRegion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MultimallRegion record, @Param("example") MultimallRegionExample example);

    int updateByExample(@Param("record") MultimallRegion record, @Param("example") MultimallRegionExample example);

    int updateByPrimaryKeySelective(MultimallRegion record);

    int updateByPrimaryKey(MultimallRegion record);
}