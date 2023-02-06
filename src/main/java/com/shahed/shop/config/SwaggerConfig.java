package com.shahed.shop.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${springdoc.swagger-ui.localAddress}")
    private String local;

    @Value("${server.servlet.context-path}")
    public String contextPath;

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String swaggerVersion) {
        return new OpenAPI()
                .addServersItem(new Server().url(local + contextPath))
                .info(new Info()
                        .title("shop API")
                        .version(swaggerVersion)
                        .termsOfService("")
                        .license(new License().name("shahed").url("http://shahed.ac.ir")));
    }
}
