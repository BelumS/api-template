package com.belum.apitemplate.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

import static org.springframework.http.HttpHeaders.*;

/**
 * Created by bel-sahn on 7/29/19
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//region PROPERTIES
//endregion

//region CONSTRUCTORS
//endregion

//region HELPER METHODS
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();
        http.cors();
        http.csrf().disable();
        super.configure(http);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/actuator/health/**", "/heartbeat/**", "/api/v1/**");
    }
    //endregion

    //region BEANS
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.unmodifiableList(Collections.singletonList("*")));
        configuration.setAllowedMethods(Collections.unmodifiableList(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH")));
        configuration.setAllowedHeaders(Collections.unmodifiableList(Arrays.asList(AUTHORIZATION, CACHE_CONTROL, CONTENT_TYPE, "JWT")));
        configuration.setExposedHeaders(Collections.unmodifiableList(Collections.singletonList(CONTENT_TYPE)));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

/*    @Bean
    public FilterRegistrationBean myFilterRegistration(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setEnabled(false);
        filterRegistrationBean.setOrder(0);
        filterRegistrationBean.setFilter(new SecurityFilter());
        return filterRegistrationBean;
    }*/
//endregion
}
