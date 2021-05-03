package com.olmero.task.service.impl;

import com.olmero.task.dto.TenderDTO;
import com.olmero.task.mapper.TenderMapper;
import com.olmero.task.repository.TenderRepository;
import com.olmero.task.service.TenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TenderServiceImpl implements TenderService {

  private TenderRepository tenderRepository;

  @Autowired
  public TenderServiceImpl(TenderRepository tenderRepository) {
    this.tenderRepository = tenderRepository;
  }

  @Override
  public List<TenderDTO> getTendersForIssuer(Long issuerId) {

    return tenderRepository.findByIssuer(issuerId)
        .stream()
        .map(TenderMapper::mapToTenderDto)
        .collect(Collectors.toList());
  }
}
