package org.saliam.smartbids.item.domain.event;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BidSelectedEvent
{
  private String itemId;

  private String itemDescription;

  private String selectedBidId;

  private String selectedBidAmount;

  private String selectedBidOwner;

}
