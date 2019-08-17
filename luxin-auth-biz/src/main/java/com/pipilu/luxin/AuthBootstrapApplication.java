package com.pipilu.luxin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.pipilu")
public class AuthBootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthBootstrapApplication.class,args);
    }
}
