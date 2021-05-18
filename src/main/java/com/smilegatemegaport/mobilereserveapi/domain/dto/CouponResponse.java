package com.smilegatemegaport.mobilereserveapi.domain.dto;

import com.smilegatemegaport.mobilereserveapi.domain.entity.Coupon;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CouponResponse {
    private String message;
    private Long sequence;
    private String phoneNumber;
    private String couponNumber;
    private LocalDateTime createDate;
}
