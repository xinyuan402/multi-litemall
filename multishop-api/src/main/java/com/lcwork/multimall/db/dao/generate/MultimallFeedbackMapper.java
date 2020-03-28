package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallFeedback;
import com.lcwork.multimall.db.domain.generate.MultimallFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallFeedbackMapper {
    long countByExample(MultimallFeedbackExample example);

    int deleteByExample(MultimallFeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallFeedback record);

    int insertSelective(MultimallFeedback record);

    MultimallFeedback selectOneByExample(MultimallFeedbackExample example);

    MultimallFeedback selectOneByExampleSelective(@Param("example") MultimallFeedbackExample example, @Param("selective") MultimallFeedback.Column ... selective);

    List<MultimallFeedback> selectByExampleSelective(@Param("example") MultimallFeedbackExample example, @Param("selective") MultimallFeedback.Column ... selective);

    List<MultimallFeedback> selectByExample(MultimallFeedbackExample example);

    MultimallFeedback selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallFeedback.Column ... selective);

    MultimallFeedback selectByPrimaryKey(Integer id);

    MultimallFeedback selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallFeedback record, @Param("example") MultimallFeedbackExample example);

    int updateByExample(@Param("record") MultimallFeedback record, @Param("example") MultimallFeedbackExample example);

    int updateByPrimaryKeySelective(MultimallFeedback record);

    int updateByPrimaryKey(MultimallFeedback record);

    int logicalDeleteByExample(@Param("example") MultimallFeedbackExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}