package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallGroupon;
import com.lcwork.multimall.db.domain.generate.MultimallGrouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallGrouponMapper {
    long countByExample(MultimallGrouponExample example);

    int deleteByExample(MultimallGrouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallGroupon record);

    int insertSelective(MultimallGroupon record);

    MultimallGroupon selectOneByExample(MultimallGrouponExample example);

    MultimallGroupon selectOneByExampleSelective(@Param("example") MultimallGrouponExample example, @Param("selective") MultimallGroupon.Column ... selective);

    List<MultimallGroupon> selectByExampleSelective(@Param("example") MultimallGrouponExample example, @Param("selective") MultimallGroupon.Column ... selective);

    List<MultimallGroupon> selectByExample(MultimallGrouponExample example);

    MultimallGroupon selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallGroupon.Column ... selective);

    MultimallGroupon selectByPrimaryKey(Integer id);

    MultimallGroupon selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallGroupon record, @Param("example") MultimallGrouponExample example);

    int updateByExample(@Param("record") MultimallGroupon record, @Param("example") MultimallGrouponExample example);

    int updateByPrimaryKeySelective(MultimallGroupon record);

    int updateByPrimaryKey(MultimallGroupon record);

    int logicalDeleteByExample(@Param("example") MultimallGrouponExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}