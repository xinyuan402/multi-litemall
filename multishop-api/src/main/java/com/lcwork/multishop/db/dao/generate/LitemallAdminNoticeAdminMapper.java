package com.lcwork.multishop.db.dao.generate;

import com.lcwork.multishop.db.domain.generate.LitemallAdminNoticeAdmin;
import com.lcwork.multishop.db.domain.generate.LitemallAdminNoticeAdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallAdminNoticeAdminMapper {
    long countByExample(LitemallAdminNoticeAdminExample example);

    int deleteByExample(LitemallAdminNoticeAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallAdminNoticeAdmin record);

    int insertSelective(LitemallAdminNoticeAdmin record);

    LitemallAdminNoticeAdmin selectOneByExample(LitemallAdminNoticeAdminExample example);

    LitemallAdminNoticeAdmin selectOneByExampleSelective(@Param("example") LitemallAdminNoticeAdminExample example, @Param("selective") LitemallAdminNoticeAdmin.Column... selective);

    List<LitemallAdminNoticeAdmin> selectByExampleSelective(@Param("example") LitemallAdminNoticeAdminExample example, @Param("selective") LitemallAdminNoticeAdmin.Column... selective);

    List<LitemallAdminNoticeAdmin> selectByExample(LitemallAdminNoticeAdminExample example);

    LitemallAdminNoticeAdmin selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallAdminNoticeAdmin.Column... selective);

    LitemallAdminNoticeAdmin selectByPrimaryKey(Integer id);

    LitemallAdminNoticeAdmin selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallAdminNoticeAdmin record, @Param("example") LitemallAdminNoticeAdminExample example);

    int updateByExample(@Param("record") LitemallAdminNoticeAdmin record, @Param("example") LitemallAdminNoticeAdminExample example);

    int updateByPrimaryKeySelective(LitemallAdminNoticeAdmin record);

    int updateByPrimaryKey(LitemallAdminNoticeAdmin record);

    int logicalDeleteByExample(@Param("example") LitemallAdminNoticeAdminExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
