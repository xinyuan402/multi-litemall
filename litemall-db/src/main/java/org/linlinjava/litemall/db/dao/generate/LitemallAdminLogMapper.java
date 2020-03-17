package org.linlinjava.litemall.db.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.generate.LitemallAdminLog;
import org.linlinjava.litemall.db.domain.generate.LitemallAdminLogExample;

public interface LitemallAdminLogMapper {
    long countByExample(LitemallAdminLogExample example);

    int deleteByExample(LitemallAdminLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallAdminLog record);

    int insertSelective(LitemallAdminLog record);

    LitemallAdminLog selectOneByExample(LitemallAdminLogExample example);

    LitemallAdminLog selectOneByExampleSelective(@Param("example") LitemallAdminLogExample example, @Param("selective") LitemallAdminLog.Column ... selective);

    List<LitemallAdminLog> selectByExampleSelective(@Param("example") LitemallAdminLogExample example, @Param("selective") LitemallAdminLog.Column ... selective);

    List<LitemallAdminLog> selectByExample(LitemallAdminLogExample example);

    LitemallAdminLog selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallAdminLog.Column ... selective);

    LitemallAdminLog selectByPrimaryKey(Integer id);

    LitemallAdminLog selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallAdminLog record, @Param("example") LitemallAdminLogExample example);

    int updateByExample(@Param("record") LitemallAdminLog record, @Param("example") LitemallAdminLogExample example);

    int updateByPrimaryKeySelective(LitemallAdminLog record);

    int updateByPrimaryKey(LitemallAdminLog record);

    int logicalDeleteByExample(@Param("example") LitemallAdminLogExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}