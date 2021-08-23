package org.saliam.smartbids.notification.infrastructure.event;

import org.saliam.smartbids.item.domain.event.BidSelectedEvent;
import org.saliam.smartbids.notification.domain.port.in.SelectedBidNotificationListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;

public class AMQPSelectedBidListener implements RabbitListenerConfigurer
{
  private final SelectedBidNotificationListener selectedBidNotificationListener;

  public AMQPSelectedBidListener(
      SelectedBidNotificationListener selectedBidNotificationListener)
  {
    this.selectedBidNotificationListener = selectedBidNotificationListener;
  }

  @Override
  public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar)
  {

  }

  @RabbitListener(queues = "${smartbids.rabbitmq.queue}")
  public void receivedMessage(BidSelectedEvent bidSelectedEvent) {
    selectedBidNotificationListener.onReceivedSelectedBid(bidSelectedEvent);
  }

}
