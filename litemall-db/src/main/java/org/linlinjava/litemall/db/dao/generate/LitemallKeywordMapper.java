package org.linlinjava.litemall.db.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.generate.LitemallKeyword;
import org.linlinjava.litemall.db.domain.generate.LitemallKeywordExample;

public interface LitemallKeywordMapper {
    long countByExample(LitemallKeywordExample example);

    int deleteByExample(LitemallKeywordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallKeyword record);

    int insertSelective(LitemallKeyword record);

    LitemallKeyword selectOneByExample(LitemallKeywordExample example);

    LitemallKeyword selectOneByExampleSelective(@Param("example") LitemallKeywordExample example, @Param("selective") LitemallKeyword.Column ... selective);

    List<LitemallKeyword> selectByExampleSelective(@Param("example") LitemallKeywordExample example, @Param("selective") LitemallKeyword.Column ... selective);

    List<LitemallKeyword> selectByExample(LitemallKeywordExample example);

    LitemallKeyword selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallKeyword.Column ... selective);

    LitemallKeyword selectByPrimaryKey(Integer id);

    LitemallKeyword selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallKeyword record, @Param("example") LitemallKeywordExample example);

    int updateByExample(@Param("record") LitemallKeyword record, @Param("example") LitemallKeywordExample example);

    int updateByPrimaryKeySelective(LitemallKeyword record);

    int updateByPrimaryKey(LitemallKeyword record);

    int logicalDeleteByExample(@Param("example") LitemallKeywordExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}