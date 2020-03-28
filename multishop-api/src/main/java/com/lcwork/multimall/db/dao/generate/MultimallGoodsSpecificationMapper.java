package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallGoodsSpecification;
import com.lcwork.multimall.db.domain.generate.MultimallGoodsSpecificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallGoodsSpecificationMapper {
    long countByExample(MultimallGoodsSpecificationExample example);

    int deleteByExample(MultimallGoodsSpecificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallGoodsSpecification record);

    int insertSelective(MultimallGoodsSpecification record);

    MultimallGoodsSpecification selectOneByExample(MultimallGoodsSpecificationExample example);

    MultimallGoodsSpecification selectOneByExampleSelective(@Param("example") MultimallGoodsSpecificationExample example, @Param("selective") MultimallGoodsSpecification.Column ... selective);

    List<MultimallGoodsSpecification> selectByExampleSelective(@Param("example") MultimallGoodsSpecificationExample example, @Param("selective") MultimallGoodsSpecification.Column ... selective);

    List<MultimallGoodsSpecification> selectByExample(MultimallGoodsSpecificationExample example);

    MultimallGoodsSpecification selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallGoodsSpecification.Column ... selective);

    MultimallGoodsSpecification selectByPrimaryKey(Integer id);

    MultimallGoodsSpecification selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallGoodsSpecification record, @Param("example") MultimallGoodsSpecificationExample example);

    int updateByExample(@Param("record") MultimallGoodsSpecification record, @Param("example") MultimallGoodsSpecificationExample example);

    int updateByPrimaryKeySelective(MultimallGoodsSpecification record);

    int updateByPrimaryKey(MultimallGoodsSpecification record);

    int logicalDeleteByExample(@Param("example") MultimallGoodsSpecificationExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}