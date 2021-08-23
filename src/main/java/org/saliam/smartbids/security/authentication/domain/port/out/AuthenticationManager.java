package org.saliam.smartbids.security.authentication.domain.port.out;

import org.saliam.smartbids.security.authentication.domain.model.AuthenticationRequest;
import org.saliam.smartbids.security.authentication.domain.model.AuthenticationResponse;

public interface AuthenticationManager
{
  AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
