//package com.mettl.authorizationserverpoc.config.authserver;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//
//import javax.annotation.Resource;
//
//@Configuration
//@EnableAuthorizationServer
//public class JwtTokenAuthServer extends AuthorizationServerConfigurerAdapter {
//
//    @Resource
//    private PasswordEncoder passwordEncoder;
//
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Resource
//    private UserDetailsService userDetailsService;
//
//    @Resource
//    private JwtAccessTokenConverter jwtAccessTokenConverter;
//
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        InMemoryClientDetailsServiceBuilder inMemoryClientDetailsServiceBuilder = clients.inMemory();
//
//
//        inMemoryClientDetailsServiceBuilder.withClient("client")
//                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//                .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT", "USER")
//                .scopes("read", "write")
//                .autoApprove(true)
//                .secret(passwordEncoder.encode("password")).accessTokenValiditySeconds(10);
//
//        inMemoryClientDetailsServiceBuilder.withClient("client2")
//                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//                .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT", "USER")
//                .scopes("read", "write")
//                .autoApprove(true)
//                .secret(passwordEncoder.encode("password2")).accessTokenValiditySeconds(20);
//
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) {
//        security
//                .checkTokenAccess("isAuthenticated()")// return username, authorities`
//                .tokenKeyAccess("denyAll()")//return algo and signing key of token
//                .allowFormAuthenticationForClients();
//        // Possible values isAnonymous(),hasAuthority('ROLE_CLIENT'),denyAll()
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints
//                .authenticationManager(authenticationManager)
//                .userDetailsService(userDetailsService)
//                .accessTokenConverter(jwtAccessTokenConverter);
//    }
//}
