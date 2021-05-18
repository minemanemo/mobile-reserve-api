package com.smilegatemegaport.mobilereserveapi.service;

import com.smilegatemegaport.mobilereserveapi.domain.entity.Coupon;

import java.util.List;

public interface CouponService {
    Coupon issueCoupon(String phoneNumber);

    List<Coupon> getCoupons();
}
