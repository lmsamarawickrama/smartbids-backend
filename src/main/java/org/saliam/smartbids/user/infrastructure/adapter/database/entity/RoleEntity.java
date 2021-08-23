package org.saliam.smartbids.user.infrastructure.adapter.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@Getter @Setter
public class RoleEntity
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 20)
  @Enumerated(EnumType.STRING)
  private Type type;

  @Column
  private String name;

  public enum Type
  {
    ADMIN, BIDDER, AUCTIONEER
  }
}