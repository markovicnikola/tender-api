package com.olmero.task.unit;

import com.olmero.task.domain.Issuer;
import com.olmero.task.domain.Tender;
import com.olmero.task.dto.TenderDTO;
import com.olmero.task.repository.TenderRepository;
import com.olmero.task.service.TenderService;
import com.olmero.task.service.impl.TenderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class TenderServiceTest {

  private TenderService tenderService;
  private TenderRepository tenderRepository;

  @BeforeEach
  public void setUp() {
    tenderRepository = Mockito.mock(TenderRepository.class);
    tenderService = new TenderServiceImpl(tenderRepository);
  }

  @Test
  public void testGetTendersForIssuer() {

    Mockito.when(tenderRepository.findByIssuerId(Mockito.anyLong())).thenReturn(createTenders());

    List<TenderDTO> tendersForIssuer = tenderService.getTendersForIssuer(1L);
    Assertions.assertNotNull(tendersForIssuer);
    Assertions.assertEquals(3, tendersForIssuer.size());
    TenderDTO tenderDTO1 = tendersForIssuer.get(0);
    Assertions.assertNotNull(tenderDTO1);
    Assertions.assertEquals("Subject1", tenderDTO1.getSubject());
    TenderDTO tenderDTO2 = tendersForIssuer.get(1);
    Assertions.assertNotNull(tenderDTO2);
    Assertions.assertEquals("Subject2", tenderDTO2.getSubject());
    TenderDTO tenderDTO3 = tendersForIssuer.get(2);
    Assertions.assertNotNull(tenderDTO3);
    Assertions.assertEquals("Subject3", tenderDTO3.getSubject());
  }

  private List<Tender> createTenders() {

    Issuer issuer = new Issuer();
    issuer.setId(1L);
    issuer.setEmail("test@test");
    issuer.setName("Test");
    Tender tender1 = new Tender();
    tender1.setSubject("Subject1");
    tender1.setLocalDateTime(LocalDateTime.now());
    tender1.setIssuer(issuer);
    Tender tender2 = new Tender();
    tender2.setSubject("Subject2");
    tender2.setLocalDateTime(LocalDateTime.now());
    tender2.setIssuer(issuer);
    Tender tender3 = new Tender();
    tender3.setSubject("Subject3");
    tender3.setLocalDateTime(LocalDateTime.now());
    tender3.setIssuer(issuer);

    return Arrays.asList(tender1, tender2, tender3);
  }
}
