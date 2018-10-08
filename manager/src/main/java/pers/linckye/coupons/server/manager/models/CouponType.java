package pers.linckye.coupons.server.manager.models;

import lombok.Getter;

import java.util.Optional;

import static pers.linckye.coupons.server.common.utils.Blank.isNull;
import static pers.linckye.coupons.server.common.utils.Blank.isNullOrEmpty;

/**
 * 优惠券种类.
 *
 * @author linckye 2018-10-08
 */
@Getter
public enum CouponType {

    /** 饿了么. **/
    ELEME("eleme")

    ;

    private String value;

    CouponType(String value) {
        this.value = value;
    }

    public static Optional<CouponType> from(String value) {
        if (isNullOrEmpty(value)) throw new IllegalArgumentException("Code is required");
        for (CouponType couponType : values()) {
            if (couponType.getValue().equals(value)) return Optional.of(couponType);
        }
        return Optional.empty();
    }

}
