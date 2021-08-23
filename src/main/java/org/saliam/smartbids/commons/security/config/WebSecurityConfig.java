package org.saliam.smartbids.commons.security.config;

import org.saliam.smartbids.commons.security.filter.AuthenticationJWTFilter;
import org.saliam.smartbids.security.authentication.infrastrucure.adapter.jwt.AuthenticationEntryPointJwt;
import org.saliam.smartbids.security.authentication.infrastrucure.adapter.jwt.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
    prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

  private UserDetailsServiceImpl userDetailsService;

  private AuthenticationEntryPointJwt authenticationEntryPointJwt;

  @Autowired
  public void setUserDetailsService(
      UserDetailsServiceImpl userDetailsService)
  {
    this.userDetailsService = userDetailsService;
  }

  @Autowired
  public void setAuthenticationEntryPointJwt(
      AuthenticationEntryPointJwt authenticationEntryPointJwt)
  {
    this.authenticationEntryPointJwt = authenticationEntryPointJwt;
  }

  @Bean
  public AuthenticationJWTFilter getAuthenticationJWTFilter()
  {
    return new AuthenticationJWTFilter();
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception
  {
    return super.authenticationManagerBean();
  }

  @Bean
  public PasswordEncoder passwordEncoder()
  {
    return new BCryptPasswordEncoder();
  }

  @Override
  public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
  {
    authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
    http.cors().configurationSource(getCorsConfigurationSource()).and().csrf().disable()
        .exceptionHandling().authenticationEntryPoint(authenticationEntryPointJwt).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests()
        .antMatchers("/smartbids/api/authentication/signin").permitAll()
        .antMatchers(HttpMethod.POST, "/smartbids/api/user/**").permitAll()
        .anyRequest().authenticated();

    http.addFilterBefore(getAuthenticationJWTFilter(), UsernamePasswordAuthenticationFilter.class);
  }

  public UrlBasedCorsConfigurationSource getCorsConfigurationSource()
  {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.setAllowedOrigins(Collections.singletonList("*"));
    corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
    corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));

    UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
    configurationSource.registerCorsConfiguration("/**", corsConfiguration);
    return configurationSource;
  }
}
