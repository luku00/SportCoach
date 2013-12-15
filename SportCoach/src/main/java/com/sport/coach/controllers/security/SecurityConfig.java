package com.sport.coach.controllers.security;

import com.sport.coach.repository.dao.RepositoryUserDetailsService;
import com.sport.coach.repository.dao.SportCoachDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Lukas Kubicek
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SportCoachDao sportCoachDao;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/resources/**", "/account/new/save").permitAll()
                .antMatchers("/account/admin/**").authenticated()
                .and().formLogin().loginPage("/account/login").permitAll()
                .and().logout().logoutSuccessUrl("/").permitAll();
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new RepositoryUserDetailsService(sportCoachDao);
    }
}
