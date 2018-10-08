package pers.linckye.coupons.server.client.models;

import lombok.Getter;

import static pers.linckye.coupons.server.common.utils.Blank.*;

/**
 * 响应码.
 *
 * @author linckye 2018-10-08
 */
@Getter
public enum Code {

    /** 成功. **/
    SUCCESS(0),

    /** 未考虑到的异常. **/
    UNEXPECTED_ERROR(-1),

    /** 参数非法. **/
    ILLEGAL_ARGUMENT(1),

    /** 资源未找到. **/
    RESOUCE_NOT_FOUND(2)

    ;

    private Integer value;

    Code(Integer value) {
        this.value = value;
    }

    public static Code fromValue(Integer value) {
        if (isNull(value)) throw new IllegalArgumentException("Code is required");
        for (Code code : values()) {
            if (code.getValue().equals(value)) return code;
        }
        throw new IllegalArgumentException("Unsupport code for [" + value + "]");
    }

}
