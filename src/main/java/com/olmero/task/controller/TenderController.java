package com.olmero.task.controller;

import com.olmero.task.dto.TenderDTO;
import com.olmero.task.service.TenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TenderController {

  private TenderService tenderService;

  @Autowired
  public TenderController(TenderService tenderService) {
    this.tenderService = tenderService;
  }

  @GetMapping("/tenders/{issuerId}")
  public ResponseEntity<List<TenderDTO>> getTendersForIssuer(@PathVariable Long issuerId) {
    List<TenderDTO> tenders = tenderService.getTendersForIssuer(issuerId);
    return ResponseEntity.ok(tenders);
  }
}
