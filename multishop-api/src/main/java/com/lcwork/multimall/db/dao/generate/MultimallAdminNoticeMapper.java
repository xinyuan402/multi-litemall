package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallAdminNotice;
import com.lcwork.multimall.db.domain.generate.MultimallAdminNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallAdminNoticeMapper {
    long countByExample(MultimallAdminNoticeExample example);

    int deleteByExample(MultimallAdminNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallAdminNotice record);

    int insertSelective(MultimallAdminNotice record);

    MultimallAdminNotice selectOneByExample(MultimallAdminNoticeExample example);

    MultimallAdminNotice selectOneByExampleSelective(@Param("example") MultimallAdminNoticeExample example, @Param("selective") MultimallAdminNotice.Column ... selective);

    List<MultimallAdminNotice> selectByExampleSelective(@Param("example") MultimallAdminNoticeExample example, @Param("selective") MultimallAdminNotice.Column ... selective);

    List<MultimallAdminNotice> selectByExample(MultimallAdminNoticeExample example);

    MultimallAdminNotice selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallAdminNotice.Column ... selective);

    MultimallAdminNotice selectByPrimaryKey(Integer id);

    MultimallAdminNotice selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallAdminNotice record, @Param("example") MultimallAdminNoticeExample example);

    int updateByExample(@Param("record") MultimallAdminNotice record, @Param("example") MultimallAdminNoticeExample example);

    int updateByPrimaryKeySelective(MultimallAdminNotice record);

    int updateByPrimaryKey(MultimallAdminNotice record);

    int logicalDeleteByExample(@Param("example") MultimallAdminNoticeExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}