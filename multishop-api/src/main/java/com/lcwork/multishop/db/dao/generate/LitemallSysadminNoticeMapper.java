package com.lcwork.multishop.db.dao.generate;

import com.lcwork.multishop.db.domain.generate.LitemallSysadminNotice;
import com.lcwork.multishop.db.domain.generate.LitemallSysadminNoticeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallSysadminNoticeMapper {
    long countByExample(LitemallSysadminNoticeExample example);

    int deleteByExample(LitemallSysadminNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallSysadminNotice record);

    int insertSelective(LitemallSysadminNotice record);

    LitemallSysadminNotice selectOneByExample(LitemallSysadminNoticeExample example);

    LitemallSysadminNotice selectOneByExampleSelective(@Param("example") LitemallSysadminNoticeExample example, @Param("selective") LitemallSysadminNotice.Column... selective);

    List<LitemallSysadminNotice> selectByExampleSelective(@Param("example") LitemallSysadminNoticeExample example, @Param("selective") LitemallSysadminNotice.Column... selective);

    List<LitemallSysadminNotice> selectByExample(LitemallSysadminNoticeExample example);

    LitemallSysadminNotice selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallSysadminNotice.Column... selective);

    LitemallSysadminNotice selectByPrimaryKey(Integer id);

    LitemallSysadminNotice selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallSysadminNotice record, @Param("example") LitemallSysadminNoticeExample example);

    int updateByExample(@Param("record") LitemallSysadminNotice record, @Param("example") LitemallSysadminNoticeExample example);

    int updateByPrimaryKeySelective(LitemallSysadminNotice record);

    int updateByPrimaryKey(LitemallSysadminNotice record);

    int logicalDeleteByExample(@Param("example") LitemallSysadminNoticeExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}