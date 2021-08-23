package org.saliam.smartbids.item.application;

import org.saliam.smartbids.bid.domain.entity.Bid;
import org.saliam.smartbids.item.domain.entity.Item;
import org.saliam.smartbids.item.domain.port.in.ItemService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ItemApplicationService
{
  private final ItemService itemService;

  public ItemApplicationService(ItemService itemService)
  {
    this.itemService = itemService;
  }

  @Transactional
  public Item save(Item item)
  {
    return itemService.save(item);
  }

  @Transactional
  public void selectBid(long id, Bid bid)
  {
    itemService.selectBid(id, bid);
  }

  public List<Item> getAll()
  {
    return itemService.getAll();
  }
}
