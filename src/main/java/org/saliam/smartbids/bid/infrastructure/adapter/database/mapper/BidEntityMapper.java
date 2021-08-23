package org.saliam.smartbids.bid.infrastructure.adapter.database.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.saliam.smartbids.bid.domain.entity.Bid;
import org.saliam.smartbids.bid.infrastructure.adapter.database.entity.BidEntity;
import org.saliam.smartbids.user.infrastructure.adapter.database.mapper.UserEntityMapper;

@Mapper(uses = { UserEntityMapper.class })
public interface BidEntityMapper
{
  BidEntity bidToBidEntity(Bid bid);

  @Mappings({
      @Mapping(target = "item", ignore = true)
  })
  Bid bidEntityToBid(BidEntity bidEntity);
}
