package com.olmero.task.service;

import com.olmero.task.dto.TenderDTO;

import java.util.List;

public interface TenderService {

  List<TenderDTO> getTendersForIssuer(Long issuerId);
}
