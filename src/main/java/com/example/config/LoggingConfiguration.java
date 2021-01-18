package com.example.config;

import com.example.common.RequestLoggingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfiguration {

    /*@Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeClientInfo(true);
        filter.setIncludeHeaders(true);
        filter.setIncludePayload(true);
        return filter;
    }*/

    @Bean
    public RequestLoggingFilter requestLoggingFilter() {
        RequestLoggingFilter requestLoggingFilter = new RequestLoggingFilter();
        requestLoggingFilter.setIncludeClientInfo(true);
        return requestLoggingFilter;
    }
}
