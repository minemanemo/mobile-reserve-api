package com.smilegatemegaport.mobilereserveapi.domain;

import com.smilegatemegaport.mobilereserveapi.domain.entity.Coupon;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends PagingAndSortingRepository<Coupon, String> {
    Coupon findByPhoneNumber(String phoneNumber);
}
