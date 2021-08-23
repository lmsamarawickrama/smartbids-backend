package org.saliam.smartbids.security.authentication.infrastrucure.adapter.jwt;

import org.saliam.smartbids.security.authentication.domain.model.AuthenticationRequest;
import org.saliam.smartbids.security.authentication.domain.model.AuthenticationResponse;
import org.saliam.smartbids.security.authentication.domain.model.UserDetailsImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.stream.Collectors;

public class JWTAuthenticationManager
    implements org.saliam.smartbids.security.authentication.domain.port.out.AuthenticationManager
{
  private final AuthenticationManager authenticationManager;

  private final JwtUtilityService jwtUtils;

  public JWTAuthenticationManager(
      final AuthenticationManager authenticationManager,
      final JwtUtilityService jwtUtils)
  {
    this.authenticationManager = authenticationManager;
    this.jwtUtils = jwtUtils;
  }

  @Override
  public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest)
  {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
            authenticationRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwtToken = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.toList());

    String bearerHeader = "Bearer";
    return new AuthenticationResponse(userDetails.getId(),
        userDetails.getUsername(),
        userDetails.getEmail(),
        jwtToken,
        bearerHeader,
        roles);
  }
}
