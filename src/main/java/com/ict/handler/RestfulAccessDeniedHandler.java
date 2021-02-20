package com.ict.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 访问没有授权时的处理器
 * @Author wangsr
 * @Date 2021/2/19
 * @Version 1.0
 */
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(200);
        response.getWriter().println("您当前访问未授权");//这里返回一个字符串，可以吧一个对象序列化之后再返回。
        response.getWriter().flush();
    }
}