package com.xzy.action.mvc.config.mvc;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

/**
 * @author xzy.xiao
 * @since 2024/12/24  9:42
 */
@Component

// 最高优先级
@Order(HIGHEST_PRECEDENCE + 1)
public class RereadableHttpServletRequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // Make request rereadable
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        RereadableHttpServletRequestWrapper rereadableHttpServletRequestWrapper = new RereadableHttpServletRequestWrapper(httpServletRequest);

        //
        filterChain.doFilter(rereadableHttpServletRequestWrapper, servletResponse);
    }
}
