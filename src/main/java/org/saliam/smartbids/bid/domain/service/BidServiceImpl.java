package org.saliam.smartbids.bid.domain.service;

import org.saliam.smartbids.bid.domain.entity.Bid;
import org.saliam.smartbids.bid.domain.port.in.BidService;
import org.saliam.smartbids.bid.domain.port.out.BidRepository;

import java.util.List;

public class BidServiceImpl implements BidService
{
  private final BidRepository bidRepository;

  public BidServiceImpl(BidRepository bidRepository)
  {
    this.bidRepository = bidRepository;
  }

  @Override
  public Bid save(Bid bid)
  {
    return bidRepository.Save(bid);
  }

  @Override
  public List<Bid> findByItem(long itemId)
  {
    return bidRepository.findByItem(itemId);
  }
}
