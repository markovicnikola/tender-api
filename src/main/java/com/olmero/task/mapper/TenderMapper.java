package com.olmero.task.mapper;

import com.olmero.task.domain.Tender;
import com.olmero.task.dto.TenderDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TenderMapper {

  public TenderDTO mapToTenderDto(Tender tender) {
    return new TenderDTO(tender.getSubject(), tender.getLocalDateTime());
  }
}
