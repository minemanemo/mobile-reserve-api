package com.smilegatemegaport.mobilereserveapi.service;

import com.smilegatemegaport.mobilereserveapi.domain.entity.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CouponService {
    Coupon issueCoupon(String phoneNumber);

    Page<Coupon> getCoupons(Pageable pageable);
}
