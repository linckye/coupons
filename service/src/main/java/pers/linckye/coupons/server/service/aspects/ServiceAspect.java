package pers.linckye.coupons.server.service.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import pers.linckye.coupons.server.client.models.Code;
import pers.linckye.coupons.server.client.models.Response;

import static pers.linckye.coupons.server.common.utils.Blank.containsNullOrNoneElements;

/**
 * @author linckye 2018-08-15
 */
@Aspect
@Slf4j
@Component
public class ServiceAspect {

    @Pointcut("execution(* pers.linckye.coupons.server.service.*Service*.*(..))")
    private void serverPointCut() {}

    @Around("ServiceAspect.serverPointCut()")
    @SuppressWarnings("unchecked")
    public Object handlerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
        // check args
        if (containsNullOrNoneElements(proceedingJoinPoint.getArgs()))
            return ((Class<? extends Response>) ((MethodSignature) proceedingJoinPoint.getSignature()).getReturnType())
                    .newInstance()
                    .setCode(Code.ILLEGAL_ARGUMENT.getValue())
                    .setMessage("Request parameter is required");

        // handle throwable
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable t) {
            log.error("Unexpected error method={} args={}",
                    proceedingJoinPoint.getSignature(),
                    proceedingJoinPoint.getArgs(),
                    t
            );
            return ((Class<? extends Response>) ((MethodSignature) proceedingJoinPoint.getSignature()).getReturnType())
                    .newInstance()
                    .setCode(Code.UNEXPECTED_ERROR.getValue())
                    .setMessage(t.getMessage());
        }
    }

}
