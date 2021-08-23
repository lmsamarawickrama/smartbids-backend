package org.saliam.smartbids.item.domain.port.in;

import org.saliam.smartbids.bid.domain.entity.Bid;
import org.saliam.smartbids.item.domain.entity.Item;

import java.util.List;

public interface ItemService
{
  Item save(Item item);

  void selectBid(long id, Bid bid);

  List<Item> getAll();
}
