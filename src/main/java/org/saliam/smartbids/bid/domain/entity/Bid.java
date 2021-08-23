package org.saliam.smartbids.bid.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.saliam.smartbids.item.domain.entity.Item;
import org.saliam.smartbids.user.domain.entity.User;

@Getter @Setter
public class Bid
{
  private String id;

  private Item item;

  private User bidder;

  private String amount;
}
