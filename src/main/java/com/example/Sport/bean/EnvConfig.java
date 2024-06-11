package com.example.Sport.bean;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//@Configuration
//public class EnvConfig {
//
//    @Value("${DATABASE_URL}")
//    private String databaseUrl;
//
//    @Value("${DATABASE_USERNAME}")
//    private String databaseUsername;
//
//    @Value("${DATABASE_PASSWORD}")
//    private String databasePassword;
//
//    @PostConstruct
//    public void init() {
//        try {
//            FileInputStream fis =new FileInputStream("sport.env");
//            Properties props = new Properties();
//            props.load(fis);
//
//            System.setProperty("DATABASE_URL", props.getProperty("DATABASE_URL"));
//            System.setProperty("DATABASE_USERNAME", props.getProperty("DATABASE_USERNAME"));
//            System.setProperty("DATABASE_PASSWORD", props.getProperty("DATABASE_PASSWORD"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

//    @PostConstruct
//    public void init() {
//        try {
//            // Загрузка переменных среды из файла .env
//            FileInputStream fis = new FileInputStream(".env");
//            Properties props = new Properties();
//            props.load(fis);
//
//            // Установка значений переменных среды
//            System.setProperty("DATABASE_URL", props.getProperty("DATABASE_URL"));
//            System.setProperty("DATABASE_USERNAME", props.getProperty("DATABASE_USERNAME"));
//            System.setProperty("DATABASE_PASSWORD", props.getProperty("DATABASE_PASSWORD"));
//
//            // Для того, чтобы использовать переменные среды в приложении, вы также можете установить их в значения полей класса,
//            // как показано в аннотациях @Value выше.
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}