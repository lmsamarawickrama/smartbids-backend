package org.saliam.smartbids.bid.domain.port.in;

import org.saliam.smartbids.bid.domain.entity.Bid;

import java.util.List;

public interface BidService
{
  Bid save(Bid bid);

  List<Bid> findByItem(long userId);
}
