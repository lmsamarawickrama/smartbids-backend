package org.saliam.smartbids.item.infrastructure.config;

import org.mapstruct.factory.Mappers;
import org.saliam.smartbids.bid.infrastructure.adapter.database.repository.BidEntityRepository;
import org.saliam.smartbids.item.domain.event.BidSelectedEventFactory;
import org.saliam.smartbids.item.domain.port.in.ItemService;
import org.saliam.smartbids.item.domain.port.out.ItemEventProducer;
import org.saliam.smartbids.item.domain.port.out.ItemRepository;
import org.saliam.smartbids.item.domain.service.ItemServiceImpl;
import org.saliam.smartbids.item.infrastructure.adapter.database.mapper.ItemEntityMapper;
import org.saliam.smartbids.item.infrastructure.adapter.database.repository.ItemEntityRepository;
import org.saliam.smartbids.item.infrastructure.adapter.database.repository.ItemRepositoryAdapter;
import org.saliam.smartbids.item.infrastructure.adapter.event.BidSelectedEventFactoryImpl;
import org.saliam.smartbids.item.infrastructure.adapter.event.broker.AMQPSender;
import org.saliam.smartbids.user.infrastructure.adapter.database.repository.UserEntityRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemConfiguration
{
  @Bean
  public ItemService itemService(ItemRepository itemRepository, ItemEventProducer itemEventProducer,
                                 BidSelectedEventFactory bidSelectedEventFactory)
  {
    return new ItemServiceImpl(itemRepository, itemEventProducer, bidSelectedEventFactory);
  }

  @Bean
  public ItemRepository itemRepository(ItemEntityRepository itemEntityRepository,
                                       final BidEntityRepository bidEntityRepository,
                                       UserEntityRepository userEntityRepository)
  {
    return new ItemRepositoryAdapter(itemEntityRepository, userEntityRepository,
        bidEntityRepository, Mappers.getMapper(ItemEntityMapper.class));
  }

  @Bean
  public BidSelectedEventFactory getBidSelectedEventFactory(BidEntityRepository bidRepository)
  {
    return new BidSelectedEventFactoryImpl(bidRepository);
  }

  @Bean
  public ItemEventProducer getItemEventProducer(RabbitTemplate rabbitTemplate,
                                                @Value("${smartbids.rabbitmq.routingkey}") String routingKey,
                                                @Value("${smartbids.rabbitmq.exchange}") String exchange)
  {
    return new AMQPSender(rabbitTemplate, exchange, routingKey);
  }
}
