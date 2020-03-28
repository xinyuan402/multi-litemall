package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallSysadminRole;
import com.lcwork.multimall.db.domain.generate.MultimallSysadminRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallSysadminRoleMapper {
    long countByExample(MultimallSysadminRoleExample example);

    int deleteByExample(MultimallSysadminRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallSysadminRole record);

    int insertSelective(MultimallSysadminRole record);

    MultimallSysadminRole selectOneByExample(MultimallSysadminRoleExample example);

    MultimallSysadminRole selectOneByExampleSelective(@Param("example") MultimallSysadminRoleExample example, @Param("selective") MultimallSysadminRole.Column ... selective);

    List<MultimallSysadminRole> selectByExampleSelective(@Param("example") MultimallSysadminRoleExample example, @Param("selective") MultimallSysadminRole.Column ... selective);

    List<MultimallSysadminRole> selectByExample(MultimallSysadminRoleExample example);

    MultimallSysadminRole selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallSysadminRole.Column ... selective);

    MultimallSysadminRole selectByPrimaryKey(Integer id);

    MultimallSysadminRole selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallSysadminRole record, @Param("example") MultimallSysadminRoleExample example);

    int updateByExample(@Param("record") MultimallSysadminRole record, @Param("example") MultimallSysadminRoleExample example);

    int updateByPrimaryKeySelective(MultimallSysadminRole record);

    int updateByPrimaryKey(MultimallSysadminRole record);

    int logicalDeleteByExample(@Param("example") MultimallSysadminRoleExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}