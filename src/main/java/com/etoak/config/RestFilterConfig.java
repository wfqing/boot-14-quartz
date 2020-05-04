package com.etoak.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/**
 * 配置支持同步请求(表单方式提交的)发送rest请求的过滤器
 */
@Configuration
public class RestFilterConfig {

    /**
     * 注册HiddenHttpMethodFilter
     * 作用：将post转成PUT、DELETE请求等
     * 要求：
     * 1. 表单提交方式必须POST
     * 2. 表单必须有一个隐藏域，name属性值是_method, value属性值是rest请求方式(如put、delete...)
     * @return
     */
    @Bean
    public FilterRegistrationBean<HiddenHttpMethodFilter> restFilter() {
        FilterRegistrationBean<HiddenHttpMethodFilter> restFilter =
                new FilterRegistrationBean<>(new HiddenHttpMethodFilter());
        restFilter.addUrlPatterns("/*");
        return restFilter;
    }

}
