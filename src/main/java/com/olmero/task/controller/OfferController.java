package com.olmero.task.controller;

import com.olmero.task.dto.OfferDTO;
import com.olmero.task.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OfferController {

  private OfferService offerService;

  @Autowired
  public OfferController(OfferService offerService) {
    this.offerService = offerService;
  }

  @GetMapping("/offers-for-tender/{tenderId}")
  public ResponseEntity<List<OfferDTO>> getOffersForTender(@PathVariable Long tenderId) {
    List<OfferDTO> offers = offerService.getOffersForTender(tenderId);
    return ResponseEntity.ok(offers);
  }

  @GetMapping("/offers-for-bidder/{bidderId}")
  public ResponseEntity<List<OfferDTO>> getOffersForBidder(@PathVariable Long bidderId,
                                                           @RequestParam(name = "tenderId", required = false) Long tenderId) {
    List<OfferDTO> offers = tenderId == null ? offerService.getOffersForBidder(bidderId)
        : offerService.getOffersForBidderAndTender(bidderId, tenderId);
    return ResponseEntity.ok(offers);
  }
}
