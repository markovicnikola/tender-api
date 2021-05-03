package com.olmero.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TenderDTO {

  private String subject;
  private LocalDateTime localDateTime;

}
