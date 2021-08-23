package org.saliam.smartbids.user.presentation.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RoleDto
{
  private Long id;

  private String name;

  private Type type;

  public enum Type
  {
    @JsonProperty("ADMIN")
    ADMIN,
    @JsonProperty("BIDDER")
    BIDDER,
    @JsonProperty("AUCTIONEER")
    AUCTIONEER
  }
}
