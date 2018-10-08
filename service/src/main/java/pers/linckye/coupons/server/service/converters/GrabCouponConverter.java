package pers.linckye.coupons.server.service.converters;

import com.google.common.base.Converter;
import org.springframework.stereotype.Component;
import pers.linckye.coupons.server.client.models.GrabCouponDescription;
import pers.linckye.coupons.server.manager.models.GrabCoupon;

/**
 * @author linckye 2018-10-08
 */
@Component
public class GrabCouponConverter extends Converter<GrabCouponDescription, GrabCoupon> {
    @Override
    protected GrabCoupon doForward(GrabCouponDescription grabCouponDescription) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected GrabCouponDescription doBackward(GrabCoupon grabCoupon) {
        return new GrabCouponDescription();
    }
}
