package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallAd;
import com.lcwork.multimall.db.domain.generate.MultimallAdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallAdMapper {
    long countByExample(MultimallAdExample example);

    int deleteByExample(MultimallAdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallAd record);

    int insertSelective(MultimallAd record);

    MultimallAd selectOneByExample(MultimallAdExample example);

    MultimallAd selectOneByExampleSelective(@Param("example") MultimallAdExample example, @Param("selective") MultimallAd.Column ... selective);

    List<MultimallAd> selectByExampleSelective(@Param("example") MultimallAdExample example, @Param("selective") MultimallAd.Column ... selective);

    List<MultimallAd> selectByExample(MultimallAdExample example);

    MultimallAd selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallAd.Column ... selective);

    MultimallAd selectByPrimaryKey(Integer id);

    MultimallAd selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallAd record, @Param("example") MultimallAdExample example);

    int updateByExample(@Param("record") MultimallAd record, @Param("example") MultimallAdExample example);

    int updateByPrimaryKeySelective(MultimallAd record);

    int updateByPrimaryKey(MultimallAd record);

    int logicalDeleteByExample(@Param("example") MultimallAdExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}