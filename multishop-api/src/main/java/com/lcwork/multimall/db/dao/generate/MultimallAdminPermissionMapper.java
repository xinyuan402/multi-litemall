package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallAdminPermission;
import com.lcwork.multimall.db.domain.generate.MultimallAdminPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallAdminPermissionMapper {
    long countByExample(MultimallAdminPermissionExample example);

    int deleteByExample(MultimallAdminPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallAdminPermission record);

    int insertSelective(MultimallAdminPermission record);

    MultimallAdminPermission selectOneByExample(MultimallAdminPermissionExample example);

    MultimallAdminPermission selectOneByExampleSelective(@Param("example") MultimallAdminPermissionExample example, @Param("selective") MultimallAdminPermission.Column ... selective);

    List<MultimallAdminPermission> selectByExampleSelective(@Param("example") MultimallAdminPermissionExample example, @Param("selective") MultimallAdminPermission.Column ... selective);

    List<MultimallAdminPermission> selectByExample(MultimallAdminPermissionExample example);

    MultimallAdminPermission selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallAdminPermission.Column ... selective);

    MultimallAdminPermission selectByPrimaryKey(Integer id);

    MultimallAdminPermission selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallAdminPermission record, @Param("example") MultimallAdminPermissionExample example);

    int updateByExample(@Param("record") MultimallAdminPermission record, @Param("example") MultimallAdminPermissionExample example);

    int updateByPrimaryKeySelective(MultimallAdminPermission record);

    int updateByPrimaryKey(MultimallAdminPermission record);

    int logicalDeleteByExample(@Param("example") MultimallAdminPermissionExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}