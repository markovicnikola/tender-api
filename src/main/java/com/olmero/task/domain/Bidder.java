package com.olmero.task.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Table(name = "BIDDER")
public class Bidder extends BaseEntity {

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @OneToMany(mappedBy = "bidder")
  private Set<Offer> offers;
}
