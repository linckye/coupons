package pers.linckye.coupons.server.manager;

import pers.linckye.coupons.server.manager.models.GrabCoupon;
import pers.linckye.coupons.server.manager.models.GrabCouponArg;

/**
 * @author linckye 2018-10-08
 */
public interface GrabCouponManager {

    GrabCoupon grab(GrabCouponArg grabCouponArg);

}
