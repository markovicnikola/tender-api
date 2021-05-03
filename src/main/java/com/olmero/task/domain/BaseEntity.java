package com.olmero.task.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

  @Column(name = "id")
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
}
