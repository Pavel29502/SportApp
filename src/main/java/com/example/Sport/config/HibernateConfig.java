package com.example.Sport.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class HibernateConfig {

    @Value("${spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation}")
    private boolean lobNonContextualCreation;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

}

