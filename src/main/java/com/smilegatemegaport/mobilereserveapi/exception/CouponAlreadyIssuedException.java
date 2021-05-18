package com.smilegatemegaport.mobilereserveapi.exception;

import com.smilegatemegaport.mobilereserveapi.domain.dto.CouponResponse;
import com.smilegatemegaport.mobilereserveapi.domain.entity.Coupon;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public class CouponAlreadyIssuedException extends CouponException {

    @Getter
    private final Coupon coupon;

    protected CouponAlreadyIssuedException(Coupon coupon) {
        super(HttpStatus.CONFLICT);
        this.coupon = coupon;
    }

    public static CouponAlreadyIssuedException thrown(Coupon coupon) {
        return new CouponAlreadyIssuedException(coupon);
    }

    @Override
    public CouponResponse toCouponResponse() {
        return CouponResponse.builder()
                .message("Coupon Already Issued...")
                .data(coupon)
                .build();
    }
}
