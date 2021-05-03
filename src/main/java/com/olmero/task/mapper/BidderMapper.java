package com.olmero.task.mapper;

import com.olmero.task.domain.Bidder;
import com.olmero.task.dto.BidderDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BidderMapper {

  public BidderDTO mapToBidderDto(Bidder bidder) {
    return new BidderDTO(bidder.getName(), bidder.getEmail());
  }
}
