package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallTopic;
import com.lcwork.multimall.db.domain.generate.MultimallTopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallTopicMapper {
    long countByExample(MultimallTopicExample example);

    int deleteByExample(MultimallTopicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallTopic record);

    int insertSelective(MultimallTopic record);

    MultimallTopic selectOneByExample(MultimallTopicExample example);

    MultimallTopic selectOneByExampleSelective(@Param("example") MultimallTopicExample example, @Param("selective") MultimallTopic.Column ... selective);

    MultimallTopic selectOneByExampleWithBLOBs(MultimallTopicExample example);

    List<MultimallTopic> selectByExampleSelective(@Param("example") MultimallTopicExample example, @Param("selective") MultimallTopic.Column ... selective);

    List<MultimallTopic> selectByExampleWithBLOBs(MultimallTopicExample example);

    List<MultimallTopic> selectByExample(MultimallTopicExample example);

    MultimallTopic selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallTopic.Column ... selective);

    MultimallTopic selectByPrimaryKey(Integer id);

    MultimallTopic selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallTopic record, @Param("example") MultimallTopicExample example);

    int updateByExampleWithBLOBs(@Param("record") MultimallTopic record, @Param("example") MultimallTopicExample example);

    int updateByExample(@Param("record") MultimallTopic record, @Param("example") MultimallTopicExample example);

    int updateByPrimaryKeySelective(MultimallTopic record);

    int updateByPrimaryKeyWithBLOBs(MultimallTopic record);

    int updateByPrimaryKey(MultimallTopic record);

    int logicalDeleteByExample(@Param("example") MultimallTopicExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}