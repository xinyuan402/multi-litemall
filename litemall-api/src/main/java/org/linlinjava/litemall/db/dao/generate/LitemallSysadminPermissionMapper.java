package org.linlinjava.litemall.db.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.generate.LitemallSysadminPermission;
import org.linlinjava.litemall.db.domain.generate.LitemallSysadminPermissionExample;

public interface LitemallSysadminPermissionMapper {
    long countByExample(LitemallSysadminPermissionExample example);

    int deleteByExample(LitemallSysadminPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallSysadminPermission record);

    int insertSelective(LitemallSysadminPermission record);

    LitemallSysadminPermission selectOneByExample(LitemallSysadminPermissionExample example);

    LitemallSysadminPermission selectOneByExampleSelective(@Param("example") LitemallSysadminPermissionExample example, @Param("selective") LitemallSysadminPermission.Column ... selective);

    List<LitemallSysadminPermission> selectByExampleSelective(@Param("example") LitemallSysadminPermissionExample example, @Param("selective") LitemallSysadminPermission.Column ... selective);

    List<LitemallSysadminPermission> selectByExample(LitemallSysadminPermissionExample example);

    LitemallSysadminPermission selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallSysadminPermission.Column ... selective);

    LitemallSysadminPermission selectByPrimaryKey(Integer id);

    LitemallSysadminPermission selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallSysadminPermission record, @Param("example") LitemallSysadminPermissionExample example);

    int updateByExample(@Param("record") LitemallSysadminPermission record, @Param("example") LitemallSysadminPermissionExample example);

    int updateByPrimaryKeySelective(LitemallSysadminPermission record);

    int updateByPrimaryKey(LitemallSysadminPermission record);

    int logicalDeleteByExample(@Param("example") LitemallSysadminPermissionExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}