package org.linlinjava.litemall.db.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.generate.LitemallOrder;
import org.linlinjava.litemall.db.domain.generate.LitemallOrderExample;

public interface LitemallOrderMapper {
    long countByExample(LitemallOrderExample example);

    int deleteByExample(LitemallOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallOrder record);

    int insertSelective(LitemallOrder record);

    LitemallOrder selectOneByExample(LitemallOrderExample example);

    LitemallOrder selectOneByExampleSelective(@Param("example") LitemallOrderExample example, @Param("selective") LitemallOrder.Column ... selective);

    List<LitemallOrder> selectByExampleSelective(@Param("example") LitemallOrderExample example, @Param("selective") LitemallOrder.Column ... selective);

    List<LitemallOrder> selectByExample(LitemallOrderExample example);

    LitemallOrder selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallOrder.Column ... selective);

    LitemallOrder selectByPrimaryKey(Integer id);

    LitemallOrder selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallOrder record, @Param("example") LitemallOrderExample example);

    int updateByExample(@Param("record") LitemallOrder record, @Param("example") LitemallOrderExample example);

    int updateByPrimaryKeySelective(LitemallOrder record);

    int updateByPrimaryKey(LitemallOrder record);

    int logicalDeleteByExample(@Param("example") LitemallOrderExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}