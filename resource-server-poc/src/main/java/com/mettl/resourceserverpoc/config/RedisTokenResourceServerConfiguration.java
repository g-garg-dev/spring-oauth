package com.mettl.resourceserverpoc.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisTokenResourceServerConfiguration extends WebSecurityConfigurerAdapter {

    @Resource
    private RemoteTokenServices remoteTokenServices;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/**").permitAll()
                .and()
                .addFilterBefore(getOAuth2AuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication().withUser("admin").password("admin")
                .authorities("ROLE_ADMIN");
    }

    private OAuth2AuthenticationProcessingFilter getOAuth2AuthenticationProcessingFilter() {
        // configure token Extractor
        BearerTokenExtractor tokenExtractor = new BearerTokenExtractor();
        // configure Auth manager
        OAuth2AuthenticationManager manager = new OAuth2AuthenticationManager();



        // configure RemoteTokenServices with your client Id and auth server endpoint
        manager.setTokenServices(remoteTokenServices);

        OAuth2AuthenticationProcessingFilter filter = new OAuth2AuthenticationProcessingFilter();
        filter.setTokenExtractor(tokenExtractor);
        filter.setAuthenticationManager(manager);
        return filter;
    }
}
