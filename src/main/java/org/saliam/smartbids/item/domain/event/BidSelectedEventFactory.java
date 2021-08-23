package org.saliam.smartbids.item.domain.event;

public interface BidSelectedEventFactory
{
  BidSelectedEvent create(String bidId);
}
