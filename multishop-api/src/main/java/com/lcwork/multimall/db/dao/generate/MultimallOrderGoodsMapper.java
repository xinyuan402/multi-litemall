package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallOrderGoods;
import com.lcwork.multimall.db.domain.generate.MultimallOrderGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallOrderGoodsMapper {
    long countByExample(MultimallOrderGoodsExample example);

    int deleteByExample(MultimallOrderGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallOrderGoods record);

    int insertSelective(MultimallOrderGoods record);

    MultimallOrderGoods selectOneByExample(MultimallOrderGoodsExample example);

    MultimallOrderGoods selectOneByExampleSelective(@Param("example") MultimallOrderGoodsExample example, @Param("selective") MultimallOrderGoods.Column ... selective);

    List<MultimallOrderGoods> selectByExampleSelective(@Param("example") MultimallOrderGoodsExample example, @Param("selective") MultimallOrderGoods.Column ... selective);

    List<MultimallOrderGoods> selectByExample(MultimallOrderGoodsExample example);

    MultimallOrderGoods selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallOrderGoods.Column ... selective);

    MultimallOrderGoods selectByPrimaryKey(Integer id);

    MultimallOrderGoods selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallOrderGoods record, @Param("example") MultimallOrderGoodsExample example);

    int updateByExample(@Param("record") MultimallOrderGoods record, @Param("example") MultimallOrderGoodsExample example);

    int updateByPrimaryKeySelective(MultimallOrderGoods record);

    int updateByPrimaryKey(MultimallOrderGoods record);

    int logicalDeleteByExample(@Param("example") MultimallOrderGoodsExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}