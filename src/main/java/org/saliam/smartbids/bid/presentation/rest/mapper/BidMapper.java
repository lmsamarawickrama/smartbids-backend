package org.saliam.smartbids.bid.presentation.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.saliam.smartbids.bid.domain.entity.Bid;
import org.saliam.smartbids.bid.presentation.rest.dto.BidCreateDto;
import org.saliam.smartbids.bid.presentation.rest.dto.BidDto;
import org.saliam.smartbids.user.presentation.rest.mapper.UserMapper;

@Mapper(uses = { UserMapper.class })
public interface BidMapper
{
  @Mappings({ @Mapping(target = "bidder.id", source = "bidCreateDto.bidderId"),
      @Mapping(target = "item.id", source = "bidCreateDto.itemId") })
  Bid bidCreateDtoToBid(BidCreateDto bidCreateDto);

  BidDto bidToBidDto(Bid bid);

  Bid bidDtoToBid(BidDto bid);
}
