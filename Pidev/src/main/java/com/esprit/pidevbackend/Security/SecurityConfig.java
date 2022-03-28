package com.esprit.pidevbackend.Security;
import com.esprit.pidevbackend.Filter.CustomAuthenticationFilter;
import com.esprit.pidevbackend.Filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(
         securedEnabled = true,
        // jsr250Enabled = true,
        prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService ;
    private final BCryptPasswordEncoder bCryptPasswordEncoder ;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers( "/api/login/**","/api/token/refresh/**","/timeTable/**","/","/profile/**","/api/getToken","/commentPub/addCommentToPubAndUser/**","/api/user/save/**","/api/role/save","/api/role/addtouser/**").permitAll();
        //http.authorizeRequests().antMatchers(GET ,"/api/user/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN");
       // http.authorizeRequests().antMatchers(POST ,"/api/user/save/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(  "/admin/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(  "/rooms/**","/competitions/**","/timeslots/**").hasAnyAuthority("ROLE_ADMIN");

        //khalil

        http.authorizeRequests().antMatchers( "/Collaboration/**").permitAll();
        http.authorizeRequests().antMatchers( "/Offer/**").permitAll();
        http.authorizeRequests().antMatchers( "/Reservation/**").permitAll();
        http.authorizeRequests().antMatchers( "/Publicity/**").permitAll();
        http.authorizeRequests().antMatchers( "/Notification/**").permitAll();


        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter) ;
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);



    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws  Exception {
        return super.authenticationManagerBean();
    }




}
