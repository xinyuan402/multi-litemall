package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallComment;
import com.lcwork.multimall.db.domain.generate.MultimallCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallCommentMapper {
    long countByExample(MultimallCommentExample example);

    int deleteByExample(MultimallCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallComment record);

    int insertSelective(MultimallComment record);

    MultimallComment selectOneByExample(MultimallCommentExample example);

    MultimallComment selectOneByExampleSelective(@Param("example") MultimallCommentExample example, @Param("selective") MultimallComment.Column ... selective);

    List<MultimallComment> selectByExampleSelective(@Param("example") MultimallCommentExample example, @Param("selective") MultimallComment.Column ... selective);

    List<MultimallComment> selectByExample(MultimallCommentExample example);

    MultimallComment selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallComment.Column ... selective);

    MultimallComment selectByPrimaryKey(Integer id);

    MultimallComment selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallComment record, @Param("example") MultimallCommentExample example);

    int updateByExample(@Param("record") MultimallComment record, @Param("example") MultimallCommentExample example);

    int updateByPrimaryKeySelective(MultimallComment record);

    int updateByPrimaryKey(MultimallComment record);

    int logicalDeleteByExample(@Param("example") MultimallCommentExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}