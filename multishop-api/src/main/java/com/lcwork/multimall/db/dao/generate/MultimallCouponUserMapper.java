package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallCouponUser;
import com.lcwork.multimall.db.domain.generate.MultimallCouponUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallCouponUserMapper {
    long countByExample(MultimallCouponUserExample example);

    int deleteByExample(MultimallCouponUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallCouponUser record);

    int insertSelective(MultimallCouponUser record);

    MultimallCouponUser selectOneByExample(MultimallCouponUserExample example);

    MultimallCouponUser selectOneByExampleSelective(@Param("example") MultimallCouponUserExample example, @Param("selective") MultimallCouponUser.Column ... selective);

    List<MultimallCouponUser> selectByExampleSelective(@Param("example") MultimallCouponUserExample example, @Param("selective") MultimallCouponUser.Column ... selective);

    List<MultimallCouponUser> selectByExample(MultimallCouponUserExample example);

    MultimallCouponUser selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallCouponUser.Column ... selective);

    MultimallCouponUser selectByPrimaryKey(Integer id);

    MultimallCouponUser selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallCouponUser record, @Param("example") MultimallCouponUserExample example);

    int updateByExample(@Param("record") MultimallCouponUser record, @Param("example") MultimallCouponUserExample example);

    int updateByPrimaryKeySelective(MultimallCouponUser record);

    int updateByPrimaryKey(MultimallCouponUser record);

    int logicalDeleteByExample(@Param("example") MultimallCouponUserExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}