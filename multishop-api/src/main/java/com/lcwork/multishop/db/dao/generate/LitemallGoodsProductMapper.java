package com.lcwork.multishop.db.dao.generate;

import com.lcwork.multishop.db.domain.generate.LitemallGoodsProduct;
import com.lcwork.multishop.db.domain.generate.LitemallGoodsProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallGoodsProductMapper {
    long countByExample(LitemallGoodsProductExample example);

    int deleteByExample(LitemallGoodsProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallGoodsProduct record);

    int insertSelective(LitemallGoodsProduct record);

    LitemallGoodsProduct selectOneByExample(LitemallGoodsProductExample example);

    LitemallGoodsProduct selectOneByExampleSelective(@Param("example") LitemallGoodsProductExample example, @Param("selective") LitemallGoodsProduct.Column... selective);

    List<LitemallGoodsProduct> selectByExampleSelective(@Param("example") LitemallGoodsProductExample example, @Param("selective") LitemallGoodsProduct.Column... selective);

    List<LitemallGoodsProduct> selectByExample(LitemallGoodsProductExample example);

    LitemallGoodsProduct selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallGoodsProduct.Column... selective);

    LitemallGoodsProduct selectByPrimaryKey(Integer id);

    LitemallGoodsProduct selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallGoodsProduct record, @Param("example") LitemallGoodsProductExample example);

    int updateByExample(@Param("record") LitemallGoodsProduct record, @Param("example") LitemallGoodsProductExample example);

    int updateByPrimaryKeySelective(LitemallGoodsProduct record);

    int updateByPrimaryKey(LitemallGoodsProduct record);

    int logicalDeleteByExample(@Param("example") LitemallGoodsProductExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
