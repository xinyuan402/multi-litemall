package com.lcwork.multishop.db.dao.generate;

import com.lcwork.multishop.db.domain.generate.LitemallGoodsSpecification;
import com.lcwork.multishop.db.domain.generate.LitemallGoodsSpecificationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallGoodsSpecificationMapper {
    long countByExample(LitemallGoodsSpecificationExample example);

    int deleteByExample(LitemallGoodsSpecificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallGoodsSpecification record);

    int insertSelective(LitemallGoodsSpecification record);

    LitemallGoodsSpecification selectOneByExample(LitemallGoodsSpecificationExample example);

    LitemallGoodsSpecification selectOneByExampleSelective(@Param("example") LitemallGoodsSpecificationExample example, @Param("selective") LitemallGoodsSpecification.Column... selective);

    List<LitemallGoodsSpecification> selectByExampleSelective(@Param("example") LitemallGoodsSpecificationExample example, @Param("selective") LitemallGoodsSpecification.Column... selective);

    List<LitemallGoodsSpecification> selectByExample(LitemallGoodsSpecificationExample example);

    LitemallGoodsSpecification selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallGoodsSpecification.Column... selective);

    LitemallGoodsSpecification selectByPrimaryKey(Integer id);

    LitemallGoodsSpecification selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallGoodsSpecification record, @Param("example") LitemallGoodsSpecificationExample example);

    int updateByExample(@Param("record") LitemallGoodsSpecification record, @Param("example") LitemallGoodsSpecificationExample example);

    int updateByPrimaryKeySelective(LitemallGoodsSpecification record);

    int updateByPrimaryKey(LitemallGoodsSpecification record);

    int logicalDeleteByExample(@Param("example") LitemallGoodsSpecificationExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
