package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallAdminRole;
import com.lcwork.multimall.db.domain.generate.MultimallAdminRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallAdminRoleMapper {
    long countByExample(MultimallAdminRoleExample example);

    int deleteByExample(MultimallAdminRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallAdminRole record);

    int insertSelective(MultimallAdminRole record);

    MultimallAdminRole selectOneByExample(MultimallAdminRoleExample example);

    MultimallAdminRole selectOneByExampleSelective(@Param("example") MultimallAdminRoleExample example, @Param("selective") MultimallAdminRole.Column ... selective);

    List<MultimallAdminRole> selectByExampleSelective(@Param("example") MultimallAdminRoleExample example, @Param("selective") MultimallAdminRole.Column ... selective);

    List<MultimallAdminRole> selectByExample(MultimallAdminRoleExample example);

    MultimallAdminRole selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallAdminRole.Column ... selective);

    MultimallAdminRole selectByPrimaryKey(Integer id);

    MultimallAdminRole selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallAdminRole record, @Param("example") MultimallAdminRoleExample example);

    int updateByExample(@Param("record") MultimallAdminRole record, @Param("example") MultimallAdminRoleExample example);

    int updateByPrimaryKeySelective(MultimallAdminRole record);

    int updateByPrimaryKey(MultimallAdminRole record);

    int logicalDeleteByExample(@Param("example") MultimallAdminRoleExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}