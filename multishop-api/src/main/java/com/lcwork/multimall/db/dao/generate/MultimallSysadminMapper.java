package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallSysadmin;
import com.lcwork.multimall.db.domain.generate.MultimallSysadminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallSysadminMapper {
    long countByExample(MultimallSysadminExample example);

    int deleteByExample(MultimallSysadminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallSysadmin record);

    int insertSelective(MultimallSysadmin record);

    MultimallSysadmin selectOneByExample(MultimallSysadminExample example);

    MultimallSysadmin selectOneByExampleSelective(@Param("example") MultimallSysadminExample example, @Param("selective") MultimallSysadmin.Column ... selective);

    List<MultimallSysadmin> selectByExampleSelective(@Param("example") MultimallSysadminExample example, @Param("selective") MultimallSysadmin.Column ... selective);

    List<MultimallSysadmin> selectByExample(MultimallSysadminExample example);

    MultimallSysadmin selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallSysadmin.Column ... selective);

    MultimallSysadmin selectByPrimaryKey(Integer id);

    MultimallSysadmin selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallSysadmin record, @Param("example") MultimallSysadminExample example);

    int updateByExample(@Param("record") MultimallSysadmin record, @Param("example") MultimallSysadminExample example);

    int updateByPrimaryKeySelective(MultimallSysadmin record);

    int updateByPrimaryKey(MultimallSysadmin record);

    int logicalDeleteByExample(@Param("example") MultimallSysadminExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}