package org.saliam.smartbids.security.authentication.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor
public class AuthenticationResponse
{
  private Long id;

  private String username;

  private String email;

  private String token;

  private String type;

  private List<String> roles;
}
