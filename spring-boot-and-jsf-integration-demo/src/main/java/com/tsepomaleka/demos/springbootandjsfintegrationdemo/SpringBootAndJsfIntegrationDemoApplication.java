package com.tsepomaleka.demos.springbootandjsfintegrationdemo;

import com.tsepomaleka.demos.springbootandjsfintegrationdemo.web.filter.FacesUrlRewriteFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;

import java.util.EnumSet;
import java.util.List;

@SpringBootApplication
public class SpringBootAndJsfIntegrationDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAndJsfIntegrationDemoApplication.class, args);
	}

    @Bean
    @Description("Faces Servlet Registration Bean")
    public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
        return new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
    }

    @Bean
    @Description("Faces URL Rewrite Filter Registration Bean")
    public FilterRegistrationBean<FacesUrlRewriteFilter> facesUrlRewriteFilterRegistrationBean() {
	    var facesUrlRewriteFilterRegistrationBean = new FilterRegistrationBean<FacesUrlRewriteFilter>();

	    facesUrlRewriteFilterRegistrationBean.setFilter(new FacesUrlRewriteFilter(".xhtml"));
	    facesUrlRewriteFilterRegistrationBean.setAsyncSupported(true);

	    final var dispatcherTypes =
            EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ASYNC, DispatcherType.INCLUDE);
	    facesUrlRewriteFilterRegistrationBean.setDispatcherTypes(dispatcherTypes);

	    return facesUrlRewriteFilterRegistrationBean;
    }
}
