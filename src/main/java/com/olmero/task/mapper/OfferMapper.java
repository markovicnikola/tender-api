package com.olmero.task.mapper;

import com.olmero.task.domain.Offer;
import com.olmero.task.dto.OfferDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OfferMapper {

  public OfferDTO mapToOfferDTO(Offer offer) {
    return new OfferDTO(offer.getAmount(), BidderMapper.mapToBidderDto(offer.getBidder()));
  }
}
