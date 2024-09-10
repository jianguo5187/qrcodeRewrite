package com.qrcode.rewrite.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CustomHeaderFilter> customHeaderFilter() {
        FilterRegistrationBean<CustomHeaderFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new CustomHeaderFilter());
        registrationBean.addUrlPatterns("/*"); // 你可以指定过滤器应用的URL模式

        return registrationBean;
    }
}