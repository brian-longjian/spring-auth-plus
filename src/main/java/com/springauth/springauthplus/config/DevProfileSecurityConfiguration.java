package com.springauth.springauthplus.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Brian Long
 */
@Profile("dev")
@Configuration(proxyBeanMethods = false)
public class DevProfileSecurityConfiguration {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    SecurityFilterChain h2ConsoleSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher(PathRequest.toH2Console())
                // .securityMatcher(new AntPathRequestMatcher("/h2-console/**"))
                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().permitAll())
                .csrf((csrf) -> csrf.disable())
                .headers((headers) -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()));
        return http.build();
    }
}