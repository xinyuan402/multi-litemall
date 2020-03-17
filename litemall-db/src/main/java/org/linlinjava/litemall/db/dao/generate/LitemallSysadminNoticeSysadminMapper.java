package org.linlinjava.litemall.db.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.generate.LitemallSysadminNoticeSysadmin;
import org.linlinjava.litemall.db.domain.generate.LitemallSysadminNoticeSysadminExample;

public interface LitemallSysadminNoticeSysadminMapper {
    long countByExample(LitemallSysadminNoticeSysadminExample example);

    int deleteByExample(LitemallSysadminNoticeSysadminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallSysadminNoticeSysadmin record);

    int insertSelective(LitemallSysadminNoticeSysadmin record);

    LitemallSysadminNoticeSysadmin selectOneByExample(LitemallSysadminNoticeSysadminExample example);

    LitemallSysadminNoticeSysadmin selectOneByExampleSelective(@Param("example") LitemallSysadminNoticeSysadminExample example, @Param("selective") LitemallSysadminNoticeSysadmin.Column ... selective);

    List<LitemallSysadminNoticeSysadmin> selectByExampleSelective(@Param("example") LitemallSysadminNoticeSysadminExample example, @Param("selective") LitemallSysadminNoticeSysadmin.Column ... selective);

    List<LitemallSysadminNoticeSysadmin> selectByExample(LitemallSysadminNoticeSysadminExample example);

    LitemallSysadminNoticeSysadmin selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallSysadminNoticeSysadmin.Column ... selective);

    LitemallSysadminNoticeSysadmin selectByPrimaryKey(Integer id);

    LitemallSysadminNoticeSysadmin selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallSysadminNoticeSysadmin record, @Param("example") LitemallSysadminNoticeSysadminExample example);

    int updateByExample(@Param("record") LitemallSysadminNoticeSysadmin record, @Param("example") LitemallSysadminNoticeSysadminExample example);

    int updateByPrimaryKeySelective(LitemallSysadminNoticeSysadmin record);

    int updateByPrimaryKey(LitemallSysadminNoticeSysadmin record);

    int logicalDeleteByExample(@Param("example") LitemallSysadminNoticeSysadminExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}