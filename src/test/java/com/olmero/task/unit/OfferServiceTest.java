package com.olmero.task.unit;

import com.olmero.task.domain.Bidder;
import com.olmero.task.domain.Offer;
import com.olmero.task.domain.Tender;
import com.olmero.task.dto.OfferDTO;
import com.olmero.task.repository.OfferRepository;
import com.olmero.task.service.OfferService;
import com.olmero.task.service.impl.OfferServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class OfferServiceTest {

  private OfferService offerService;
  private OfferRepository offerRepository;

  @BeforeEach
  public void setUp() {
    offerRepository = Mockito.mock(OfferRepository.class);
    offerService = new OfferServiceImpl(offerRepository);
  }

  @Test
  public void testGetOffersForTender() {
    Mockito.when(offerRepository.findByTenderId(Mockito.anyLong())).thenReturn(createOffers());

    List<OfferDTO> offersForTender = offerService.getOffersForTender(1L);
    Assertions.assertNotNull(offersForTender);
    Assertions.assertEquals(3, offersForTender.size());
    OfferDTO offerDTO1 = offersForTender.get(0);
    Assertions.assertNotNull(offerDTO1);
    Assertions.assertEquals(BigDecimal.TEN, offerDTO1.getAmount());
    OfferDTO offerDTO2 = offersForTender.get(1);
    Assertions.assertNotNull(offerDTO2);
    Assertions.assertEquals(BigDecimal.valueOf(20), offerDTO2.getAmount());
    OfferDTO offerDTO3 = offersForTender.get(2);
    Assertions.assertNotNull(offerDTO3);
    Assertions.assertEquals(BigDecimal.valueOf(30), offerDTO3.getAmount());
  }

  @Test
  public void testGetOffersForBidder() {
    Mockito.when(offerRepository.findByBidderId(Mockito.anyLong())).thenReturn(createOffers());

    List<OfferDTO> offersForTender = offerService.getOffersForBidder(1L);
    Assertions.assertNotNull(offersForTender);
    Assertions.assertEquals(3, offersForTender.size());
    OfferDTO offerDTO1 = offersForTender.get(0);
    Assertions.assertNotNull(offerDTO1);
    Assertions.assertEquals(BigDecimal.TEN, offerDTO1.getAmount());
    OfferDTO offerDTO2 = offersForTender.get(1);
    Assertions.assertNotNull(offerDTO2);
    Assertions.assertEquals(BigDecimal.valueOf(20), offerDTO2.getAmount());
    OfferDTO offerDTO3 = offersForTender.get(2);
    Assertions.assertNotNull(offerDTO3);
    Assertions.assertEquals(BigDecimal.valueOf(30), offerDTO3.getAmount());
  }

  @Test
  public void testGetOffersForBidderAndTender() {
    Mockito.when(offerRepository.findByBidderIdAndTenderId(Mockito.anyLong(), Mockito.anyLong())).thenReturn(createOffers());

    List<OfferDTO> offersForTender = offerService.getOffersForBidderAndTender(1L, 1L);
    Assertions.assertNotNull(offersForTender);
    Assertions.assertEquals(3, offersForTender.size());
    OfferDTO offerDTO1 = offersForTender.get(0);
    Assertions.assertNotNull(offerDTO1);
    Assertions.assertEquals(BigDecimal.TEN, offerDTO1.getAmount());
    OfferDTO offerDTO2 = offersForTender.get(1);
    Assertions.assertNotNull(offerDTO2);
    Assertions.assertEquals(BigDecimal.valueOf(20), offerDTO2.getAmount());
    OfferDTO offerDTO3 = offersForTender.get(2);
    Assertions.assertNotNull(offerDTO3);
    Assertions.assertEquals(BigDecimal.valueOf(30), offerDTO3.getAmount());
  }

  private List<Offer> createOffers() {
    Tender tender = new Tender();
    tender.setSubject("subject");
    tender.setId(1L);
    tender.setLocalDateTime(LocalDateTime.now());
    Bidder bidder = new Bidder();
    bidder.setId(1L);
    bidder.setEmail("test@test");
    bidder.setName("Test");
    Offer offer1 = new Offer();
    offer1.setAmount(BigDecimal.TEN);
    offer1.setBidder(bidder);
    offer1.setTender(tender);
    Offer offer2 = new Offer();
    offer2.setAmount(BigDecimal.valueOf(20));
    offer2.setBidder(bidder);
    offer2.setTender(tender);
    Offer offer3 = new Offer();
    offer3.setAmount(BigDecimal.valueOf(30));
    offer3.setBidder(bidder);
    offer3.setTender(tender);

    return Arrays.asList(offer1, offer2, offer3);
  }
}
