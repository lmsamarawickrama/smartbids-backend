package org.saliam.smartbids.security.authentication.presentation.rest.mapper;

import org.mapstruct.Mapper;
import org.saliam.smartbids.security.authentication.domain.model.AuthenticationResponse;
import org.saliam.smartbids.security.authentication.presentation.rest.dto.AuthenticationResponseDto;

@Mapper
public interface AuthenticationResponseMapper
{
  AuthenticationResponseDto authenticationResponseToAuthenticationResponseDto(
      AuthenticationResponse authenticationResponse);
}