package org.saliam.smartbids.user.infrastructure.adapter.database.entity;

import lombok.Getter;
import lombok.Setter;
import org.saliam.smartbids.bid.infrastructure.adapter.database.entity.BidEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
    @UniqueConstraint(columnNames = "email") })
@Getter @Setter
public class UserEntity
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;

  private String email;

  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_to_role", joinColumns = @JoinColumn(name = "userEntity_id"), inverseJoinColumns = @JoinColumn(name = "roleEntity_id"))
  private Set<RoleEntity> roles = new HashSet<>();

  @OneToMany(mappedBy = "bidder", orphanRemoval = true)
  private List<BidEntity> bids = new ArrayList<>();

  public void addBid(BidEntity bid)
  {
    bids.add(bid);
    bid.setBidder(this);
  }

  public void removeBid(BidEntity bid)
  {
    bids.remove(bid);
    bid.setBidder(null);
  }
}