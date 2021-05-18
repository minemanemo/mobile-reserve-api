package com.smilegatemegaport.mobilereserveapi.exception;

import com.smilegatemegaport.mobilereserveapi.domain.dto.CouponResponse;
import com.smilegatemegaport.mobilereserveapi.domain.entity.Coupon;
import org.springframework.http.HttpStatus;

public class CouponNotFoundException extends CouponException {

    protected CouponNotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }

    public static CouponNotFoundException thrown() {
        return new CouponNotFoundException();
    }

    @Override
    public CouponResponse toCouponResponse() {
        return CouponResponse.builder()
                .message("Coupon Not Found...")
                .data(null)
                .build();
    }
}
