package org.saliam.smartbids.user.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter @Setter
public class Role
{
  private Long id;

  private String name;

  private Type type;

  public enum Type
  {
    ADMIN, BIDDER, AUCTIONEER
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Role role = (Role) o;
    return id.equals(role.id);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(id);
  }
}
