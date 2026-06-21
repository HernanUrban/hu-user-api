package com.hernanurban.user.config;

import org.apache.catalina.core.StandardContext;
import org.springframework.boot.tomcat.servlet.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {

    /**
     * Tomcat by default redirects requests to the context root without trailing slash
     * (e.g. POST /user → 302 → POST /user/), which breaks REST clients.
     * Disabling this lets Spring MVC handle the context root path directly.
     */
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> disableContextRootRedirect() {
        return factory -> factory.addContextCustomizers(
                ctx -> ((StandardContext) ctx).setMapperContextRootRedirectEnabled(false)
        );
    }
}
