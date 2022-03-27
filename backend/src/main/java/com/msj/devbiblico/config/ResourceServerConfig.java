package com.msj.devbiblico.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/users/**", "/api/books/**", "/api/devotional/**", "/oauth/token**").permitAll()
                .anyRequest().denyAll();
//                .antMatchers("/api/users/**").hasAnyRole("USER", "ADMIN");
    }
}
