package com.smilegatemegaport.mobilereserveapi.controller;

import com.smilegatemegaport.mobilereserveapi.domain.dto.CouponRequest;
import com.smilegatemegaport.mobilereserveapi.domain.dto.CouponResponse;
import com.smilegatemegaport.mobilereserveapi.domain.entity.Coupon;
import com.smilegatemegaport.mobilereserveapi.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/coupon")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CouponResponse> postCoupon(@RequestBody CouponRequest couponRequest) {
        Coupon coupon = couponService.issueCoupon(couponRequest.getPhoneNumber());
        return ResponseEntity.status(HttpStatus.OK)
                .body(CouponResponse.builder()
                        .couponNumber(coupon.getCouponNumber())
                        .createDate(coupon.getCreateDate())
                        .build()
                );
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Coupon getCoupons(Pageable pageable) {
        Coupon coupon = new Coupon();
        return coupon;
    }

}
