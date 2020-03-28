package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallShop;
import com.lcwork.multimall.db.domain.generate.MultimallShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallShopMapper {
    long countByExample(MultimallShopExample example);

    int deleteByExample(MultimallShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallShop record);

    int insertSelective(MultimallShop record);

    MultimallShop selectOneByExample(MultimallShopExample example);

    MultimallShop selectOneByExampleSelective(@Param("example") MultimallShopExample example, @Param("selective") MultimallShop.Column ... selective);

    List<MultimallShop> selectByExampleSelective(@Param("example") MultimallShopExample example, @Param("selective") MultimallShop.Column ... selective);

    List<MultimallShop> selectByExample(MultimallShopExample example);

    MultimallShop selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallShop.Column ... selective);

    MultimallShop selectByPrimaryKey(Integer id);

    MultimallShop selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallShop record, @Param("example") MultimallShopExample example);

    int updateByExample(@Param("record") MultimallShop record, @Param("example") MultimallShopExample example);

    int updateByPrimaryKeySelective(MultimallShop record);

    int updateByPrimaryKey(MultimallShop record);

    int logicalDeleteByExample(@Param("example") MultimallShopExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}