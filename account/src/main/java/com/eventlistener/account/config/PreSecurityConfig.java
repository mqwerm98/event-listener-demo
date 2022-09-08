//package com.eventlistener.account.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class PreSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final UserDetailsService userDetailsService;
//    private final DataSource dataSource;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .mvcMatchers("/", "/login", "/sign-up", "/check-email-token", "/logout",
//                        "/email-login", "/login-by-email", "/login-link",
//                        "/lecture/detail/**","/community/**", "/cook/**").permitAll()
//                .mvcMatchers(HttpMethod.GET, "/profile/*", "/lecture").permitAll()
//                .mvcMatchers(HttpMethod.GET, "/lecture/form").hasAuthority("ADMIN")
//                .mvcMatchers(HttpMethod.POST, "/lecture").hasAuthority("ADMIN")
//                .anyRequest().authenticated();
//
//        http.formLogin()
//                .loginPage("/login").permitAll();
//
//        http.logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
//                .logoutSuccessUrl("/login?logout");
//
//        http.rememberMe()
//                .userDetailsService(userDetailsService)
//                .tokenRepository(tokenRepository());
//    }
//
//    @Bean
//    public PersistentTokenRepository tokenRepository() {
//        // JdbcTokenRepositoryImpl의 CREATE_TABLE_SQL에 있는 쿼리를 따라서 PersistentLogins entity 만들어서 사용!
//        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
//        jdbcTokenRepository.setDataSource(dataSource);
//        return jdbcTokenRepository;
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring() // security 적용에서 제외
//                .mvcMatchers("/node_modules/**")
//                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//    }
//}
