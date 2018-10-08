package pers.linckye.coupons.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.linckye.coupons.server.client.GrabCouponService;
import pers.linckye.coupons.server.client.models.AddGrabCouponRequest;
import pers.linckye.coupons.server.client.models.AddGrabCouponResponse;
import pers.linckye.coupons.server.client.models.Response;

/**
 * @author linckye 2018-10-08
 */
@RestController
@RequestMapping("/grab-coupons")
public class GrabCouponController {

    @Autowired
    private GrabCouponService grabCouponService;

    @PostMapping
    @ResponseBody
    public Response<AddGrabCouponResponse> getCoupon(
            @RequestBody AddGrabCouponRequest addGrabCouponRequest) {
        return grabCouponService.add(addGrabCouponRequest);
    }

}
