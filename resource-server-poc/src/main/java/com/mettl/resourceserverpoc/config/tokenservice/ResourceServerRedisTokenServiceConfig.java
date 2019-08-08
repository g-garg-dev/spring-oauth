package com.mettl.resourceserverpoc.config.tokenservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
public class ResourceServerRedisTokenServiceConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer config) {
        config.tokenServices(tokenServices());
    }

    @Bean
    @Primary
    public RemoteTokenServices tokenServices() {
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        remoteTokenServices.setClientId("client");
        remoteTokenServices.setClientSecret("password");
        remoteTokenServices.setTokenName("token");
//        remoteTokenServices.setAccessTokenConverter();
        remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:8011/oauth/check_token");
        return remoteTokenServices;
    }
}
