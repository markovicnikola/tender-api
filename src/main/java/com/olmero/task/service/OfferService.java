package com.olmero.task.service;

import com.olmero.task.dto.OfferDTO;

import java.util.List;

public interface OfferService {

  List<OfferDTO> getOffersForTender(Long tenderId);

  List<OfferDTO> getOffersForBidder(Long bidderId);

  List<OfferDTO> getOffersForBidderAndTender(Long bidderId, Long tenderId);
}
