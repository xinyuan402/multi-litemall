package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallCart;
import com.lcwork.multimall.db.domain.generate.MultimallCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallCartMapper {
    long countByExample(MultimallCartExample example);

    int deleteByExample(MultimallCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallCart record);

    int insertSelective(MultimallCart record);

    MultimallCart selectOneByExample(MultimallCartExample example);

    MultimallCart selectOneByExampleSelective(@Param("example") MultimallCartExample example, @Param("selective") MultimallCart.Column ... selective);

    List<MultimallCart> selectByExampleSelective(@Param("example") MultimallCartExample example, @Param("selective") MultimallCart.Column ... selective);

    List<MultimallCart> selectByExample(MultimallCartExample example);

    MultimallCart selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallCart.Column ... selective);

    MultimallCart selectByPrimaryKey(Integer id);

    MultimallCart selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallCart record, @Param("example") MultimallCartExample example);

    int updateByExample(@Param("record") MultimallCart record, @Param("example") MultimallCartExample example);

    int updateByPrimaryKeySelective(MultimallCart record);

    int updateByPrimaryKey(MultimallCart record);

    int logicalDeleteByExample(@Param("example") MultimallCartExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}