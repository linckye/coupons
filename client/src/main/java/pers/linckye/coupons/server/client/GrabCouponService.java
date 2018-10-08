package pers.linckye.coupons.server.client;

import pers.linckye.coupons.server.client.models.AddGrabCouponRequest;
import pers.linckye.coupons.server.client.models.AddGrabCouponResponse;
import pers.linckye.coupons.server.client.models.Response;

/**
 * 抢券服务.
 *
 * @author linckye 2018-10-08
 */
public interface GrabCouponService {

    Response<AddGrabCouponResponse> add(AddGrabCouponRequest addGrabCouponRequest);

}
