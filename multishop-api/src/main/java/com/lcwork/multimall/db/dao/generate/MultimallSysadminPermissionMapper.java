package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallSysadminPermission;
import com.lcwork.multimall.db.domain.generate.MultimallSysadminPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallSysadminPermissionMapper {
    long countByExample(MultimallSysadminPermissionExample example);

    int deleteByExample(MultimallSysadminPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallSysadminPermission record);

    int insertSelective(MultimallSysadminPermission record);

    MultimallSysadminPermission selectOneByExample(MultimallSysadminPermissionExample example);

    MultimallSysadminPermission selectOneByExampleSelective(@Param("example") MultimallSysadminPermissionExample example, @Param("selective") MultimallSysadminPermission.Column ... selective);

    List<MultimallSysadminPermission> selectByExampleSelective(@Param("example") MultimallSysadminPermissionExample example, @Param("selective") MultimallSysadminPermission.Column ... selective);

    List<MultimallSysadminPermission> selectByExample(MultimallSysadminPermissionExample example);

    MultimallSysadminPermission selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallSysadminPermission.Column ... selective);

    MultimallSysadminPermission selectByPrimaryKey(Integer id);

    MultimallSysadminPermission selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallSysadminPermission record, @Param("example") MultimallSysadminPermissionExample example);

    int updateByExample(@Param("record") MultimallSysadminPermission record, @Param("example") MultimallSysadminPermissionExample example);

    int updateByPrimaryKeySelective(MultimallSysadminPermission record);

    int updateByPrimaryKey(MultimallSysadminPermission record);

    int logicalDeleteByExample(@Param("example") MultimallSysadminPermissionExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}