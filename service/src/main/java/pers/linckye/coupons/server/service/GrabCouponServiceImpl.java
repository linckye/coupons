package pers.linckye.coupons.server.service;

import com.google.common.base.Converter;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.linckye.coupons.server.client.GrabCouponService;
import pers.linckye.coupons.server.client.models.AddGrabCouponRequest;
import pers.linckye.coupons.server.client.models.AddGrabCouponResponse;
import pers.linckye.coupons.server.client.models.GrabCouponDescription;
import pers.linckye.coupons.server.manager.models.CouponType;
import pers.linckye.coupons.server.client.models.Response;
import pers.linckye.coupons.server.manager.GrabCouponManager;
import pers.linckye.coupons.server.manager.models.GrabCoupon;
import pers.linckye.coupons.server.manager.models.GrabCouponArg;

import java.util.Map;
import java.util.Optional;

import static pers.linckye.coupons.server.common.utils.Blank.*;
import static pers.linckye.coupons.server.client.models.Code.*;
import static pers.linckye.coupons.server.manager.models.CouponType.*;

/**
 * @author linckye 2018-10-08
 */
@Service
@Slf4j
public class GrabCouponServiceImpl
        implements GrabCouponService {

    @Autowired
    private GrabCouponManager grabCouponManager;

    @Autowired
    private Converter<GrabCouponDescription, GrabCoupon> grabCouponConverter;

    @Override
    public Response<AddGrabCouponResponse> add(AddGrabCouponRequest addGrabCouponRequest) {
        String couponTypeString = addGrabCouponRequest.getCouponType();
        // check args
        if (isNull(couponTypeString)) new Response<AddGrabCouponResponse>()
                .setCode(ILLEGAL_ARGUMENT.getValue())
                .setMessage("Coupon type is required");
        CouponType couponType = fromNullableValue(couponTypeString);
        if (isNull(couponType)) return new Response<AddGrabCouponResponse>()
                .setCode(ILLEGAL_ARGUMENT.getValue())
                .setMessage("Unsupport coupon type for [" + couponTypeString + "]");

        GrabCoupon grabCoupon = grabCouponManager.grab(new GrabCouponArg().setCouponType(couponType));

        return Response.<AddGrabCouponResponse>success()
                .setData(new AddGrabCouponResponse().setGrabCouponDescription(
                        grabCouponConverter.reverse().convert(grabCoupon))
                );

    }

}
