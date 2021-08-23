package org.saliam.smartbids.bid.application;

import org.saliam.smartbids.bid.domain.entity.Bid;
import org.saliam.smartbids.bid.domain.port.in.BidService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BidApplicationService
{

  final BidService bidService;

  public BidApplicationService(BidService bidService)
  {
    this.bidService = bidService;
  }

  @Transactional
  public Bid save(final Bid bid){
    return bidService.save(bid);
  }

  public List<Bid> findByItem(final long itemId)
  {
    return bidService.findByItem(itemId);
  }
}
