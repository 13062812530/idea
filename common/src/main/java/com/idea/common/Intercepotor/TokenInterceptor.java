package com.idea.common.Intercepotor;

import com.alibaba.fastjson.JSON;
import com.idea.common.enums.TokenStatus;
import com.idea.common.util.RedisUtil;
import com.idea.common.vo.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //非映射方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        //判断接口是否需要验证Token
        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        NotCheckTokenAnn annotation = method.getAnnotation(NotCheckTokenAnn.class);
        //有 @NotCheckTokenAnn注解的不需验证Token
        if(null != annotation){
            return true;
        }
        String token = request.getParameter("token");
        if(null ==token){
            token=request.getHeader("token");
        }
        //验证token是否有效
        if(StringUtils.isBlank(token) || !RedisUtil.hasKey("token/"+token)){
            BaseResult br = new BaseResult();
            br.setCode(TokenStatus.overdue.getCode());
            br.setSuccess(false);
            br.setErrorMsg("Token已过期,请重新登录");
            String result = JSON.toJSONString(br);
            response.getWriter().print(result);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
