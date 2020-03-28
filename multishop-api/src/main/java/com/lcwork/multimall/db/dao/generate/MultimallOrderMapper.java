package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallOrder;
import com.lcwork.multimall.db.domain.generate.MultimallOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallOrderMapper {
    long countByExample(MultimallOrderExample example);

    int deleteByExample(MultimallOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallOrder record);

    int insertSelective(MultimallOrder record);

    MultimallOrder selectOneByExample(MultimallOrderExample example);

    MultimallOrder selectOneByExampleSelective(@Param("example") MultimallOrderExample example, @Param("selective") MultimallOrder.Column ... selective);

    List<MultimallOrder> selectByExampleSelective(@Param("example") MultimallOrderExample example, @Param("selective") MultimallOrder.Column ... selective);

    List<MultimallOrder> selectByExample(MultimallOrderExample example);

    MultimallOrder selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallOrder.Column ... selective);

    MultimallOrder selectByPrimaryKey(Integer id);

    MultimallOrder selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallOrder record, @Param("example") MultimallOrderExample example);

    int updateByExample(@Param("record") MultimallOrder record, @Param("example") MultimallOrderExample example);

    int updateByPrimaryKeySelective(MultimallOrder record);

    int updateByPrimaryKey(MultimallOrder record);

    int logicalDeleteByExample(@Param("example") MultimallOrderExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}