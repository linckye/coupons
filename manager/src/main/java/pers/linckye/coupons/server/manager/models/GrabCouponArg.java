package pers.linckye.coupons.server.manager.models;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @author linckye 2018-10-08
 */
@Data
@Accessors(chain = true)
public class GrabCouponArg {

    /** 优惠券种类. **/
    private CouponType couponType;

}
