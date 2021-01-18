package com.example.common;

import com.example.RestServiceApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;


public class RequestLoggingFilter extends AbstractRequestLoggingFilter {
    private static final Logger logger =
            LoggerFactory.getLogger(RestServiceApplication.class);

    @Override
    protected boolean shouldLog(HttpServletRequest request) {
        return logger.isDebugEnabled();
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        logger.debug(message);
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        super.logger.debug(request.getRequestURI());
    }

}
