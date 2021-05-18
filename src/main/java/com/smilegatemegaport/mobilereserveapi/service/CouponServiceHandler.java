package com.smilegatemegaport.mobilereserveapi.service;

import com.smilegatemegaport.mobilereserveapi.domain.CouponRepository;
import com.smilegatemegaport.mobilereserveapi.domain.entity.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class CouponServiceHandler implements CouponService {

    private static final List<String> COMBINATION_OF_LETTERS;

    static {
        COMBINATION_OF_LETTERS = new ArrayList<>();
        IntStream.rangeClosed(0, 9)
                .boxed()
                .map(String::valueOf)
                .forEach(COMBINATION_OF_LETTERS::add);
        IntStream.rangeClosed(0, 26)
                .mapToObj(i -> ((char) (i + 'a')))
                .map(String::valueOf)
                .forEach(COMBINATION_OF_LETTERS::add);
        IntStream.rangeClosed(0, 26)
                .mapToObj(i -> ((char) (i + 'A')))
                .map(String::valueOf)
                .forEach(COMBINATION_OF_LETTERS::add);
    }

    private final CouponRepository couponRepository;

    @Override
    public Coupon issueCoupon(String phoneNumber) {
        Coupon coupon = couponRepository.findByPhoneNumber(phoneNumber);
        coupon = Coupon.builder()
                .couponNumber(generateCouponNumber())
                .phoneNumber(phoneNumber)
                .build();
        return couponRepository.save(coupon);
    }

    private String generateCouponNumber() {
        Collections.shuffle(COMBINATION_OF_LETTERS);
        String couponNumber = String.join("", COMBINATION_OF_LETTERS.subList(0, 12));
        return String.format("%s-%s-%s", couponNumber.substring(0, 4), couponNumber.substring(4, 8), couponNumber.substring(8));
    }

    @Override
    public Page<Coupon> getCoupons(Pageable pageable) {
        return null;
    }
}
