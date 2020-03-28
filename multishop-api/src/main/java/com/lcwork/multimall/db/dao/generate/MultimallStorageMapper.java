package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallStorage;
import com.lcwork.multimall.db.domain.generate.MultimallStorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallStorageMapper {
    long countByExample(MultimallStorageExample example);

    int deleteByExample(MultimallStorageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallStorage record);

    int insertSelective(MultimallStorage record);

    MultimallStorage selectOneByExample(MultimallStorageExample example);

    MultimallStorage selectOneByExampleSelective(@Param("example") MultimallStorageExample example, @Param("selective") MultimallStorage.Column ... selective);

    List<MultimallStorage> selectByExampleSelective(@Param("example") MultimallStorageExample example, @Param("selective") MultimallStorage.Column ... selective);

    List<MultimallStorage> selectByExample(MultimallStorageExample example);

    MultimallStorage selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallStorage.Column ... selective);

    MultimallStorage selectByPrimaryKey(Integer id);

    MultimallStorage selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallStorage record, @Param("example") MultimallStorageExample example);

    int updateByExample(@Param("record") MultimallStorage record, @Param("example") MultimallStorageExample example);

    int updateByPrimaryKeySelective(MultimallStorage record);

    int updateByPrimaryKey(MultimallStorage record);

    int logicalDeleteByExample(@Param("example") MultimallStorageExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}