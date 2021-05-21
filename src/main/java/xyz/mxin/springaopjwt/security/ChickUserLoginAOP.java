package xyz.mxin.springaopjwt.security;

import cn.hutool.core.util.StrUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author 油炸君
 * @date 2021年05月20日 13:13
 */
@Aspect
@Component
public class ChickUserLoginAOP {


    @Autowired
    private JwtOperator jwtOperator;


    @Around("@annotation(xyz.mxin.springaopjwt.annotation.ChickUserLoginAnnotation)")
    public Object chickLong(ProceedingJoinPoint point) {
        try {
            point.getArgs();

            // 1.从header获取token
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
            String token = servletRequestAttributes.getRequest().getHeader("token");

            if (StrUtil.isEmptyIfStr(token)) {
                throw new SecurityException("401","TOKEN不合法");
            }
            Boolean isValida = jwtOperator.validateToken(token);
            if (!isValida) {
                throw new SecurityException("401","TOKEN不合法");
            }
            return point.proceed();
        } catch (Throwable throwable) {
            throw new SecurityException("401", "token不合法");
        }
    }










}
