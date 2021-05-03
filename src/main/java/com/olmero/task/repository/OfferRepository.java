package com.olmero.task.repository;

import com.olmero.task.domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

  List<Offer> findByTender(Long tenderId);

  List<Offer> findByBidder(Long bidderId);

  List<Offer> findByBidderAndTender(Long bidderId, Long tenderId);
}
