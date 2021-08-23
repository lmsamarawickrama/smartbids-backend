package org.saliam.smartbids.item.infrastructure.adapter.event.broker;

import org.saliam.smartbids.item.domain.event.BidSelectedEvent;
import org.saliam.smartbids.item.domain.port.out.ItemEventProducer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class AMQPSender implements ItemEventProducer
{
  private final RabbitTemplate rabbitTemplate;

  private final String exchange;

  private final String routingKey;

  public AMQPSender(RabbitTemplate rabbitTemplate, String exchange, String routingKey)
  {
    this.rabbitTemplate = rabbitTemplate;
    this.exchange = exchange;
    this.routingKey = routingKey;
  }

  @Override
  public void sendBidSelectedEvent(BidSelectedEvent bidSelectedEvent)
  {
    rabbitTemplate.convertAndSend(exchange, routingKey, bidSelectedEvent);
  }
}
