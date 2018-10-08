package pers.linckye.coupons.server.client.models;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author linckye 2018-10-08
 */
@Data
@Accessors(chain = true)
public class AddGrabCouponResponse
        implements Serializable {

    private static final long serialVersionUID = -8761932460310752150L;

    private GrabCouponDescription grabCouponDescription;

}
