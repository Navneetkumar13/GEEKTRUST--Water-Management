package com.geektrust.backend.serviceTest.billGenerateServiceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.geektrust.backend.services.billGenerate.BoreWellBillService;

class BoreWellBillGenerationServiceTest {
    
    @Mock BoreWellBillService service;

    @BeforeEach
    void setUp() {
      service = new BoreWellBillService(10, 10, 30, 1);
    }
  
    @Test
    public void testGenerateBill() {
      assertEquals(4500.0, service.generateBill());
    }
}
