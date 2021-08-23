package org.saliam.smartbids.item.domain.port.out;

import org.saliam.smartbids.item.domain.event.BidSelectedEvent;

public interface ItemEventProducer
{
  void sendBidSelectedEvent(BidSelectedEvent bidSelectedEvent);
}
