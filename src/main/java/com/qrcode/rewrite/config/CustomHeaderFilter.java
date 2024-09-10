package com.qrcode.rewrite.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomHeaderFilter implements Filter {

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // 过滤器初始化代码（如果需要的话）
//    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

//        // 假设我们要检查一个名为"Custom-Header"的请求头
//        String customHeader = httpRequest.getHeader("Custom-Header");
//
//        String requestURL = httpRequest.getRequestURL().toString();
        String requestURI = httpRequest.getRequestURI();
        String webType = httpRequest.getParameter("webType");
        String expectedParam = httpRequest.getParameter("expectedParam");

        if((webType == null && expectedParam==null)
                ||  ("/".equals(requestURI) && webType == null)
                || ("/dpc/qrRedirect".equals(requestURI) && (expectedParam == null|| !"firstRewrite".equals(expectedParam)))
                || ("/dpc/qrRedirectSecond".equals(requestURI) && (expectedParam == null|| !"secondRewrite".equals(expectedParam)))
                || ("/dpc/threeRedirect".equals(requestURI) && (expectedParam == null|| !"threeRewrite".equals(expectedParam)))){
            // 如果请求头不存在或值不正确，可以返回错误响应
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            httpResponse.getWriter().write("error!!!!403");
            return; // 阻止链中的下一个过滤器或servlet执行
        }


//        if (webType == null && (customHeader == null || !customHeader.equals("expectedValue"))) {
//            // 如果请求头不存在或值不正确，可以返回错误响应
//            HttpServletResponse httpResponse = (HttpServletResponse) response;
//            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
//            httpResponse.getWriter().write("Missing or invalid Custom-Header");
//            return; // 阻止链中的下一个过滤器或servlet执行
//        }

        // 如果请求头有效，则继续执行链中的下一个过滤器或servlet
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 过滤器销毁代码（如果需要的话）
    }
}
