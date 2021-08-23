package org.saliam.smartbids.item.infrastructure.adapter.database.repository;

import org.saliam.smartbids.bid.domain.entity.Bid;
import org.saliam.smartbids.bid.infrastructure.adapter.database.entity.BidEntity;
import org.saliam.smartbids.bid.infrastructure.adapter.database.repository.BidEntityRepository;
import org.saliam.smartbids.item.domain.entity.Item;
import org.saliam.smartbids.item.domain.port.out.ItemRepository;
import org.saliam.smartbids.item.infrastructure.adapter.database.entity.ItemEntity;
import org.saliam.smartbids.item.infrastructure.adapter.database.mapper.ItemEntityMapper;
import org.saliam.smartbids.user.infrastructure.adapter.database.repository.UserEntityRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ItemRepositoryAdapter implements ItemRepository
{
  private final ItemEntityRepository itemEntityRepository;

  private final UserEntityRepository userEntityRepository;

  private final BidEntityRepository bidEntityRepository;

  private final ItemEntityMapper itemEntityMapper;

  public ItemRepositoryAdapter(
      final ItemEntityRepository itemEntityRepository,
      final UserEntityRepository userEntityRepository,
      final BidEntityRepository bidEntityRepository,
      final ItemEntityMapper itemEntityMapper)
  {
    this.itemEntityRepository = itemEntityRepository;
    this.userEntityRepository = userEntityRepository;
    this.bidEntityRepository = bidEntityRepository;
    this.itemEntityMapper = itemEntityMapper;
  }

  @Override
  public Item save(Item item)
  {
    ItemEntity itemEntity = itemEntityMapper.itemToItemEntity(item);
    itemEntity.setOwner(userEntityRepository.getById(item.getOwner().getId()));
    ItemEntity savedItem = itemEntityRepository.save(itemEntity);
    return itemEntityMapper.itemEntityToItem(savedItem);
  }

  @Override
  public void saveSelectedBid(long id, Bid bid)
  {
    Optional<BidEntity> bidById = bidEntityRepository.findById(Long.valueOf(bid.getId()));
    Optional<ItemEntity> itemById = itemEntityRepository.findById(id);
    if (itemById.isPresent() && bidById.isPresent())
    {
      itemById.get().setSelectedBid(bidById.get());
    }
    else
    {
      throw new IllegalArgumentException("Couldn't set selected bid");
    }

  }

  @Override public List<Item> getAll()
  {
    List<ItemEntity> allItemEntities = itemEntityRepository.findAll();
    return allItemEntities.stream().map(itemEntityMapper::itemEntityToItem).collect(Collectors.toList());
  }
}
