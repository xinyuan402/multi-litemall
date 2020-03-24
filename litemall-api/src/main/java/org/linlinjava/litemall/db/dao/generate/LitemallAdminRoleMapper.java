package org.linlinjava.litemall.db.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.generate.LitemallAdminRole;
import org.linlinjava.litemall.db.domain.generate.LitemallAdminRoleExample;

public interface LitemallAdminRoleMapper {
    long countByExample(LitemallAdminRoleExample example);

    int deleteByExample(LitemallAdminRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallAdminRole record);

    int insertSelective(LitemallAdminRole record);

    LitemallAdminRole selectOneByExample(LitemallAdminRoleExample example);

    LitemallAdminRole selectOneByExampleSelective(@Param("example") LitemallAdminRoleExample example, @Param("selective") LitemallAdminRole.Column ... selective);

    List<LitemallAdminRole> selectByExampleSelective(@Param("example") LitemallAdminRoleExample example, @Param("selective") LitemallAdminRole.Column ... selective);

    List<LitemallAdminRole> selectByExample(LitemallAdminRoleExample example);

    LitemallAdminRole selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallAdminRole.Column ... selective);

    LitemallAdminRole selectByPrimaryKey(Integer id);

    LitemallAdminRole selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallAdminRole record, @Param("example") LitemallAdminRoleExample example);

    int updateByExample(@Param("record") LitemallAdminRole record, @Param("example") LitemallAdminRoleExample example);

    int updateByPrimaryKeySelective(LitemallAdminRole record);

    int updateByPrimaryKey(LitemallAdminRole record);

    int logicalDeleteByExample(@Param("example") LitemallAdminRoleExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}