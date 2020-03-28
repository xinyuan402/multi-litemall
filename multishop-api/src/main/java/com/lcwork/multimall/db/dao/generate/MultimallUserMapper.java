package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallUser;
import com.lcwork.multimall.db.domain.generate.MultimallUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallUserMapper {
    long countByExample(MultimallUserExample example);

    int deleteByExample(MultimallUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallUser record);

    int insertSelective(MultimallUser record);

    MultimallUser selectOneByExample(MultimallUserExample example);

    MultimallUser selectOneByExampleSelective(@Param("example") MultimallUserExample example, @Param("selective") MultimallUser.Column ... selective);

    List<MultimallUser> selectByExampleSelective(@Param("example") MultimallUserExample example, @Param("selective") MultimallUser.Column ... selective);

    List<MultimallUser> selectByExample(MultimallUserExample example);

    MultimallUser selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallUser.Column ... selective);

    MultimallUser selectByPrimaryKey(Integer id);

    MultimallUser selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallUser record, @Param("example") MultimallUserExample example);

    int updateByExample(@Param("record") MultimallUser record, @Param("example") MultimallUserExample example);

    int updateByPrimaryKeySelective(MultimallUser record);

    int updateByPrimaryKey(MultimallUser record);

    int logicalDeleteByExample(@Param("example") MultimallUserExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}