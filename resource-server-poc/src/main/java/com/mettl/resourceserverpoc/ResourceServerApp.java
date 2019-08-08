package com.mettl.resourceserverpoc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan("com.mettl.resourceserverpoc")
@PropertySource(value = "classpath:application.properties")
public class ResourceServerApp {

    public static void main(String args[]) {
        new SpringApplicationBuilder(ResourceServerApp.class)
                .build().run(args);
    }
}
