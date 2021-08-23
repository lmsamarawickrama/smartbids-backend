package org.saliam.smartbids.security.authentication.presentation.rest.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class AuthenticationRequestDto
{
  @NotBlank
  private String username;

  @NotBlank
  private String password;
}
