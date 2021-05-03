package com.olmero.task.repository;

import com.olmero.task.domain.Tender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenderRepository extends JpaRepository<Tender, Long> {

  List<Tender> findByIssuerId(Long issuerId);
}
