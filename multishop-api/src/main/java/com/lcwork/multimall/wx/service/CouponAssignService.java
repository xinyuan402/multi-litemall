package com.lcwork.multimall.wx.service;

import com.lcwork.multimall.db.domain.generate.MultimallCoupon;
import com.lcwork.multimall.db.domain.generate.MultimallCouponUser;
import com.lcwork.multimall.db.service.MultimallCouponService;
import com.lcwork.multimall.db.service.MultimallCouponUserService;
import com.lcwork.multimall.db.util.CouponConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CouponAssignService {

    @Autowired
    private MultimallCouponUserService couponUserService;
    @Autowired
    private MultimallCouponService couponService;

    /**
     * 分发注册优惠券
     *
     * @param userId
     * @return
     */
    public void assignForRegister(Integer userId) {
        List<MultimallCoupon> couponList = couponService.queryRegister();
        for (MultimallCoupon coupon : couponList) {
            Integer couponId = coupon.getId();

            Integer count = couponUserService.countUserAndCoupon(userId, couponId);
            if (count > 0) {
                continue;
            }

            Short limit = coupon.getLimit();
            while (limit > 0) {
                MultimallCouponUser couponUser = new MultimallCouponUser();
                couponUser.setCouponId(couponId);
                couponUser.setUserId(userId);
                Short timeType = coupon.getTimeType();
                if (timeType.equals(CouponConstant.TIME_TYPE_TIME)) {
                    couponUser.setStartTime(coupon.getStartTime());
                    couponUser.setEndTime(coupon.getEndTime());
                } else {
                    LocalDateTime now = LocalDateTime.now();
                    couponUser.setStartTime(now);
                    couponUser.setEndTime(now.plusDays(coupon.getDays()));
                }
                couponUserService.add(couponUser);

                limit--;
            }
        }

    }

}
