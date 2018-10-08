package pers.linckye.coupons.server.manager.models;

import lombok.Getter;

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

    public static CouponType fromValue(String value) {
        CouponType couponType = fromNullableValue(value);
        if (!isNull(couponType)) return couponType;
        throw new IllegalArgumentException("Unsupport coupon type for [" + value + "]");
    }

    public static CouponType fromNullableValue(String value) {
        if (isNullOrEmpty(value)) throw new IllegalArgumentException("Code is required");
        for (CouponType couponType : values()) {
            if (couponType.getValue().equals(value)) return couponType;
        }
        return null;
    }

}
