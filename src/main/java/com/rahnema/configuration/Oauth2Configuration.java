package com.rahnema.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * Created by siyavash on 5/13/2017.
 */

@EnableAuthorizationServer
@Configuration
public class Oauth2Configuration extends AuthorizationServerConfigurerAdapter {
}
