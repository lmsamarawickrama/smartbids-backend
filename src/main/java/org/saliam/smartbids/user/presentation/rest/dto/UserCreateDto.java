package org.saliam.smartbids.user.presentation.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter @Setter
public class UserCreateDto
{
  private String username;

  private String email;

  private String password;

  private Set<RoleDto> roles;
}
