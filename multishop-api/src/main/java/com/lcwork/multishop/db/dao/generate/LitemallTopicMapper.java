package com.lcwork.multishop.db.dao.generate;

import com.lcwork.multishop.db.domain.generate.LitemallTopic;
import com.lcwork.multishop.db.domain.generate.LitemallTopicExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallTopicMapper {
    long countByExample(LitemallTopicExample example);

    int deleteByExample(LitemallTopicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallTopic record);

    int insertSelective(LitemallTopic record);

    LitemallTopic selectOneByExample(LitemallTopicExample example);

    LitemallTopic selectOneByExampleSelective(@Param("example") LitemallTopicExample example, @Param("selective") LitemallTopic.Column... selective);

    LitemallTopic selectOneByExampleWithBLOBs(LitemallTopicExample example);

    List<LitemallTopic> selectByExampleSelective(@Param("example") LitemallTopicExample example, @Param("selective") LitemallTopic.Column... selective);

    List<LitemallTopic> selectByExampleWithBLOBs(LitemallTopicExample example);

    List<LitemallTopic> selectByExample(LitemallTopicExample example);

    LitemallTopic selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallTopic.Column... selective);

    LitemallTopic selectByPrimaryKey(Integer id);

    LitemallTopic selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallTopic record, @Param("example") LitemallTopicExample example);

    int updateByExampleWithBLOBs(@Param("record") LitemallTopic record, @Param("example") LitemallTopicExample example);

    int updateByExample(@Param("record") LitemallTopic record, @Param("example") LitemallTopicExample example);

    int updateByPrimaryKeySelective(LitemallTopic record);

    int updateByPrimaryKeyWithBLOBs(LitemallTopic record);

    int updateByPrimaryKey(LitemallTopic record);

    int logicalDeleteByExample(@Param("example") LitemallTopicExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
