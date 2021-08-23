package org.saliam.smartbids.item.domain.port.out;

import org.saliam.smartbids.bid.domain.entity.Bid;
import org.saliam.smartbids.item.domain.entity.Item;

import java.util.List;

public interface ItemRepository
{
  Item save(Item item);

  void saveSelectedBid(long id, Bid bid);

  List<Item> getAll();
}
