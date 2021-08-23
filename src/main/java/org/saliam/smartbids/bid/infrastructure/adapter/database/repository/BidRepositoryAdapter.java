package org.saliam.smartbids.bid.infrastructure.adapter.database.repository;

import org.saliam.smartbids.bid.domain.entity.Bid;
import org.saliam.smartbids.bid.domain.port.out.BidRepository;
import org.saliam.smartbids.bid.infrastructure.adapter.database.entity.BidEntity;
import org.saliam.smartbids.bid.infrastructure.adapter.database.mapper.BidEntityMapper;
import org.saliam.smartbids.item.infrastructure.adapter.database.entity.ItemEntity;
import org.saliam.smartbids.user.infrastructure.adapter.database.entity.UserEntity;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class BidRepositoryAdapter implements BidRepository
{
  private final BidEntityRepository bidEntityRepository;

  private final EntityManager entityManager;

  private final BidEntityMapper bidEntityMapper;

  public BidRepositoryAdapter(
      final BidEntityRepository bidEntityRepository, final EntityManager entityManager,
      BidEntityMapper bidEntityMapper)
  {
    this.bidEntityRepository = bidEntityRepository;
    this.entityManager = entityManager;
    this.bidEntityMapper = bidEntityMapper;
  }

  @Override
  public Bid Save(Bid bid)
  {
    BidEntity bidEntity = bidEntityMapper.bidToBidEntity(bid);
    UserEntity userEntity = entityManager.find(UserEntity.class, bidEntity.getBidder().getId());
    ItemEntity itemEntity = entityManager.find(ItemEntity.class, bidEntity.getItem().getId());
    bidEntity.setBidder(userEntity);
    bidEntity.setItem(itemEntity);
    BidEntity savedBid = bidEntityRepository.save(bidEntity);
    return bidEntityMapper.bidEntityToBid(savedBid);
  }

  @Override
  public List<Bid> findByItem(long itemId)
  {
    ItemEntity itemEntity = entityManager.find(ItemEntity.class, itemId);
    List<BidEntity> bidEntitiesByItem = bidEntityRepository.findBidEntitiesByItem(itemEntity);
    return bidEntitiesByItem.stream().map(bidEntityMapper::bidEntityToBid).collect(Collectors.toList());
  }
}
