package com.olmero.task.service.impl;

import com.olmero.task.dto.OfferDTO;
import com.olmero.task.mapper.OfferMapper;
import com.olmero.task.repository.OfferRepository;
import com.olmero.task.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

  private OfferRepository offerRepository;

  @Autowired
  public OfferServiceImpl(OfferRepository offerRepository) {
    this.offerRepository = offerRepository;
  }

  @Override
  public List<OfferDTO> getOffersForTender(Long tenderId) {
    return offerRepository.findByTenderId(tenderId)
        .stream()
        .map(OfferMapper::mapToOfferDTO)
        .collect(Collectors.toList());
  }

  @Override
  public List<OfferDTO> getOffersForBidder(Long bidderId) {
    return offerRepository.findByBidderId(bidderId)
        .stream()
        .map(OfferMapper::mapToOfferDTO)
        .collect(Collectors.toList());
  }

  @Override
  public List<OfferDTO> getOffersForBidderAndTender(Long bidderId, Long tenderId) {
    return offerRepository.findByBidderIdAndTenderId(bidderId, tenderId)
        .stream()
        .map(OfferMapper::mapToOfferDTO)
        .collect(Collectors.toList());
  }
}
