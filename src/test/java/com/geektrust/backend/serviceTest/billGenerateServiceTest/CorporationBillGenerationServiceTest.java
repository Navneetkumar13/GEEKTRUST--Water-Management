package com.geektrust.backend.serviceTest.billGenerateServiceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.geektrust.backend.services.billGenerate.CorporationBillService;

class CorporationBillGenerationServiceTest {
    
    @Mock CorporationBillService service;

    @BeforeEach
    void setUp() {
      service = new CorporationBillService(10, 10, 30, 0.10);
    }
  
    @Test
    public void testGenerateBill() {
      assertEquals(300.0, service.generateBill());
    }
    
}
