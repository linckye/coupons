package pers.linckye.coupons.server.web.aop;

import com.google.common.base.Charsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import pers.linckye.coupons.server.client.models.Response;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

import static pers.linckye.coupons.server.client.models.Code.*;

/**
 * @author linckye 2018-10-08
 */
@ControllerAdvice
@Slf4j
public class ControllerErrorHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response handleErrors(HttpServletRequest request, Exception e) {
        log.error("Unexpected error uri={} method={} ",
            request.getRequestURI(),
            request.getMethod()
        );
        return new Response()
                .setCode(UNEXPECTED_ERROR.getValue())
                .setMessage(e.getMessage());
    }

}
