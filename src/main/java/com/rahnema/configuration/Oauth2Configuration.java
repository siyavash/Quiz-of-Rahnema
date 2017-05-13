package com.rahnema.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * Created by siyavash on 5/13/2017.
 */

@EnableAuthorizationServer
@Configuration
public class Oauth2Configuration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    DataSource dataSource;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(new JdbcTokenStore(dataSource))
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // @formatter:off
        clients
                .jdbc(dataSource)
//                .withClient("siyavash")
//                .authorizedGrantTypes("password", "refresh_token", "client_credentials", "authorization_code")
//                .authorities("ROLE_USER")
//                .scopes("read", "write")
////                .resourceIds(RESOURCE_ID)
//                .secret("12345621");
        ;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("permitAll()");
        //    .passwordEncoder(passwordEncoder);

    }
}
