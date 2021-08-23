package org.saliam.smartbids.security.authentication.presentation.rest.controller;

import org.mapstruct.factory.Mappers;
import org.saliam.smartbids.security.authentication.domain.model.AuthenticationRequest;
import org.saliam.smartbids.security.authentication.domain.model.AuthenticationResponse;
import org.saliam.smartbids.security.authentication.domain.service.AuthenticationService;
import org.saliam.smartbids.security.authentication.presentation.rest.AuthenticationApi;
import org.saliam.smartbids.security.authentication.presentation.rest.dto.AuthenticationRequestDto;
import org.saliam.smartbids.security.authentication.presentation.rest.dto.AuthenticationResponseDto;
import org.saliam.smartbids.security.authentication.presentation.rest.mapper.AuthenticationRequestMapper;
import org.saliam.smartbids.security.authentication.presentation.rest.mapper.AuthenticationResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/smartbids/api/authentication")
public class AuthenticationController implements AuthenticationApi
{

  private AuthenticationService authenticationService;

  @Autowired
  public void setAuthenticationService(
      AuthenticationService authenticationService)
  {
    this.authenticationService = authenticationService;
  }

  @Override
  public ResponseEntity<AuthenticationResponseDto> authenticate(AuthenticationRequestDto authenticationRequestDto)
  {
    final AuthenticationRequestMapper authenticationRequestMapper = Mappers
        .getMapper(AuthenticationRequestMapper.class);
    AuthenticationRequest authenticationRequest = authenticationRequestMapper
        .authenticationRequestToAuthenticationRequestDto(authenticationRequestDto);
    AuthenticationResponse authenticationResponse = authenticationService.authenticate(authenticationRequest);
    AuthenticationResponseMapper authenticationResponseMapper = Mappers.getMapper(AuthenticationResponseMapper.class);
    return ResponseEntity
        .ok(authenticationResponseMapper.authenticationResponseToAuthenticationResponseDto(authenticationResponse));
  }
}
