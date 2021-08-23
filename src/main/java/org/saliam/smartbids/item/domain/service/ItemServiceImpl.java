package org.saliam.smartbids.item.domain.service;

import org.saliam.smartbids.bid.domain.entity.Bid;
import org.saliam.smartbids.item.domain.entity.Item;
import org.saliam.smartbids.item.domain.event.BidSelectedEvent;
import org.saliam.smartbids.item.domain.event.BidSelectedEventFactory;
import org.saliam.smartbids.item.domain.port.in.ItemService;
import org.saliam.smartbids.item.domain.port.out.ItemEventProducer;
import org.saliam.smartbids.item.domain.port.out.ItemRepository;

import javax.validation.Valid;
import java.util.List;

public class ItemServiceImpl implements ItemService
{
  private final ItemRepository itemRepository;

  private final ItemEventProducer itemEventProducer;

  private final BidSelectedEventFactory bidSelectedEventFactory;

  public ItemServiceImpl(final ItemRepository itemRepository,
                         final ItemEventProducer itemEventProducer,
                         final BidSelectedEventFactory bidSelectedEventFactory)
  {
    this.itemRepository = itemRepository;
    this.itemEventProducer = itemEventProducer;
    this.bidSelectedEventFactory = bidSelectedEventFactory;
  }

  @Override
  public Item save(@Valid Item item)
  {
    return itemRepository.save(item);
  }

  @Override
  public void selectBid(long id, Bid bid)
  {
    itemRepository.saveSelectedBid(id, bid);
    BidSelectedEvent bidSelectedEvent = bidSelectedEventFactory.create(bid.getId());
    itemEventProducer.sendBidSelectedEvent(bidSelectedEvent);
  }

  @Override
  public List<Item> getAll()
  {
    return itemRepository.getAll();
  }
}
