package org.saliam.smartbids.notification.domain.service;

import org.saliam.smartbids.item.domain.event.BidSelectedEvent;
import org.saliam.smartbids.notification.domain.port.in.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailServiceImpl implements EmailService
{

  private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

  @Override
  public void sendSelectedBidToUser(BidSelectedEvent bidSelectedEvent)
  {
    logger.info("Received message to be sent " + bidSelectedEvent);
  }
}
