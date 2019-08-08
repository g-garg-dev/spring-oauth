package com.mettl.authorizationserverpoc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan({"com.mettl.authorizationserverpoc"})
@PropertySource(value = "classpath:application.properties")
public class AuthorizationServerPoc {

    public static void main(String args[]) {
        new SpringApplicationBuilder(AuthorizationServerPoc.class)
                .build().run(args);
    }

}
