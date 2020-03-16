package com.ktz.deploy.log.aspect;

import com.ktz.deploy.log.annotation.LogAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassNameLogAspect
 * @Description
 * @Author kaituozhesh
 * @Date2020/3/16 10:00
 * @Version V1.0
 **/
@Slf4j
@Aspect
@Component
public class LogAspect {


    @Pointcut("@annotation(com.ktz.deploy.log.annotation.LogAnnotation)")
    public void logPointcut() {

    }

    @AfterReturning(value = "logPointcut()")
    public void doAfterReturning(JoinPoint point) {
        Object[] args = point.getArgs();
        MethodSignature sign = (MethodSignature) point.getSignature();
        Method method = sign.getMethod();
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        String moduleCode = annotation.moduleCode();
        String param = (String) args[0];
        log.info("操作模块{}  参数为{}", moduleCode, param);
    }
}
