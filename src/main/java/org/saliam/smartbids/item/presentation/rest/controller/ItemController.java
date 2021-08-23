package org.saliam.smartbids.item.presentation.rest.controller;

import org.mapstruct.factory.Mappers;
import org.saliam.smartbids.bid.domain.entity.Bid;
import org.saliam.smartbids.bid.presentation.rest.dto.BidDto;
import org.saliam.smartbids.bid.presentation.rest.mapper.BidMapper;
import org.saliam.smartbids.item.application.ItemApplicationService;
import org.saliam.smartbids.item.domain.entity.Item;
import org.saliam.smartbids.item.presentation.rest.dto.ItemCreateDto;
import org.saliam.smartbids.item.presentation.rest.dto.ItemDto;
import org.saliam.smartbids.item.presentation.rest.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/smartbids/api/item")
public class ItemController
{
  private final ItemMapper itemMapper = Mappers.getMapper(ItemMapper.class);

  private ItemApplicationService itemApplicationService;

  @Autowired
  public void setItemApplicationService(ItemApplicationService itemApplicationService)
  {
    this.itemApplicationService = itemApplicationService;
  }

  @PostMapping
  public ItemDto itemDto(@RequestBody ItemCreateDto itemCreateDto)
  {
    Item item = itemMapper.itemCreateDtoToItem(itemCreateDto);
    Item savedItem = itemApplicationService.save(item);
    return itemMapper.itemToItemDto(savedItem);
  }

  @GetMapping
  public List<ItemDto> getAll()
  {
    List<Item> allItems = itemApplicationService.getAll();
    return allItems.stream().map(itemMapper::itemToItemDto).collect(Collectors.toList());
  }

  @PostMapping(value = "/{id}/selectBid")
  public void selectBid(@RequestBody BidDto bidDto, @PathVariable(name = "id") long id)
  {
    BidMapper bidMapper = Mappers.getMapper(BidMapper.class);
    Bid bid = bidMapper.bidDtoToBid(bidDto);
    itemApplicationService.selectBid(id, bid);
  }
}
