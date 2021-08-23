package org.saliam.smartbids.item.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.saliam.smartbids.bid.domain.entity.Bid;
import org.saliam.smartbids.bid.infrastructure.adapter.database.entity.BidEntity;
import org.saliam.smartbids.user.domain.entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
public class Item
{
  private String id;

  @NotBlank
  private String name;

  @NotNull
  private User owner;

  @NotNull
  private Period duration;

  @NotEmpty
  private String minimumPrize;

  private List<Bid> bids;

  private Bid selectedBid;
}
