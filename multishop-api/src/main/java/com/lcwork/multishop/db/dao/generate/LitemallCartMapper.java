package com.lcwork.multishop.db.dao.generate;

import com.lcwork.multishop.db.domain.generate.LitemallCart;
import com.lcwork.multishop.db.domain.generate.LitemallCartExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallCartMapper {
    long countByExample(LitemallCartExample example);

    int deleteByExample(LitemallCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallCart record);

    int insertSelective(LitemallCart record);

    LitemallCart selectOneByExample(LitemallCartExample example);

    LitemallCart selectOneByExampleSelective(@Param("example") LitemallCartExample example, @Param("selective") LitemallCart.Column... selective);

    List<LitemallCart> selectByExampleSelective(@Param("example") LitemallCartExample example, @Param("selective") LitemallCart.Column... selective);

    List<LitemallCart> selectByExample(LitemallCartExample example);

    LitemallCart selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallCart.Column... selective);

    LitemallCart selectByPrimaryKey(Integer id);

    LitemallCart selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallCart record, @Param("example") LitemallCartExample example);

    int updateByExample(@Param("record") LitemallCart record, @Param("example") LitemallCartExample example);

    int updateByPrimaryKeySelective(LitemallCart record);

    int updateByPrimaryKey(LitemallCart record);

    int logicalDeleteByExample(@Param("example") LitemallCartExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
