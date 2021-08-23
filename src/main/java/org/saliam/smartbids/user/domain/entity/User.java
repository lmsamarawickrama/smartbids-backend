package org.saliam.smartbids.user.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter @Setter
public class User
{
  private Long id;

  private String username;

  private String email;

  private String password;

  private Set<Role> roles = new HashSet<>();

  public void addRole(Role role)
  {
    Objects.requireNonNull(role);
    roles.add(role);
  }

  public void removeRole(Role role)
  {
    Objects.requireNonNull(role);
    roles.remove(role);
  }
}
