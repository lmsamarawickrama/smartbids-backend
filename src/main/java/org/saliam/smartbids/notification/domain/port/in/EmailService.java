package org.saliam.smartbids.notification.domain.port.in;

import org.saliam.smartbids.item.domain.event.BidSelectedEvent;

public interface EmailService
{
  void sendSelectedBidToUser(BidSelectedEvent bidSelectedEvent);
}
