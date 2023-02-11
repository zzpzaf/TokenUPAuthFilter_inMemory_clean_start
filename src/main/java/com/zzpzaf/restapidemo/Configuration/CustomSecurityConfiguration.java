package com.zzpzaf.restapidemo.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfiguration {

   
    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;
    // @Bean
    // public AuthenticationManager authManager() throws Exception {
    //     return authenticationConfiguration.getAuthenticationManager();
    // }


    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder bCryptPasswordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
        .password(bCryptPasswordEncoder.encode("user_passw"))
        .roles("USER")
        .build());
        manager.createUser(User.withUsername("admin")
        .password(bCryptPasswordEncoder.encode("admin_passw"))
        .roles("USER", "ADMIN")
        .build());
        return manager;
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    
    @Bean
    public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .formLogin().disable();
        http.addFilter(new UsernamePasswordAuthenticationFilter(authenticationConfiguration.getAuthenticationManager()));
        //http.addFilter(new UsernamePasswordAuthenticationFilter(authManager()));
        return http.build();
    } 
}    

