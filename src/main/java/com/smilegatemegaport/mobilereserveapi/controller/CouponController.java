package com.smilegatemegaport.mobilereserveapi.controller;

import com.smilegatemegaport.mobilereserveapi.domain.dto.CouponRequest;
import com.smilegatemegaport.mobilereserveapi.domain.dto.CouponResponse;
import com.smilegatemegaport.mobilereserveapi.domain.entity.Coupon;
import com.smilegatemegaport.mobilereserveapi.exception.CouponException;
import com.smilegatemegaport.mobilereserveapi.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @PostMapping(path = "/coupon", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Coupon postCoupon(@RequestBody CouponRequest couponRequest) {
        return couponService.issueCoupon(couponRequest.getPhoneNumber());
    }

    @GetMapping(path = "/coupon/{phoneNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Coupon getCoupon(@PathVariable(name = "phoneNumber") String phoneNumber) {
        return couponService.getCoupon(phoneNumber);
    }

    @GetMapping(path = "/coupons", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> getCoupons() {
        return couponService.getCoupons();
    }


    @ExceptionHandler
    public ResponseEntity<CouponResponse> handleException(CouponException e) {
        return ResponseEntity.status(e.getStatusCode()).body(e.toCouponResponse());
    }

}
