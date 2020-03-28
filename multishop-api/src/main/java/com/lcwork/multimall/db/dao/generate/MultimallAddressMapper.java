package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallAddress;
import com.lcwork.multimall.db.domain.generate.MultimallAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallAddressMapper {
    long countByExample(MultimallAddressExample example);

    int deleteByExample(MultimallAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallAddress record);

    int insertSelective(MultimallAddress record);

    MultimallAddress selectOneByExample(MultimallAddressExample example);

    MultimallAddress selectOneByExampleSelective(@Param("example") MultimallAddressExample example, @Param("selective") MultimallAddress.Column ... selective);

    List<MultimallAddress> selectByExampleSelective(@Param("example") MultimallAddressExample example, @Param("selective") MultimallAddress.Column ... selective);

    List<MultimallAddress> selectByExample(MultimallAddressExample example);

    MultimallAddress selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallAddress.Column ... selective);

    MultimallAddress selectByPrimaryKey(Integer id);

    MultimallAddress selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallAddress record, @Param("example") MultimallAddressExample example);

    int updateByExample(@Param("record") MultimallAddress record, @Param("example") MultimallAddressExample example);

    int updateByPrimaryKeySelective(MultimallAddress record);

    int updateByPrimaryKey(MultimallAddress record);

    int logicalDeleteByExample(@Param("example") MultimallAddressExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}