package org.saliam.smartbids.security.authentication.domain.service;

import org.saliam.smartbids.security.authentication.domain.model.AuthenticationRequest;
import org.saliam.smartbids.security.authentication.domain.model.AuthenticationResponse;

public interface AuthenticationService
{
  AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
