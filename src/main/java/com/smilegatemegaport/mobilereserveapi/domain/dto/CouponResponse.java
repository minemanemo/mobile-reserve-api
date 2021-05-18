package com.smilegatemegaport.mobilereserveapi.domain.dto;

import com.smilegatemegaport.mobilereserveapi.domain.entity.Coupon;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CouponResponse {
    String message;
    Coupon data;
}
