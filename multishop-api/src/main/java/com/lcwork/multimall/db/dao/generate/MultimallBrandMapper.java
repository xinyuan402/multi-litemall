package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallBrand;
import com.lcwork.multimall.db.domain.generate.MultimallBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallBrandMapper {
    long countByExample(MultimallBrandExample example);

    int deleteByExample(MultimallBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallBrand record);

    int insertSelective(MultimallBrand record);

    MultimallBrand selectOneByExample(MultimallBrandExample example);

    MultimallBrand selectOneByExampleSelective(@Param("example") MultimallBrandExample example, @Param("selective") MultimallBrand.Column ... selective);

    List<MultimallBrand> selectByExampleSelective(@Param("example") MultimallBrandExample example, @Param("selective") MultimallBrand.Column ... selective);

    List<MultimallBrand> selectByExample(MultimallBrandExample example);

    MultimallBrand selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallBrand.Column ... selective);

    MultimallBrand selectByPrimaryKey(Integer id);

    MultimallBrand selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallBrand record, @Param("example") MultimallBrandExample example);

    int updateByExample(@Param("record") MultimallBrand record, @Param("example") MultimallBrandExample example);

    int updateByPrimaryKeySelective(MultimallBrand record);

    int updateByPrimaryKey(MultimallBrand record);

    int logicalDeleteByExample(@Param("example") MultimallBrandExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}