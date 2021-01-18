package com.bglemon.blue.taste.config;

import com.bglemon.blue.taste.domain.OperationLog;
import com.bglemon.blue.taste.service.OperationLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:zhuchuanshun
 * @Description: 定义一个 AOP 切面 进行写日志
 * @Date: 2019/4/23 15:05
 * @Modificd:
 */
@Slf4j
@Aspect
@Component
public class HttpAspect {

    @Autowired
    OperationLogService operationLogService;
    @Pointcut("execution(* com.bglemon.blue.taste.controller.api.*.*(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void beginTransaction(JoinPoint joinPoint) {
        log.info("Before [{}]", joinPoint.getSignature().getName());
    }

    @AfterReturning(returning = "ret", pointcut = "pointcut()")
    public void doAfterReturning(Object ret){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String authorization = request.getHeader("Authorization");
        try{
            // 写入日志 当只有登录时才写日志
            if (authorization != null){
                OperationLog operationLog = new OperationLog();
                operationLog.setUrl(request.getRequestURI());
                operationLog.setHttpMethod(request.getMethod());
                operationLog.setUserId(JWTUtil.getUserId(authorization));
                String containStr = ret.toString().substring(0,15);
                // 转换 有时出现异常
            /*JsonObject returnData = new JsonParser().parse(ret.toString()).getAsJsonObject();
            Integer code = Integer.parseInt(returnData.get("code").toString());*/
                if (containStr.contains("200")){
                    operationLog.setSucceed(true);
                }else{
                    operationLog.setSucceed(false);
                }
                operationLogService.insert(operationLog);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
