package org.saliam.smartbids.item.infrastructure.adapter.event;

import org.saliam.smartbids.bid.infrastructure.adapter.database.entity.BidEntity;
import org.saliam.smartbids.bid.infrastructure.adapter.database.repository.BidEntityRepository;
import org.saliam.smartbids.item.domain.event.BidSelectedEvent;
import org.saliam.smartbids.item.domain.event.BidSelectedEventFactory;

import java.util.Optional;

public class BidSelectedEventFactoryImpl implements BidSelectedEventFactory
{
  final BidEntityRepository bidRepository;

  public BidSelectedEventFactoryImpl(
      final BidEntityRepository bidRepository)
  {
    this.bidRepository = bidRepository;
  }

  @Override
  public BidSelectedEvent create(String bidId)
  {
    Optional<BidEntity> byId = bidRepository.findById(Long.valueOf(bidId));
    BidEntity bidEntity = byId.orElseThrow(IllegalArgumentException::new);

    BidSelectedEvent bidSelectedEvent = new BidSelectedEvent();
    bidSelectedEvent.setItemId(String.valueOf(bidEntity.getItem().getId()));
    bidSelectedEvent.setItemDescription(bidEntity.getItem().getName());
    bidSelectedEvent.setSelectedBidAmount(bidEntity.getAmount());
    bidSelectedEvent.setSelectedBidOwner(bidEntity.getBidder().getUsername());

    return bidSelectedEvent;
  }
}
