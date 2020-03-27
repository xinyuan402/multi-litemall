package com.lcwork.multishop.db.dao.generate;

import com.lcwork.multishop.db.domain.generate.LitemallAdminPermission;
import com.lcwork.multishop.db.domain.generate.LitemallAdminPermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallAdminPermissionMapper {
    long countByExample(LitemallAdminPermissionExample example);

    int deleteByExample(LitemallAdminPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallAdminPermission record);

    int insertSelective(LitemallAdminPermission record);

    LitemallAdminPermission selectOneByExample(LitemallAdminPermissionExample example);

    LitemallAdminPermission selectOneByExampleSelective(@Param("example") LitemallAdminPermissionExample example, @Param("selective") LitemallAdminPermission.Column... selective);

    List<LitemallAdminPermission> selectByExampleSelective(@Param("example") LitemallAdminPermissionExample example, @Param("selective") LitemallAdminPermission.Column... selective);

    List<LitemallAdminPermission> selectByExample(LitemallAdminPermissionExample example);

    LitemallAdminPermission selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallAdminPermission.Column... selective);

    LitemallAdminPermission selectByPrimaryKey(Integer id);

    LitemallAdminPermission selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallAdminPermission record, @Param("example") LitemallAdminPermissionExample example);

    int updateByExample(@Param("record") LitemallAdminPermission record, @Param("example") LitemallAdminPermissionExample example);

    int updateByPrimaryKeySelective(LitemallAdminPermission record);

    int updateByPrimaryKey(LitemallAdminPermission record);

    int logicalDeleteByExample(@Param("example") LitemallAdminPermissionExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
