package org.linlinjava.litemall.db.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.generate.LitemallCouponUser;
import org.linlinjava.litemall.db.domain.generate.LitemallCouponUserExample;

public interface LitemallCouponUserMapper {
    long countByExample(LitemallCouponUserExample example);

    int deleteByExample(LitemallCouponUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallCouponUser record);

    int insertSelective(LitemallCouponUser record);

    LitemallCouponUser selectOneByExample(LitemallCouponUserExample example);

    LitemallCouponUser selectOneByExampleSelective(@Param("example") LitemallCouponUserExample example, @Param("selective") LitemallCouponUser.Column ... selective);

    List<LitemallCouponUser> selectByExampleSelective(@Param("example") LitemallCouponUserExample example, @Param("selective") LitemallCouponUser.Column ... selective);

    List<LitemallCouponUser> selectByExample(LitemallCouponUserExample example);

    LitemallCouponUser selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallCouponUser.Column ... selective);

    LitemallCouponUser selectByPrimaryKey(Integer id);

    LitemallCouponUser selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallCouponUser record, @Param("example") LitemallCouponUserExample example);

    int updateByExample(@Param("record") LitemallCouponUser record, @Param("example") LitemallCouponUserExample example);

    int updateByPrimaryKeySelective(LitemallCouponUser record);

    int updateByPrimaryKey(LitemallCouponUser record);

    int logicalDeleteByExample(@Param("example") LitemallCouponUserExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}