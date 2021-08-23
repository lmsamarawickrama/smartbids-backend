package org.saliam.smartbids.item.infrastructure.adapter.database.mapper;

import org.mapstruct.Mapper;
import org.saliam.smartbids.bid.infrastructure.adapter.database.mapper.BidEntityMapper;
import org.saliam.smartbids.item.domain.entity.Item;
import org.saliam.smartbids.item.infrastructure.adapter.database.entity.ItemEntity;
import org.saliam.smartbids.user.infrastructure.adapter.database.mapper.UserEntityMapper;

@Mapper(uses = {UserEntityMapper.class, BidEntityMapper.class})
public interface ItemEntityMapper
{
  Item itemEntityToItem(ItemEntity itemEntity);

  ItemEntity itemToItemEntity(Item item);
}
