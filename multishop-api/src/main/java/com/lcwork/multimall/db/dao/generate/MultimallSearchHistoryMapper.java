package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallSearchHistory;
import com.lcwork.multimall.db.domain.generate.MultimallSearchHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallSearchHistoryMapper {
    long countByExample(MultimallSearchHistoryExample example);

    int deleteByExample(MultimallSearchHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallSearchHistory record);

    int insertSelective(MultimallSearchHistory record);

    MultimallSearchHistory selectOneByExample(MultimallSearchHistoryExample example);

    MultimallSearchHistory selectOneByExampleSelective(@Param("example") MultimallSearchHistoryExample example, @Param("selective") MultimallSearchHistory.Column ... selective);

    List<MultimallSearchHistory> selectByExampleSelective(@Param("example") MultimallSearchHistoryExample example, @Param("selective") MultimallSearchHistory.Column ... selective);

    List<MultimallSearchHistory> selectByExample(MultimallSearchHistoryExample example);

    MultimallSearchHistory selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallSearchHistory.Column ... selective);

    MultimallSearchHistory selectByPrimaryKey(Integer id);

    MultimallSearchHistory selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallSearchHistory record, @Param("example") MultimallSearchHistoryExample example);

    int updateByExample(@Param("record") MultimallSearchHistory record, @Param("example") MultimallSearchHistoryExample example);

    int updateByPrimaryKeySelective(MultimallSearchHistory record);

    int updateByPrimaryKey(MultimallSearchHistory record);

    int logicalDeleteByExample(@Param("example") MultimallSearchHistoryExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}