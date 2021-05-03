package com.olmero.task.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "TENDER")
public class Tender extends BaseEntity {

  @Column(name = "subject")
  private String subject;

  @JoinColumn(name= "date_time")
  private LocalDateTime localDateTime;

  @OneToMany(mappedBy = "tender")
  private Set<Offer> offers;

  @ManyToOne
  @JoinColumn(name = "issuer_id")
  private Issuer issuer;
}
