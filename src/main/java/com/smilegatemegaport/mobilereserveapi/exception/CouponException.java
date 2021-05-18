package com.smilegatemegaport.mobilereserveapi.exception;

import com.smilegatemegaport.mobilereserveapi.domain.dto.CouponResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public abstract class CouponException extends HttpStatusCodeException {
    protected CouponException(HttpStatus statusCode) {
        super(statusCode);
    }

    abstract public CouponResponse toCouponResponse();
}
