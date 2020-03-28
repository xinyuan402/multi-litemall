package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallCategory;
import com.lcwork.multimall.db.domain.generate.MultimallCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallCategoryMapper {
    long countByExample(MultimallCategoryExample example);

    int deleteByExample(MultimallCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallCategory record);

    int insertSelective(MultimallCategory record);

    MultimallCategory selectOneByExample(MultimallCategoryExample example);

    MultimallCategory selectOneByExampleSelective(@Param("example") MultimallCategoryExample example, @Param("selective") MultimallCategory.Column ... selective);

    List<MultimallCategory> selectByExampleSelective(@Param("example") MultimallCategoryExample example, @Param("selective") MultimallCategory.Column ... selective);

    List<MultimallCategory> selectByExample(MultimallCategoryExample example);

    MultimallCategory selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallCategory.Column ... selective);

    MultimallCategory selectByPrimaryKey(Integer id);

    MultimallCategory selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallCategory record, @Param("example") MultimallCategoryExample example);

    int updateByExample(@Param("record") MultimallCategory record, @Param("example") MultimallCategoryExample example);

    int updateByPrimaryKeySelective(MultimallCategory record);

    int updateByPrimaryKey(MultimallCategory record);

    int logicalDeleteByExample(@Param("example") MultimallCategoryExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}