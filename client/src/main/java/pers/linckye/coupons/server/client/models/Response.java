package pers.linckye.coupons.server.client.models;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

import static pers.linckye.coupons.server.client.models.Code.*;

/**
 * @author linckye 2018-10-08
 */
@Data
@Accessors(chain = true)
public class Response<D>
        implements Serializable {

    private static final long serialVersionUID = -3925566721295100650L;

    private D data;

    private String message;

    private Integer code;

    public static <D> Response<D> success() {
        Response<D> response = new Response<>();
        response.code = SUCCESS.getValue();
        response.message = "Success";
        return response;
    }

}
