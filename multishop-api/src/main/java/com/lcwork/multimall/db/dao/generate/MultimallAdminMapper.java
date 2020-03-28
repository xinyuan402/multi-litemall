package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallAdmin;
import com.lcwork.multimall.db.domain.generate.MultimallAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallAdminMapper {
    long countByExample(MultimallAdminExample example);

    int deleteByExample(MultimallAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallAdmin record);

    int insertSelective(MultimallAdmin record);

    MultimallAdmin selectOneByExample(MultimallAdminExample example);

    MultimallAdmin selectOneByExampleSelective(@Param("example") MultimallAdminExample example, @Param("selective") MultimallAdmin.Column ... selective);

    List<MultimallAdmin> selectByExampleSelective(@Param("example") MultimallAdminExample example, @Param("selective") MultimallAdmin.Column ... selective);

    List<MultimallAdmin> selectByExample(MultimallAdminExample example);

    MultimallAdmin selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallAdmin.Column ... selective);

    MultimallAdmin selectByPrimaryKey(Integer id);

    MultimallAdmin selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallAdmin record, @Param("example") MultimallAdminExample example);

    int updateByExample(@Param("record") MultimallAdmin record, @Param("example") MultimallAdminExample example);

    int updateByPrimaryKeySelective(MultimallAdmin record);

    int updateByPrimaryKey(MultimallAdmin record);

    int logicalDeleteByExample(@Param("example") MultimallAdminExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}