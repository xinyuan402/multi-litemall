package org.linlinjava.litemall.db.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.generate.LitemallStore;
import org.linlinjava.litemall.db.domain.generate.LitemallStoreExample;

public interface LitemallStoreMapper {
    long countByExample(LitemallStoreExample example);

    int deleteByExample(LitemallStoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallStore record);

    int insertSelective(LitemallStore record);

    LitemallStore selectOneByExample(LitemallStoreExample example);

    LitemallStore selectOneByExampleSelective(@Param("example") LitemallStoreExample example, @Param("selective") LitemallStore.Column ... selective);

    List<LitemallStore> selectByExampleSelective(@Param("example") LitemallStoreExample example, @Param("selective") LitemallStore.Column ... selective);

    List<LitemallStore> selectByExample(LitemallStoreExample example);

    LitemallStore selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallStore.Column ... selective);

    LitemallStore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LitemallStore record, @Param("example") LitemallStoreExample example);

    int updateByExample(@Param("record") LitemallStore record, @Param("example") LitemallStoreExample example);

    int updateByPrimaryKeySelective(LitemallStore record);

    int updateByPrimaryKey(LitemallStore record);
}