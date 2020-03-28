package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallSysadminLog;
import com.lcwork.multimall.db.domain.generate.MultimallSysadminLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallSysadminLogMapper {
    long countByExample(MultimallSysadminLogExample example);

    int deleteByExample(MultimallSysadminLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallSysadminLog record);

    int insertSelective(MultimallSysadminLog record);

    MultimallSysadminLog selectOneByExample(MultimallSysadminLogExample example);

    MultimallSysadminLog selectOneByExampleSelective(@Param("example") MultimallSysadminLogExample example, @Param("selective") MultimallSysadminLog.Column ... selective);

    List<MultimallSysadminLog> selectByExampleSelective(@Param("example") MultimallSysadminLogExample example, @Param("selective") MultimallSysadminLog.Column ... selective);

    List<MultimallSysadminLog> selectByExample(MultimallSysadminLogExample example);

    MultimallSysadminLog selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallSysadminLog.Column ... selective);

    MultimallSysadminLog selectByPrimaryKey(Integer id);

    MultimallSysadminLog selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallSysadminLog record, @Param("example") MultimallSysadminLogExample example);

    int updateByExample(@Param("record") MultimallSysadminLog record, @Param("example") MultimallSysadminLogExample example);

    int updateByPrimaryKeySelective(MultimallSysadminLog record);

    int updateByPrimaryKey(MultimallSysadminLog record);

    int logicalDeleteByExample(@Param("example") MultimallSysadminLogExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}