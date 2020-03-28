package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallKeyword;
import com.lcwork.multimall.db.domain.generate.MultimallKeywordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallKeywordMapper {
    long countByExample(MultimallKeywordExample example);

    int deleteByExample(MultimallKeywordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallKeyword record);

    int insertSelective(MultimallKeyword record);

    MultimallKeyword selectOneByExample(MultimallKeywordExample example);

    MultimallKeyword selectOneByExampleSelective(@Param("example") MultimallKeywordExample example, @Param("selective") MultimallKeyword.Column ... selective);

    List<MultimallKeyword> selectByExampleSelective(@Param("example") MultimallKeywordExample example, @Param("selective") MultimallKeyword.Column ... selective);

    List<MultimallKeyword> selectByExample(MultimallKeywordExample example);

    MultimallKeyword selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallKeyword.Column ... selective);

    MultimallKeyword selectByPrimaryKey(Integer id);

    MultimallKeyword selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallKeyword record, @Param("example") MultimallKeywordExample example);

    int updateByExample(@Param("record") MultimallKeyword record, @Param("example") MultimallKeywordExample example);

    int updateByPrimaryKeySelective(MultimallKeyword record);

    int updateByPrimaryKey(MultimallKeyword record);

    int logicalDeleteByExample(@Param("example") MultimallKeywordExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}