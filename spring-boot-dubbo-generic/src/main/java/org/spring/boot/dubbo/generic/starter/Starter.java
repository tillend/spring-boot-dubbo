package org.spring.boot.dubbo.generic.starter;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackages = "org.spring.boot.dubbo.generic.controller")
public class Starter {

    public static void main(String[] args) {

        new SpringApplicationBuilder(Starter.class).web(WebApplicationType.SERVLET).run(args);

    }

}