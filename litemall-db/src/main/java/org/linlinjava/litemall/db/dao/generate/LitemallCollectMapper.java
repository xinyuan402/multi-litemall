package org.linlinjava.litemall.db.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.generate.LitemallCollect;
import org.linlinjava.litemall.db.domain.generate.LitemallCollectExample;

public interface LitemallCollectMapper {
    long countByExample(LitemallCollectExample example);

    int deleteByExample(LitemallCollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallCollect record);

    int insertSelective(LitemallCollect record);

    LitemallCollect selectOneByExample(LitemallCollectExample example);

    LitemallCollect selectOneByExampleSelective(@Param("example") LitemallCollectExample example, @Param("selective") LitemallCollect.Column ... selective);

    List<LitemallCollect> selectByExampleSelective(@Param("example") LitemallCollectExample example, @Param("selective") LitemallCollect.Column ... selective);

    List<LitemallCollect> selectByExample(LitemallCollectExample example);

    LitemallCollect selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallCollect.Column ... selective);

    LitemallCollect selectByPrimaryKey(Integer id);

    LitemallCollect selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallCollect record, @Param("example") LitemallCollectExample example);

    int updateByExample(@Param("record") LitemallCollect record, @Param("example") LitemallCollectExample example);

    int updateByPrimaryKeySelective(LitemallCollect record);

    int updateByPrimaryKey(LitemallCollect record);

    int logicalDeleteByExample(@Param("example") LitemallCollectExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}