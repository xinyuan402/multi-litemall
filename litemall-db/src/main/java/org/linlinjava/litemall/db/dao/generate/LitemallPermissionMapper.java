package org.linlinjava.litemall.db.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.generate.LitemallPermission;
import org.linlinjava.litemall.db.domain.generate.LitemallPermissionExample;

public interface LitemallPermissionMapper {
    long countByExample(LitemallPermissionExample example);

    int deleteByExample(LitemallPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallPermission record);

    int insertSelective(LitemallPermission record);

    LitemallPermission selectOneByExample(LitemallPermissionExample example);

    LitemallPermission selectOneByExampleSelective(@Param("example") LitemallPermissionExample example, @Param("selective") LitemallPermission.Column ... selective);

    List<LitemallPermission> selectByExampleSelective(@Param("example") LitemallPermissionExample example, @Param("selective") LitemallPermission.Column ... selective);

    List<LitemallPermission> selectByExample(LitemallPermissionExample example);

    LitemallPermission selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallPermission.Column ... selective);

    LitemallPermission selectByPrimaryKey(Integer id);

    LitemallPermission selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallPermission record, @Param("example") LitemallPermissionExample example);

    int updateByExample(@Param("record") LitemallPermission record, @Param("example") LitemallPermissionExample example);

    int updateByPrimaryKeySelective(LitemallPermission record);

    int updateByPrimaryKey(LitemallPermission record);

    int logicalDeleteByExample(@Param("example") LitemallPermissionExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}