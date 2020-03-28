package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallGoodsAttribute;
import com.lcwork.multimall.db.domain.generate.MultimallGoodsAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallGoodsAttributeMapper {
    long countByExample(MultimallGoodsAttributeExample example);

    int deleteByExample(MultimallGoodsAttributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallGoodsAttribute record);

    int insertSelective(MultimallGoodsAttribute record);

    MultimallGoodsAttribute selectOneByExample(MultimallGoodsAttributeExample example);

    MultimallGoodsAttribute selectOneByExampleSelective(@Param("example") MultimallGoodsAttributeExample example, @Param("selective") MultimallGoodsAttribute.Column ... selective);

    List<MultimallGoodsAttribute> selectByExampleSelective(@Param("example") MultimallGoodsAttributeExample example, @Param("selective") MultimallGoodsAttribute.Column ... selective);

    List<MultimallGoodsAttribute> selectByExample(MultimallGoodsAttributeExample example);

    MultimallGoodsAttribute selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallGoodsAttribute.Column ... selective);

    MultimallGoodsAttribute selectByPrimaryKey(Integer id);

    MultimallGoodsAttribute selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallGoodsAttribute record, @Param("example") MultimallGoodsAttributeExample example);

    int updateByExample(@Param("record") MultimallGoodsAttribute record, @Param("example") MultimallGoodsAttributeExample example);

    int updateByPrimaryKeySelective(MultimallGoodsAttribute record);

    int updateByPrimaryKey(MultimallGoodsAttribute record);

    int logicalDeleteByExample(@Param("example") MultimallGoodsAttributeExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}