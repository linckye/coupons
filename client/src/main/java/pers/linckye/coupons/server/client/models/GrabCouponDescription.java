package pers.linckye.coupons.server.client.models;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 抢券情况.
 *
 * @author linckye 2018-10-08
 */
@Data
@Accessors(chain = true)
public class GrabCouponDescription {

    /** 是否成功. **/
    private Boolean success;

}
