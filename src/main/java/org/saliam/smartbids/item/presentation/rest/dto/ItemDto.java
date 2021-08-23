package org.saliam.smartbids.item.presentation.rest.dto;

import lombok.Getter;
import lombok.Setter;
import org.saliam.smartbids.bid.domain.entity.Bid;
import org.saliam.smartbids.bid.presentation.rest.dto.BidDto;
import org.saliam.smartbids.item.domain.entity.Period;
import org.saliam.smartbids.user.domain.entity.User;
import org.saliam.smartbids.user.presentation.rest.dto.UserDto;

import java.util.List;

@Getter @Setter
public class ItemDto
{
  private String id;

  private String name;

  private UserDto owner;

  private Period duration;

  private String minimumPrize;

  private List<BidDto> bids;

  private BidDto selectedBid;
}
