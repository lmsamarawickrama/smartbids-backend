package org.saliam.smartbids.bid.infrastructure.adapter.database.repository;

import org.saliam.smartbids.bid.infrastructure.adapter.database.entity.BidEntity;
import org.saliam.smartbids.item.infrastructure.adapter.database.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidEntityRepository extends JpaRepository<BidEntity, Long>
{
  List<BidEntity> findBidEntitiesByItem(ItemEntity bidder);
}
