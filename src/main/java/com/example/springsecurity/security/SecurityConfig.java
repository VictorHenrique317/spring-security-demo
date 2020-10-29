package com.example.springsecurity.security;

import com.example.springsecurity.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.swing.*;

import static com.example.springsecurity.security.RoleType.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder, UserServiceImpl userServiceImpl) {
        this.passwordEncoder = passwordEncoder;
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/api/**").hasRole(STUDENT.name())
//                .antMatchers("/management/api/**").hasAnyRole(ADMIN.name(), ADMIN_TRAINEE.name())
//                .antMatchers("/management/api/**").hasRole(ADMIN_TRAINEE.name())
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest()
                .authenticated();

        http
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/courses", true)
                .and()
                .rememberMe();

        http
                .headers()
                .frameOptions()
                .disable();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceImpl)
                .passwordEncoder(passwordEncoder);
    }
}
