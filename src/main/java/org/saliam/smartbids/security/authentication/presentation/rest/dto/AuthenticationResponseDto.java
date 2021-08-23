package org.saliam.smartbids.security.authentication.presentation.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class AuthenticationResponseDto
{
  private Long id;

  private String username;

  private String email;

  private String token;

  private String type;

  private List<String> roles;
}
