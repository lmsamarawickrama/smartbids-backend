package org.saliam.smartbids.bid.presentation.rest.dto;

import lombok.Getter;
import lombok.Setter;
import org.saliam.smartbids.item.presentation.rest.dto.ItemDto;
import org.saliam.smartbids.user.presentation.rest.dto.UserDto;

@Getter @Setter
public class BidDto
{
  private String id;

  private UserDto bidder;

  private String amount;
}
