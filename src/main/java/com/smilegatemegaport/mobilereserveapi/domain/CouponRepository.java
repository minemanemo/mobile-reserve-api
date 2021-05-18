package com.smilegatemegaport.mobilereserveapi.domain;

import com.smilegatemegaport.mobilereserveapi.domain.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, String> {
    Coupon findByPhoneNumber(String phoneNumber);
}


