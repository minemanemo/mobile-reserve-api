package com.smilegatemegaport.mobilereserveapi.service;


import com.smilegatemegaport.mobilereserveapi.domain.CouponRepository;
import com.smilegatemegaport.mobilereserveapi.domain.entity.Coupon;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class CouponServiceTest {

    @Autowired
    CouponRepository couponRepository;

    @Autowired
    CouponService couponService;

    @Test
    void 쿠폰_발급_테스트() {
        // given
        String phoneNumber = "01098765432";

        // when
        Coupon coupon = couponService.issueCoupon(phoneNumber);

        // then
        Assertions.assertThat(coupon.getCouponNumber().length()).isEqualTo(14);
        Assertions.assertThat(coupon.getPhoneNumber()).isEqualTo(phoneNumber);
    }

    @Test
    void 쿠폰_조회_테스트() {
        // given
        String phoneNumber = "01098765432";

        // when
        couponService.issueCoupon(phoneNumber);
        Coupon coupon = couponService.getCoupon(phoneNumber);

        // then
        Assertions.assertThat(coupon.getPhoneNumber()).isEqualTo(phoneNumber);
    }

    @Test
    void 쿠폰_리스트_조회_테스트() {
        // given
        List<Coupon> prev = couponService.getCoupons();
        String phoneNumber = "01011111111";

        // when
        couponService.issueCoupon(phoneNumber);
        List<Coupon> next = couponService.getCoupons();

        // then
        Assertions.assertThat(prev.size() + 1).isEqualTo(next.size());
    }

}
