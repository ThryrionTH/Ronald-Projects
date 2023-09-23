package com.projectcodingdojo.petjoy_shop.petjoy_shop.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity //habilitamos la seguridad web
public class SeguridadWeb {

    @Value("${role_user}")
    private String USER;
    @Value("${role_admin}")
    private String ADMIN;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
        .authorizeHttpRequests((request) ->{
            request
            .requestMatchers( new AntPathRequestMatcher("/"))
                .permitAll()
                .requestMatchers(new AntPathRequestMatcher("/dashboard/**"))
                .hasAnyRole(ADMIN)
                .requestMatchers(new AntPathRequestMatcher("/dashboard/*/delete"))
                .hasRole(ADMIN)
                .requestMatchers(new AntPathRequestMatcher("/checkout-cart"))
                .hasAnyRole(USER)
            .anyRequest()
                .permitAll();
        })
        .formLogin((login ->{
            Customizer.withDefaults();
            login
                .loginPage("/login")
                .defaultSuccessUrl("/user");
        }))
        .logout(logout -> logout 
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .deleteCookies("JSESSIONID")
        )
        .csrf(Customizer.withDefaults()); 

        return http.build();
    }

}
