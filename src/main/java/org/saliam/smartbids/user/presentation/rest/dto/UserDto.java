package org.saliam.smartbids.user.presentation.rest.dto;

import lombok.Getter;
import lombok.Setter;
import org.saliam.smartbids.commons.presentation.PageableDto;

import java.util.Set;

@Getter @Setter
public class UserDto implements PageableDto
{
  private Long id;

  private String username;

  private String email;

  private String password;

  private Set<RoleDto> roles;
}
