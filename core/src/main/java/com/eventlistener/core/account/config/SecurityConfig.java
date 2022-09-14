package com.eventlistener.core.account.config;//package com.eventlistener.account.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/", "/login", "/sign-up", "/check-email-token", "/logout",
                        "/email-login", "/login-by-email", "/login-link").permitAll()
                .mvcMatchers(HttpMethod.GET, "/profile/*", "/board", "/outbound").permitAll()
                .mvcMatchers(HttpMethod.GET, "/admin/*").hasAuthority("ADMIN")
                .mvcMatchers(HttpMethod.POST, "/admin/*").hasAuthority("ADMIN")
                .mvcMatchers(HttpMethod.GET, "/stock/*", "/outbound/*", "/inbound/*").hasAuthority("USER")
                .mvcMatchers(HttpMethod.POST, "/stock/*", "/outbound/*", "/inbound/*").hasAuthority("USER")
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/login").permitAll();

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .logoutSuccessUrl("/login?logout");

//        http.rememberMe()
//                .userDetailsService(userDetailsService)
//                .tokenRepository(tokenRepository());

        return http.build();
    }

}
