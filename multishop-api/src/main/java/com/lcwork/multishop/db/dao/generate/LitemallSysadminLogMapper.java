package com.lcwork.multishop.db.dao.generate;

import com.lcwork.multishop.db.domain.generate.LitemallSysadminLog;
import com.lcwork.multishop.db.domain.generate.LitemallSysadminLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallSysadminLogMapper {
    long countByExample(LitemallSysadminLogExample example);

    int deleteByExample(LitemallSysadminLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallSysadminLog record);

    int insertSelective(LitemallSysadminLog record);

    LitemallSysadminLog selectOneByExample(LitemallSysadminLogExample example);

    LitemallSysadminLog selectOneByExampleSelective(@Param("example") LitemallSysadminLogExample example, @Param("selective") LitemallSysadminLog.Column... selective);

    List<LitemallSysadminLog> selectByExampleSelective(@Param("example") LitemallSysadminLogExample example, @Param("selective") LitemallSysadminLog.Column... selective);

    List<LitemallSysadminLog> selectByExample(LitemallSysadminLogExample example);

    LitemallSysadminLog selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallSysadminLog.Column... selective);

    LitemallSysadminLog selectByPrimaryKey(Integer id);

    LitemallSysadminLog selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallSysadminLog record, @Param("example") LitemallSysadminLogExample example);

    int updateByExample(@Param("record") LitemallSysadminLog record, @Param("example") LitemallSysadminLogExample example);

    int updateByPrimaryKeySelective(LitemallSysadminLog record);

    int updateByPrimaryKey(LitemallSysadminLog record);

    int logicalDeleteByExample(@Param("example") LitemallSysadminLogExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
