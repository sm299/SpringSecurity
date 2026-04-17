package com.demo.SpringSecurityEx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.demo.SpringSecurityEx.service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    UserDetailServiceImpl userDetailServiceImpl;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity sec) throws Exception {
        sec.csrf(customizer -> customizer.disable());// disabling csrf token
        sec.authorizeHttpRequests(customizer -> customizer.anyRequest().authenticated());// any req will be authorized
        sec.formLogin(Customizer.withDefaults());// web pages will get default login form
        sec.httpBasic(Customizer.withDefaults());// for http requests to access

        sec.sessionManagement(customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // will make the request stateless
        return sec.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailServiceImpl);
        return provider;
    }

    /*
     * @Bean
     * public UserDetailsService userDetailsService() {
     * UserDetails user1 = User
     * .withDefaultPasswordEncoder()
     * .username("Soumik")
     * .password("S@299")
     * .roles("USER")
     * .build();
     * return new InMemoryUserDetailsManager();
     * }
     */
}
