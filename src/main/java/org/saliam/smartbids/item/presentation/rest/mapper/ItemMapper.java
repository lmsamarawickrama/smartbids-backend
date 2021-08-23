package org.saliam.smartbids.item.presentation.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.saliam.smartbids.bid.presentation.rest.mapper.BidMapper;
import org.saliam.smartbids.item.domain.entity.Item;
import org.saliam.smartbids.item.presentation.rest.dto.ItemCreateDto;
import org.saliam.smartbids.item.presentation.rest.dto.ItemDto;
import org.saliam.smartbids.user.presentation.rest.mapper.UserMapper;

@Mapper(uses = {UserMapper.class, BidMapper.class })
public interface ItemMapper
{
  @Mappings({@Mapping(target="owner.id", source="itemCreateDto.ownerId"),})
  Item itemCreateDtoToItem(ItemCreateDto itemCreateDto);

  ItemDto itemToItemDto(Item item);
}
