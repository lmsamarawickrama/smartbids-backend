package org.saliam.smartbids.item.infrastructure.adapter.database.entity;

import lombok.Getter;
import lombok.Setter;
import org.saliam.smartbids.bid.infrastructure.adapter.database.entity.BidEntity;
import org.saliam.smartbids.item.domain.entity.Period;
import org.saliam.smartbids.user.infrastructure.adapter.database.entity.UserEntity;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item")
@Getter @Setter
public class ItemEntity
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String minimumPrize;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private UserEntity owner;

  @Embedded
  private Period duration;

  @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<BidEntity> bids = new ArrayList<>();

  @OneToOne
  @JoinColumn(name = "selectedBid_id")
  private BidEntity selectedBid;

  public void addBid(BidEntity bid)
  {
    bids.add(bid);
    bid.setItem(this);
  }

  public void removeBid(BidEntity bid)
  {
    bids.remove(bid);
    bid.setItem(null);
  }

}
