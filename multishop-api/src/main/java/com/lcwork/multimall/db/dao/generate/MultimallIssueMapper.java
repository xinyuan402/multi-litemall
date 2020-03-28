package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallIssue;
import com.lcwork.multimall.db.domain.generate.MultimallIssueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallIssueMapper {
    long countByExample(MultimallIssueExample example);

    int deleteByExample(MultimallIssueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallIssue record);

    int insertSelective(MultimallIssue record);

    MultimallIssue selectOneByExample(MultimallIssueExample example);

    MultimallIssue selectOneByExampleSelective(@Param("example") MultimallIssueExample example, @Param("selective") MultimallIssue.Column ... selective);

    List<MultimallIssue> selectByExampleSelective(@Param("example") MultimallIssueExample example, @Param("selective") MultimallIssue.Column ... selective);

    List<MultimallIssue> selectByExample(MultimallIssueExample example);

    MultimallIssue selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallIssue.Column ... selective);

    MultimallIssue selectByPrimaryKey(Integer id);

    MultimallIssue selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallIssue record, @Param("example") MultimallIssueExample example);

    int updateByExample(@Param("record") MultimallIssue record, @Param("example") MultimallIssueExample example);

    int updateByPrimaryKeySelective(MultimallIssue record);

    int updateByPrimaryKey(MultimallIssue record);

    int logicalDeleteByExample(@Param("example") MultimallIssueExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}