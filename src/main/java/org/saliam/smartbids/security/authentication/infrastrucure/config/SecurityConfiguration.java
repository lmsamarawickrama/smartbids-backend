package org.saliam.smartbids.security.authentication.infrastrucure.config;

import org.saliam.smartbids.security.authentication.domain.port.in.AuthenticationServiceImpl;
import org.saliam.smartbids.security.authentication.domain.port.out.AuthenticationManager;
import org.saliam.smartbids.security.authentication.domain.service.AuthenticationService;
import org.saliam.smartbids.security.authentication.infrastrucure.adapter.jwt.AuthenticationEntryPointJwt;
import org.saliam.smartbids.security.authentication.infrastrucure.adapter.jwt.JWTAuthenticationManager;
import org.saliam.smartbids.security.authentication.infrastrucure.adapter.jwt.JwtUtilityService;
import org.saliam.smartbids.security.authentication.infrastrucure.adapter.jwt.UserDetailsServiceImpl;
import org.saliam.smartbids.user.domain.port.in.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
public class SecurityConfiguration
{
  @Bean(name = "org.saliam.smartbids.security.authentication.domain.service.AuthenticationService")
  public AuthenticationService getAuthenticationService(final AuthenticationManager authenticationManager)
  {
    return new AuthenticationServiceImpl(authenticationManager);
  }

  @Bean(name = "org.saliam.smartbids.security.authentication.infrastrucure.adapter.jwt.JwtUtilityService")
  public JwtUtilityService getJwtUtilityService(@Value("${smartbids.app.jwtSecret}") String jwtSecret, @Value("${smartbids.app.jwtExpirationMs}") int jwtExpiration)
  {
    return new JwtUtilityService(jwtSecret, jwtExpiration);
  }

  @Bean(name = "org.saliam.smartbids.security.authentication.domain.port.out.BasicAuthenticationManager")
  public AuthenticationManager getBasicAuthenticationManager(
      org.springframework.security.authentication.AuthenticationManager authenticationManager,
      JwtUtilityService jwtUtilityService)
  {
    return new JWTAuthenticationManager(authenticationManager, jwtUtilityService);
  }

  @Bean
  public UserDetailsService getUserDetailsService(final UserService userService)
  {
    return new UserDetailsServiceImpl(userService);
  }

  @Bean
  public AuthenticationEntryPoint getAuthenticationEntryPoint()
  {
    return new AuthenticationEntryPointJwt();
  }
}
