package org.linlinjava.litemall.db.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.generate.LitemallSysadmin;
import org.linlinjava.litemall.db.domain.generate.LitemallSysadminExample;

public interface LitemallSysadminMapper {
    long countByExample(LitemallSysadminExample example);

    int deleteByExample(LitemallSysadminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallSysadmin record);

    int insertSelective(LitemallSysadmin record);

    LitemallSysadmin selectOneByExample(LitemallSysadminExample example);

    LitemallSysadmin selectOneByExampleSelective(@Param("example") LitemallSysadminExample example, @Param("selective") LitemallSysadmin.Column ... selective);

    List<LitemallSysadmin> selectByExampleSelective(@Param("example") LitemallSysadminExample example, @Param("selective") LitemallSysadmin.Column ... selective);

    List<LitemallSysadmin> selectByExample(LitemallSysadminExample example);

    LitemallSysadmin selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallSysadmin.Column ... selective);

    LitemallSysadmin selectByPrimaryKey(Integer id);

    LitemallSysadmin selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallSysadmin record, @Param("example") LitemallSysadminExample example);

    int updateByExample(@Param("record") LitemallSysadmin record, @Param("example") LitemallSysadminExample example);

    int updateByPrimaryKeySelective(LitemallSysadmin record);

    int updateByPrimaryKey(LitemallSysadmin record);

    int logicalDeleteByExample(@Param("example") LitemallSysadminExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}