package org.saliam.smartbids.security.authentication.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class AuthenticationRequest
{
  private String username;

  private String password;
}
