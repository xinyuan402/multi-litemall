package org.linlinjava.litemall.db.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.generate.LitemallNotice;
import org.linlinjava.litemall.db.domain.generate.LitemallNoticeExample;

public interface LitemallNoticeMapper {
    long countByExample(LitemallNoticeExample example);

    int deleteByExample(LitemallNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallNotice record);

    int insertSelective(LitemallNotice record);

    LitemallNotice selectOneByExample(LitemallNoticeExample example);

    LitemallNotice selectOneByExampleSelective(@Param("example") LitemallNoticeExample example, @Param("selective") LitemallNotice.Column ... selective);

    List<LitemallNotice> selectByExampleSelective(@Param("example") LitemallNoticeExample example, @Param("selective") LitemallNotice.Column ... selective);

    List<LitemallNotice> selectByExample(LitemallNoticeExample example);

    LitemallNotice selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallNotice.Column ... selective);

    LitemallNotice selectByPrimaryKey(Integer id);

    LitemallNotice selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallNotice record, @Param("example") LitemallNoticeExample example);

    int updateByExample(@Param("record") LitemallNotice record, @Param("example") LitemallNoticeExample example);

    int updateByPrimaryKeySelective(LitemallNotice record);

    int updateByPrimaryKey(LitemallNotice record);

    int logicalDeleteByExample(@Param("example") LitemallNoticeExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}