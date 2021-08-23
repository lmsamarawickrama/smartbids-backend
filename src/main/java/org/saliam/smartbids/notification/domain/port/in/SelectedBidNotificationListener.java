package org.saliam.smartbids.notification.domain.port.in;

import org.saliam.smartbids.item.domain.event.BidSelectedEvent;

public interface SelectedBidNotificationListener
{
  void onReceivedSelectedBid(BidSelectedEvent selectedBidEvent);
}