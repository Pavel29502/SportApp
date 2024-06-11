package com.example.Sport.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class ServerConfig {

    @Value("${server.port}")
    private int port;

    @Value("${springdoc.swagger-ui.path}")
    private String swaggerUiPath;
}


