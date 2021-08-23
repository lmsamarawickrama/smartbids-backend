package org.saliam.smartbids.notification.domain.service;

import org.saliam.smartbids.item.domain.event.BidSelectedEvent;
import org.saliam.smartbids.notification.domain.port.in.EmailService;
import org.saliam.smartbids.notification.domain.port.in.SelectedBidNotificationListener;

public class SelectedBidNotificationListenerImpl implements SelectedBidNotificationListener
{
  private final EmailService emailService;

  public SelectedBidNotificationListenerImpl(EmailService emailService)
  {
    this.emailService = emailService;
  }

  @Override
  public void onReceivedSelectedBid(BidSelectedEvent selectedBidEvent)
  {
     emailService.sendSelectedBidToUser(selectedBidEvent);
  }
}
