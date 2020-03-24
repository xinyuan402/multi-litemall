package org.linlinjava.litemall.db.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.generate.LitemallStorage;
import org.linlinjava.litemall.db.domain.generate.LitemallStorageExample;

public interface LitemallStorageMapper {
    long countByExample(LitemallStorageExample example);

    int deleteByExample(LitemallStorageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallStorage record);

    int insertSelective(LitemallStorage record);

    LitemallStorage selectOneByExample(LitemallStorageExample example);

    LitemallStorage selectOneByExampleSelective(@Param("example") LitemallStorageExample example, @Param("selective") LitemallStorage.Column ... selective);

    List<LitemallStorage> selectByExampleSelective(@Param("example") LitemallStorageExample example, @Param("selective") LitemallStorage.Column ... selective);

    List<LitemallStorage> selectByExample(LitemallStorageExample example);

    LitemallStorage selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallStorage.Column ... selective);

    LitemallStorage selectByPrimaryKey(Integer id);

    LitemallStorage selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallStorage record, @Param("example") LitemallStorageExample example);

    int updateByExample(@Param("record") LitemallStorage record, @Param("example") LitemallStorageExample example);

    int updateByPrimaryKeySelective(LitemallStorage record);

    int updateByPrimaryKey(LitemallStorage record);

    int logicalDeleteByExample(@Param("example") LitemallStorageExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}