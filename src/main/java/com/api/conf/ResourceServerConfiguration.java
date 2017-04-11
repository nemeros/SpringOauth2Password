package com.api.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	 private static final String RESOURCE_ID = "my_rest_api";
	 	 
	 @Autowired
	 private DefaultTokenServices tokenServices;
	 
	 @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID)
        	.stateless(true)
        	.tokenServices(tokenServices);
    }
	 
	 @Override
	    public void configure(HttpSecurity http) throws Exception {
	        http
	        .requestMatchers().antMatchers("/api/**")
	        .and().authorizeRequests()
	        .antMatchers("/user/**").access("hasRole('ADMIN')")
	        .anyRequest().authenticated()
	        .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	    }
	 

}
