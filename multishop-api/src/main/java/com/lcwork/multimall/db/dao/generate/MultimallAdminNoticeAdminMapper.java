package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallAdminNoticeAdmin;
import com.lcwork.multimall.db.domain.generate.MultimallAdminNoticeAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallAdminNoticeAdminMapper {
    long countByExample(MultimallAdminNoticeAdminExample example);

    int deleteByExample(MultimallAdminNoticeAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallAdminNoticeAdmin record);

    int insertSelective(MultimallAdminNoticeAdmin record);

    MultimallAdminNoticeAdmin selectOneByExample(MultimallAdminNoticeAdminExample example);

    MultimallAdminNoticeAdmin selectOneByExampleSelective(@Param("example") MultimallAdminNoticeAdminExample example, @Param("selective") MultimallAdminNoticeAdmin.Column ... selective);

    List<MultimallAdminNoticeAdmin> selectByExampleSelective(@Param("example") MultimallAdminNoticeAdminExample example, @Param("selective") MultimallAdminNoticeAdmin.Column ... selective);

    List<MultimallAdminNoticeAdmin> selectByExample(MultimallAdminNoticeAdminExample example);

    MultimallAdminNoticeAdmin selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallAdminNoticeAdmin.Column ... selective);

    MultimallAdminNoticeAdmin selectByPrimaryKey(Integer id);

    MultimallAdminNoticeAdmin selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallAdminNoticeAdmin record, @Param("example") MultimallAdminNoticeAdminExample example);

    int updateByExample(@Param("record") MultimallAdminNoticeAdmin record, @Param("example") MultimallAdminNoticeAdminExample example);

    int updateByPrimaryKeySelective(MultimallAdminNoticeAdmin record);

    int updateByPrimaryKey(MultimallAdminNoticeAdmin record);

    int logicalDeleteByExample(@Param("example") MultimallAdminNoticeAdminExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}