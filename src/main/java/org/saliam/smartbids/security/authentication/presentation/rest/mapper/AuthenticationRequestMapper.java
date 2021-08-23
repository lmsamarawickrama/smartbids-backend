package org.saliam.smartbids.security.authentication.presentation.rest.mapper;

import org.mapstruct.Mapper;
import org.saliam.smartbids.security.authentication.domain.model.AuthenticationRequest;
import org.saliam.smartbids.security.authentication.presentation.rest.dto.AuthenticationRequestDto;

@Mapper
public interface AuthenticationRequestMapper
{
  AuthenticationRequest  authenticationRequestToAuthenticationRequestDto(AuthenticationRequestDto authenticationRequestDto);
}
