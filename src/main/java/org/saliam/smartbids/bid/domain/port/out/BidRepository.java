package org.saliam.smartbids.bid.domain.port.out;

import org.saliam.smartbids.bid.domain.entity.Bid;

import java.util.List;

public interface BidRepository
{
  Bid Save(Bid bid);

  List<Bid> findByItem(long userId);
}
