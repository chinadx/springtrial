package cn.goodman.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by Shaun on 2017/1/19.
 */
@Aspect
@Component
public class ControllerLoggingAOP {
    private Log logger = LogFactory.getLog(ControllerLoggingAOP.class);

    /**
     * 定义一个切点
     */
    @Pointcut("execution(* cn.goodman.business.**.controller.*.*(..))")
    public void point(){}

    /**
     * 进入之前的切片方法
     * 打印请求头信息
     * @param joinPoint
     */
    @Before("point()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("====controller method begin...");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("REFERER : " + request.getHeader("Referer"));
        logger.info("METHOD : " + request.getMethod().toString());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 结束之后的切片
     */
    @After("point()")
    public void doAfterReturning() {
        logger.info("====controller method end...");
    }
}
