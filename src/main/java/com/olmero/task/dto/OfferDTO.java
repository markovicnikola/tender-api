package com.olmero.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferDTO {

  private BigDecimal amount;
  private BidderDTO bidder;
}
