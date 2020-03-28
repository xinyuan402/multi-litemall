package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallGoods;
import com.lcwork.multimall.db.domain.generate.MultimallGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallGoodsMapper {
    long countByExample(MultimallGoodsExample example);

    int deleteByExample(MultimallGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallGoods record);

    int insertSelective(MultimallGoods record);

    MultimallGoods selectOneByExample(MultimallGoodsExample example);

    MultimallGoods selectOneByExampleSelective(@Param("example") MultimallGoodsExample example, @Param("selective") MultimallGoods.Column ... selective);

    MultimallGoods selectOneByExampleWithBLOBs(MultimallGoodsExample example);

    List<MultimallGoods> selectByExampleSelective(@Param("example") MultimallGoodsExample example, @Param("selective") MultimallGoods.Column ... selective);

    List<MultimallGoods> selectByExampleWithBLOBs(MultimallGoodsExample example);

    List<MultimallGoods> selectByExample(MultimallGoodsExample example);

    MultimallGoods selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallGoods.Column ... selective);

    MultimallGoods selectByPrimaryKey(Integer id);

    MultimallGoods selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallGoods record, @Param("example") MultimallGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") MultimallGoods record, @Param("example") MultimallGoodsExample example);

    int updateByExample(@Param("record") MultimallGoods record, @Param("example") MultimallGoodsExample example);

    int updateByPrimaryKeySelective(MultimallGoods record);

    int updateByPrimaryKeyWithBLOBs(MultimallGoods record);

    int updateByPrimaryKey(MultimallGoods record);

    int logicalDeleteByExample(@Param("example") MultimallGoodsExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}