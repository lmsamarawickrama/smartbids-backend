package org.saliam.smartbids.security.authentication.presentation.rest;

import org.saliam.smartbids.security.authentication.presentation.rest.dto.AuthenticationRequestDto;
import org.saliam.smartbids.security.authentication.presentation.rest.dto.AuthenticationResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface AuthenticationApi
{
  @PostMapping("/signin")
  ResponseEntity<AuthenticationResponseDto> authenticate(@Valid @RequestBody AuthenticationRequestDto loginRequest);
}
