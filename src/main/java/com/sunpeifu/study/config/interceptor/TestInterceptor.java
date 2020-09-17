package com.sunpeifu.study.config.interceptor;

import com.sunpeifu.study.config.interceptor.annotation.IgnoreCheck;
import com.sunpeifu.study.config.interceptor.annotation.MustCheck;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 作者:  daike
 * 日期:  2020/9/17
 * 描述:
 */
public class TestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1 HandlerMethod即为Spring MVC中  RequestMapping url映射包装的执行器
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 2 获取method上的注解
        Method method = handlerMethod.getMethod();
        // 3 此处可以是自定义注解,标注了自定义注解的方法可以进行某些验证或者放行
        IgnoreCheck ignoreCheckAnnotation = method.getAnnotation(IgnoreCheck.class);
        if (null != ignoreCheckAnnotation) {
            // 直接放行
            return true;
        }
        // 4 必须进行检查
        MustCheck mustCheck = method.getAnnotation(MustCheck.class);
        if (null != mustCheck) {
            // 进行相关操作,根据结果决定是否放行
            boolean flag = false;
            if (flag) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }
}
