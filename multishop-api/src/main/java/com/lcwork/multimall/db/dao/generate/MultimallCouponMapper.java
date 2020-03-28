package com.lcwork.multimall.db.dao.generate;

import com.lcwork.multimall.db.domain.generate.MultimallCoupon;
import com.lcwork.multimall.db.domain.generate.MultimallCouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MultimallCouponMapper {
    long countByExample(MultimallCouponExample example);

    int deleteByExample(MultimallCouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultimallCoupon record);

    int insertSelective(MultimallCoupon record);

    MultimallCoupon selectOneByExample(MultimallCouponExample example);

    MultimallCoupon selectOneByExampleSelective(@Param("example") MultimallCouponExample example, @Param("selective") MultimallCoupon.Column ... selective);

    List<MultimallCoupon> selectByExampleSelective(@Param("example") MultimallCouponExample example, @Param("selective") MultimallCoupon.Column ... selective);

    List<MultimallCoupon> selectByExample(MultimallCouponExample example);

    MultimallCoupon selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MultimallCoupon.Column ... selective);

    MultimallCoupon selectByPrimaryKey(Integer id);

    MultimallCoupon selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MultimallCoupon record, @Param("example") MultimallCouponExample example);

    int updateByExample(@Param("record") MultimallCoupon record, @Param("example") MultimallCouponExample example);

    int updateByPrimaryKeySelective(MultimallCoupon record);

    int updateByPrimaryKey(MultimallCoupon record);

    int logicalDeleteByExample(@Param("example") MultimallCouponExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}