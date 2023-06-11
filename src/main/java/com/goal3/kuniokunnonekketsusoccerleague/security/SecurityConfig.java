package com.goal3.kuniokunnonekketsusoccerleague.security;

import com.goal3.kuniokunnonekketsusoccerleague.security.jwt.JwtConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.goal3.kuniokunnonekketsusoccerleague.KunioKunNoNekketsuSoccerLeagueApplication.API_BASE_PATH;

@Configuration
@EnableWebSecurity //нужна для написания конфигурации HttpSecurity, WebSecurity или AuthenticationManagerBuilder
@EnableGlobalMethodSecurity(prePostEnabled = true) //включаем использование аннотаций @PreAuthorize и @PostAuthorize
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtConfigurer jwtConfigurer;

    public SecurityConfig(JwtConfigurer jwtConfigurer) {
        this.jwtConfigurer = jwtConfigurer;
    }

    //задаем настройки конфигурации
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //отключаем CSRF
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(API_BASE_PATH + "/auth/login").permitAll()
                .anyRequest().authenticated() //any request should be authorized
                .and()
                .apply(jwtConfigurer);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
