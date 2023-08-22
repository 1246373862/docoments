package com.document.common.aspect;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ControllerAspect {


    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    @Pointcut("execution(* com.document.controller.*.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();//开始时间
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String[] paramNames = signature.getParameterNames();
        Object[] objArr = joinPoint.getArgs();
        JSONObject obj = new JSONObject();
        for (int i = 0; i < paramNames.length; i++) {
            if (objArr[i] instanceof ServletResponse || objArr[i] instanceof ServletRequest || objArr[i] instanceof MultipartFile || objArr[i] instanceof MultipartFile[]) {

            } else {
                obj.put(paramNames[i], objArr[i]);
            }
        }
        logger.info("请求{}的参数:{}", request.getRequestURI(), obj.isEmpty() ? "" : obj.toJSONString());
        Object res = joinPoint.proceed();
        long endTime = System.currentTimeMillis();//结束时间
        logger.info("请求{}耗时{}毫秒", request.getRequestURI(), (endTime - startTime));
        return res;
    }
}
