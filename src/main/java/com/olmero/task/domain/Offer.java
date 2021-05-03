package com.olmero.task.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "OFFER")
public class Offer extends BaseEntity {

  @Column(name = "amount")
  private BigDecimal amount;

  @ManyToOne
  @JoinColumn(name = "tender_id")
  private Tender tender;

  @ManyToOne
  @JoinColumn(name = "bidder_id")
  private Bidder bidder;
}
