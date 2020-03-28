package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallAdminLog;
import com.lcwork.multimall.db.domain.generate.MultimallAdminLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallAdminLogMapper {
    long countByExample(MultimallAdminLogExample example);

    int deleteByExample(MultimallAdminLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallAdminLog record);

    int insertSelective(MultimallAdminLog record);

    MultimallAdminLog selectOneByExample(MultimallAdminLogExample example);

    MultimallAdminLog selectOneByExampleSelective(@Param("example") MultimallAdminLogExample example, @Param("selective") MultimallAdminLog.Column ... selective);

    List<MultimallAdminLog> selectByExampleSelective(@Param("example") MultimallAdminLogExample example, @Param("selective") MultimallAdminLog.Column ... selective);

    List<MultimallAdminLog> selectByExample(MultimallAdminLogExample example);

    MultimallAdminLog selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallAdminLog.Column ... selective);

    MultimallAdminLog selectByPrimaryKey(Integer id);

    MultimallAdminLog selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallAdminLog record, @Param("example") MultimallAdminLogExample example);

    int updateByExample(@Param("record") MultimallAdminLog record, @Param("example") MultimallAdminLogExample example);

    int updateByPrimaryKeySelective(MultimallAdminLog record);

    int updateByPrimaryKey(MultimallAdminLog record);

    int logicalDeleteByExample(@Param("example") MultimallAdminLogExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}