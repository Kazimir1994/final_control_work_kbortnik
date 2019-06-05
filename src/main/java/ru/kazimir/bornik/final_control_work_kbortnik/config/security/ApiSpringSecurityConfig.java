package ru.kazimir.bornik.final_control_work_kbortnik.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import static ru.kazimir.bornik.final_control_work_kbortnik.constant.ApiURLConstants.API_V1_ADMIN;
import static ru.kazimir.bornik.final_control_work_kbortnik.constant.ApiURLConstants.API_V1_CUSTOMER;
import static ru.kazimir.bornik.final_control_work_kbortnik.constant.RoleConstants.ADMIN_ROLE_NAME;
import static ru.kazimir.bornik.final_control_work_kbortnik.constant.RoleConstants.CUSTOMER_ROLE_NAME;

@Configuration
public class ApiSpringSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final AccessDeniedHandler accessDeniedHandler;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApiSpringSecurityConfig(@Qualifier("appUserDetailsService") UserDetailsService userDetailsService,
                                   AccessDeniedHandler accessDeniedHandler,
                                   PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.accessDeniedHandler = accessDeniedHandler;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher(API_V1_ADMIN)
                .authorizeRequests()
                .anyRequest()
                .hasAuthority(ADMIN_ROLE_NAME)
                .and()
                .antMatcher(API_V1_CUSTOMER)
                .authorizeRequests()
                .anyRequest()
                .hasAuthority(CUSTOMER_ROLE_NAME)
                .and()
                .httpBasic()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .and()
                .csrf()
                .disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
