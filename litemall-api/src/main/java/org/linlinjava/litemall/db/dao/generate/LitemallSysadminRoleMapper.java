package org.linlinjava.litemall.db.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.generate.LitemallSysadminRole;
import org.linlinjava.litemall.db.domain.generate.LitemallSysadminRoleExample;

public interface LitemallSysadminRoleMapper {
    long countByExample(LitemallSysadminRoleExample example);

    int deleteByExample(LitemallSysadminRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallSysadminRole record);

    int insertSelective(LitemallSysadminRole record);

    LitemallSysadminRole selectOneByExample(LitemallSysadminRoleExample example);

    LitemallSysadminRole selectOneByExampleSelective(@Param("example") LitemallSysadminRoleExample example, @Param("selective") LitemallSysadminRole.Column ... selective);

    List<LitemallSysadminRole> selectByExampleSelective(@Param("example") LitemallSysadminRoleExample example, @Param("selective") LitemallSysadminRole.Column ... selective);

    List<LitemallSysadminRole> selectByExample(LitemallSysadminRoleExample example);

    LitemallSysadminRole selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallSysadminRole.Column ... selective);

    LitemallSysadminRole selectByPrimaryKey(Integer id);

    LitemallSysadminRole selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallSysadminRole record, @Param("example") LitemallSysadminRoleExample example);

    int updateByExample(@Param("record") LitemallSysadminRole record, @Param("example") LitemallSysadminRoleExample example);

    int updateByPrimaryKeySelective(LitemallSysadminRole record);

    int updateByPrimaryKey(LitemallSysadminRole record);

    int logicalDeleteByExample(@Param("example") LitemallSysadminRoleExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}