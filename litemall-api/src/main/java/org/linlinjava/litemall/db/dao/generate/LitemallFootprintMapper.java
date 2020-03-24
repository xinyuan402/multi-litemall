package org.linlinjava.litemall.db.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.generate.LitemallFootprint;
import org.linlinjava.litemall.db.domain.generate.LitemallFootprintExample;

public interface LitemallFootprintMapper {
    long countByExample(LitemallFootprintExample example);

    int deleteByExample(LitemallFootprintExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallFootprint record);

    int insertSelective(LitemallFootprint record);

    LitemallFootprint selectOneByExample(LitemallFootprintExample example);

    LitemallFootprint selectOneByExampleSelective(@Param("example") LitemallFootprintExample example, @Param("selective") LitemallFootprint.Column ... selective);

    List<LitemallFootprint> selectByExampleSelective(@Param("example") LitemallFootprintExample example, @Param("selective") LitemallFootprint.Column ... selective);

    List<LitemallFootprint> selectByExample(LitemallFootprintExample example);

    LitemallFootprint selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallFootprint.Column ... selective);

    LitemallFootprint selectByPrimaryKey(Integer id);

    LitemallFootprint selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallFootprint record, @Param("example") LitemallFootprintExample example);

    int updateByExample(@Param("record") LitemallFootprint record, @Param("example") LitemallFootprintExample example);

    int updateByPrimaryKeySelective(LitemallFootprint record);

    int updateByPrimaryKey(LitemallFootprint record);

    int logicalDeleteByExample(@Param("example") LitemallFootprintExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}