package com.lcwork.multishop.db.dao.generate;

import com.lcwork.multishop.db.domain.generate.LitemallComment;
import com.lcwork.multishop.db.domain.generate.LitemallCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallCommentMapper {
    long countByExample(LitemallCommentExample example);

    int deleteByExample(LitemallCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallComment record);

    int insertSelective(LitemallComment record);

    LitemallComment selectOneByExample(LitemallCommentExample example);

    LitemallComment selectOneByExampleSelective(@Param("example") LitemallCommentExample example, @Param("selective") LitemallComment.Column... selective);

    List<LitemallComment> selectByExampleSelective(@Param("example") LitemallCommentExample example, @Param("selective") LitemallComment.Column... selective);

    List<LitemallComment> selectByExample(LitemallCommentExample example);

    LitemallComment selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallComment.Column... selective);

    LitemallComment selectByPrimaryKey(Integer id);

    LitemallComment selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallComment record, @Param("example") LitemallCommentExample example);

    int updateByExample(@Param("record") LitemallComment record, @Param("example") LitemallCommentExample example);

    int updateByPrimaryKeySelective(LitemallComment record);

    int updateByPrimaryKey(LitemallComment record);

    int logicalDeleteByExample(@Param("example") LitemallCommentExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
