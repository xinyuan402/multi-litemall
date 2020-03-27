package com.lcwork.multishop.db.dao.generate;

import com.lcwork.multishop.db.domain.generate.LitemallGoodsAttribute;
import com.lcwork.multishop.db.domain.generate.LitemallGoodsAttributeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallGoodsAttributeMapper {
    long countByExample(LitemallGoodsAttributeExample example);

    int deleteByExample(LitemallGoodsAttributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallGoodsAttribute record);

    int insertSelective(LitemallGoodsAttribute record);

    LitemallGoodsAttribute selectOneByExample(LitemallGoodsAttributeExample example);

    LitemallGoodsAttribute selectOneByExampleSelective(@Param("example") LitemallGoodsAttributeExample example, @Param("selective") LitemallGoodsAttribute.Column... selective);

    List<LitemallGoodsAttribute> selectByExampleSelective(@Param("example") LitemallGoodsAttributeExample example, @Param("selective") LitemallGoodsAttribute.Column... selective);

    List<LitemallGoodsAttribute> selectByExample(LitemallGoodsAttributeExample example);

    LitemallGoodsAttribute selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallGoodsAttribute.Column... selective);

    LitemallGoodsAttribute selectByPrimaryKey(Integer id);

    LitemallGoodsAttribute selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallGoodsAttribute record, @Param("example") LitemallGoodsAttributeExample example);

    int updateByExample(@Param("record") LitemallGoodsAttribute record, @Param("example") LitemallGoodsAttributeExample example);

    int updateByPrimaryKeySelective(LitemallGoodsAttribute record);

    int updateByPrimaryKey(LitemallGoodsAttribute record);

    int logicalDeleteByExample(@Param("example") LitemallGoodsAttributeExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
