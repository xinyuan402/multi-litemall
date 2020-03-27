package com.lcwork.multishop.db.dao.generate;

import com.lcwork.multishop.db.domain.generate.LitemallCategory;
import com.lcwork.multishop.db.domain.generate.LitemallCategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallCategoryMapper {
    long countByExample(LitemallCategoryExample example);

    int deleteByExample(LitemallCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallCategory record);

    int insertSelective(LitemallCategory record);

    LitemallCategory selectOneByExample(LitemallCategoryExample example);

    LitemallCategory selectOneByExampleSelective(@Param("example") LitemallCategoryExample example, @Param("selective") LitemallCategory.Column... selective);

    List<LitemallCategory> selectByExampleSelective(@Param("example") LitemallCategoryExample example, @Param("selective") LitemallCategory.Column... selective);

    List<LitemallCategory> selectByExample(LitemallCategoryExample example);

    LitemallCategory selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallCategory.Column... selective);

    LitemallCategory selectByPrimaryKey(Integer id);

    LitemallCategory selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallCategory record, @Param("example") LitemallCategoryExample example);

    int updateByExample(@Param("record") LitemallCategory record, @Param("example") LitemallCategoryExample example);

    int updateByPrimaryKeySelective(LitemallCategory record);

    int updateByPrimaryKey(LitemallCategory record);

    int logicalDeleteByExample(@Param("example") LitemallCategoryExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
