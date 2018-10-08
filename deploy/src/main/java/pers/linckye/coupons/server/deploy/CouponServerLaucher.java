package pers.linckye.coupons.server.deploy;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author linckye 2018-10-08
 */
@SpringBootApplication
@ComponentScan(
        "pers.linckye.coupons.server"
)
public class CouponServerLaucher {

    public static void main(String[] args) {
        new SpringApplicationBuilder(CouponServerLaucher.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

}
