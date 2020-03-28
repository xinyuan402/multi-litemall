package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallGoodsProduct;
import com.lcwork.multimall.db.domain.generate.MultimallGoodsProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallGoodsProductMapper {
    long countByExample(MultimallGoodsProductExample example);

    int deleteByExample(MultimallGoodsProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallGoodsProduct record);

    int insertSelective(MultimallGoodsProduct record);

    MultimallGoodsProduct selectOneByExample(MultimallGoodsProductExample example);

    MultimallGoodsProduct selectOneByExampleSelective(@Param("example") MultimallGoodsProductExample example, @Param("selective") MultimallGoodsProduct.Column ... selective);

    List<MultimallGoodsProduct> selectByExampleSelective(@Param("example") MultimallGoodsProductExample example, @Param("selective") MultimallGoodsProduct.Column ... selective);

    List<MultimallGoodsProduct> selectByExample(MultimallGoodsProductExample example);

    MultimallGoodsProduct selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallGoodsProduct.Column ... selective);

    MultimallGoodsProduct selectByPrimaryKey(Integer id);

    MultimallGoodsProduct selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallGoodsProduct record, @Param("example") MultimallGoodsProductExample example);

    int updateByExample(@Param("record") MultimallGoodsProduct record, @Param("example") MultimallGoodsProductExample example);

    int updateByPrimaryKeySelective(MultimallGoodsProduct record);

    int updateByPrimaryKey(MultimallGoodsProduct record);

    int logicalDeleteByExample(@Param("example") MultimallGoodsProductExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}