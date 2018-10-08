package pers.linckye.coupons.server.manager.models;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author linckye 2018-10-08
 */
@Data
@Accessors(chain = true)
public class GrabCoupon {

    /** 备注. **/
    private String marks;

    /** 抢券是否成功. **/
    private Boolean success;

}
