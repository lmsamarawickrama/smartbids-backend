package org.saliam.smartbids.bid.presentation.rest.controller;

import org.mapstruct.factory.Mappers;
import org.saliam.smartbids.bid.application.BidApplicationService;
import org.saliam.smartbids.bid.domain.entity.Bid;
import org.saliam.smartbids.bid.presentation.rest.dto.BidCreateDto;
import org.saliam.smartbids.bid.presentation.rest.dto.BidDto;
import org.saliam.smartbids.bid.presentation.rest.mapper.BidMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/smartbids/api/bid")
public class BidController
{
  private BidApplicationService bidApplicationService;

  @Autowired
  public void setBidApplicationService(BidApplicationService bidApplicationService)
  {
    this.bidApplicationService = bidApplicationService;
  }

  @PostMapping
  public BidDto itemDto(@RequestBody @Valid BidCreateDto bidCreateDto)
  {
    BidMapper bidMapper = Mappers.getMapper(BidMapper.class);
    Bid bid = bidMapper.bidCreateDtoToBid(bidCreateDto);
    Bid savedBid = bidApplicationService.save(bid);
    return bidMapper.bidToBidDto(savedBid);
  }

  @GetMapping(value = "/findByItem/{itemId}")
  public List<BidDto> findByItem(@PathVariable(name = "itemId") long itemId)
  {
    BidMapper bidMapper = Mappers.getMapper(BidMapper.class);
    List<Bid> bidsByItem = bidApplicationService.findByItem(itemId);
    return bidsByItem.stream().map(bidMapper::bidToBidDto).collect(Collectors.toList());
  }
}
