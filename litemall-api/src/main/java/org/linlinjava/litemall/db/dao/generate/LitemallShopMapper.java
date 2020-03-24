package org.linlinjava.litemall.db.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.generate.LitemallShop;
import org.linlinjava.litemall.db.domain.generate.LitemallShopExample;

public interface LitemallShopMapper {
    long countByExample(LitemallShopExample example);

    int deleteByExample(LitemallShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallShop record);

    int insertSelective(LitemallShop record);

    LitemallShop selectOneByExample(LitemallShopExample example);

    LitemallShop selectOneByExampleSelective(@Param("example") LitemallShopExample example, @Param("selective") LitemallShop.Column ... selective);

    List<LitemallShop> selectByExampleSelective(@Param("example") LitemallShopExample example, @Param("selective") LitemallShop.Column ... selective);

    List<LitemallShop> selectByExample(LitemallShopExample example);

    LitemallShop selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallShop.Column ... selective);

    LitemallShop selectByPrimaryKey(Integer id);

    LitemallShop selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallShop record, @Param("example") LitemallShopExample example);

    int updateByExample(@Param("record") LitemallShop record, @Param("example") LitemallShopExample example);

    int updateByPrimaryKeySelective(LitemallShop record);

    int updateByPrimaryKey(LitemallShop record);

    int logicalDeleteByExample(@Param("example") LitemallShopExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}