package com.lcwork.multishop.db.dao.generate;

import com.lcwork.multishop.db.domain.generate.LitemallSysadminPermission;
import com.lcwork.multishop.db.domain.generate.LitemallSysadminPermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallSysadminPermissionMapper {
    long countByExample(LitemallSysadminPermissionExample example);

    int deleteByExample(LitemallSysadminPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallSysadminPermission record);

    int insertSelective(LitemallSysadminPermission record);

    LitemallSysadminPermission selectOneByExample(LitemallSysadminPermissionExample example);

    LitemallSysadminPermission selectOneByExampleSelective(@Param("example") LitemallSysadminPermissionExample example, @Param("selective") LitemallSysadminPermission.Column... selective);

    List<LitemallSysadminPermission> selectByExampleSelective(@Param("example") LitemallSysadminPermissionExample example, @Param("selective") LitemallSysadminPermission.Column... selective);

    List<LitemallSysadminPermission> selectByExample(LitemallSysadminPermissionExample example);

    LitemallSysadminPermission selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallSysadminPermission.Column... selective);

    LitemallSysadminPermission selectByPrimaryKey(Integer id);

    LitemallSysadminPermission selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallSysadminPermission record, @Param("example") LitemallSysadminPermissionExample example);

    int updateByExample(@Param("record") LitemallSysadminPermission record, @Param("example") LitemallSysadminPermissionExample example);

    int updateByPrimaryKeySelective(LitemallSysadminPermission record);

    int updateByPrimaryKey(LitemallSysadminPermission record);

    int logicalDeleteByExample(@Param("example") LitemallSysadminPermissionExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
