package com.hoony.msa.springboot.configuration;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
    static final String H2_DB_WEB_CONSOLE_CONTEXT = "/console/*";

    @Bean
    ServletRegistrationBean<WebServlet> h2ServletRegistration() {
        return new ServletRegistrationBean<>(new WebServlet(), H2_DB_WEB_CONSOLE_CONTEXT);
    }
}
