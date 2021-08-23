package org.saliam.smartbids.security.authentication.domain.port.in;

import org.saliam.smartbids.security.authentication.domain.model.AuthenticationRequest;
import org.saliam.smartbids.security.authentication.domain.model.AuthenticationResponse;
import org.saliam.smartbids.security.authentication.domain.port.out.AuthenticationManager;
import org.saliam.smartbids.security.authentication.domain.service.AuthenticationService;

public class AuthenticationServiceImpl implements AuthenticationService
{

  private final AuthenticationManager authenticationManager;

  public AuthenticationServiceImpl(
      final AuthenticationManager authenticationManager)
  {
    this.authenticationManager = authenticationManager;
  }

  @Override
  public AuthenticationResponse authenticate(final AuthenticationRequest authenticationRequest)
  {
    return authenticationManager.authenticate(authenticationRequest);
  }
}
