package com.tsepomaleka.demos.springbootandjsfintegrationdemo.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FacesUrlRewriteFilter implements Filter {

    private final String facesExtension;

    public FacesUrlRewriteFilter(final String facesExtension) {
        this.facesExtension = facesExtension;
    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws ServletException, IOException {

        final var httpServletRequest = (HttpServletRequest) servletRequest;
        final var requestUri = httpServletRequest.getRequestURI();

        if (isUrlExtensionless(requestUri)) {
            var requestDispatcher = httpServletRequest.getRequestDispatcher(requestUri.concat(facesExtension));
            requestDispatcher.forward(servletRequest, servletResponse);
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private boolean isUrlExtensionless(final String requestUri) {
        final var lastIndexOfForwardSlash = requestUri.lastIndexOf("/");
        final var urlPrefix = requestUri.substring(lastIndexOfForwardSlash + 1);
        return !urlPrefix.contains(".");
    }
}
