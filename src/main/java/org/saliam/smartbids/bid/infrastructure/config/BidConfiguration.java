package org.saliam.smartbids.bid.infrastructure.config;

import org.mapstruct.factory.Mappers;
import org.saliam.smartbids.bid.application.BidApplicationService;
import org.saliam.smartbids.bid.domain.port.in.BidService;
import org.saliam.smartbids.bid.domain.port.out.BidRepository;
import org.saliam.smartbids.bid.domain.service.BidServiceImpl;
import org.saliam.smartbids.bid.infrastructure.adapter.database.mapper.BidEntityMapper;
import org.saliam.smartbids.bid.infrastructure.adapter.database.repository.BidEntityRepository;
import org.saliam.smartbids.bid.infrastructure.adapter.database.repository.BidRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class BidConfiguration
{
  @PersistenceContext
  private EntityManager entityManager;


  @Bean
  public BidService getBidService(BidRepository bidRepository)
  {
    return new BidServiceImpl(bidRepository);
  }

  @Bean
  public BidRepository getBidRepository(BidEntityRepository bidEntityRepository)
  {
    return new BidRepositoryAdapter(bidEntityRepository, entityManager, Mappers.getMapper(BidEntityMapper.class));
  }

  @Bean
  public BidApplicationService bidApplicationService(BidService bidService)
  {
    return new BidApplicationService(bidService);
  }
}
