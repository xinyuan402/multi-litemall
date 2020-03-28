package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallSysadminNotice;
import com.lcwork.multimall.db.domain.generate.MultimallSysadminNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallSysadminNoticeMapper {
    long countByExample(MultimallSysadminNoticeExample example);

    int deleteByExample(MultimallSysadminNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallSysadminNotice record);

    int insertSelective(MultimallSysadminNotice record);

    MultimallSysadminNotice selectOneByExample(MultimallSysadminNoticeExample example);

    MultimallSysadminNotice selectOneByExampleSelective(@Param("example") MultimallSysadminNoticeExample example, @Param("selective") MultimallSysadminNotice.Column ... selective);

    List<MultimallSysadminNotice> selectByExampleSelective(@Param("example") MultimallSysadminNoticeExample example, @Param("selective") MultimallSysadminNotice.Column ... selective);

    List<MultimallSysadminNotice> selectByExample(MultimallSysadminNoticeExample example);

    MultimallSysadminNotice selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallSysadminNotice.Column ... selective);

    MultimallSysadminNotice selectByPrimaryKey(Integer id);

    MultimallSysadminNotice selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallSysadminNotice record, @Param("example") MultimallSysadminNoticeExample example);

    int updateByExample(@Param("record") MultimallSysadminNotice record, @Param("example") MultimallSysadminNoticeExample example);

    int updateByPrimaryKeySelective(MultimallSysadminNotice record);

    int updateByPrimaryKey(MultimallSysadminNotice record);

    int logicalDeleteByExample(@Param("example") MultimallSysadminNoticeExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}