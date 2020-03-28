package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallSysadminNoticeSysadmin;
import com.lcwork.multimall.db.domain.generate.MultimallSysadminNoticeSysadminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallSysadminNoticeSysadminMapper {
    long countByExample(MultimallSysadminNoticeSysadminExample example);

    int deleteByExample(MultimallSysadminNoticeSysadminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallSysadminNoticeSysadmin record);

    int insertSelective(MultimallSysadminNoticeSysadmin record);

    MultimallSysadminNoticeSysadmin selectOneByExample(MultimallSysadminNoticeSysadminExample example);

    MultimallSysadminNoticeSysadmin selectOneByExampleSelective(@Param("example") MultimallSysadminNoticeSysadminExample example, @Param("selective") MultimallSysadminNoticeSysadmin.Column ... selective);

    List<MultimallSysadminNoticeSysadmin> selectByExampleSelective(@Param("example") MultimallSysadminNoticeSysadminExample example, @Param("selective") MultimallSysadminNoticeSysadmin.Column ... selective);

    List<MultimallSysadminNoticeSysadmin> selectByExample(MultimallSysadminNoticeSysadminExample example);

    MultimallSysadminNoticeSysadmin selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallSysadminNoticeSysadmin.Column ... selective);

    MultimallSysadminNoticeSysadmin selectByPrimaryKey(Integer id);

    MultimallSysadminNoticeSysadmin selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallSysadminNoticeSysadmin record, @Param("example") MultimallSysadminNoticeSysadminExample example);

    int updateByExample(@Param("record") MultimallSysadminNoticeSysadmin record, @Param("example") MultimallSysadminNoticeSysadminExample example);

    int updateByPrimaryKeySelective(MultimallSysadminNoticeSysadmin record);

    int updateByPrimaryKey(MultimallSysadminNoticeSysadmin record);

    int logicalDeleteByExample(@Param("example") MultimallSysadminNoticeSysadminExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}