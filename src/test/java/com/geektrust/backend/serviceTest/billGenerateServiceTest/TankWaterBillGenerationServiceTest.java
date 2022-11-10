package com.geektrust.backend.serviceTest.billGenerateServiceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.geektrust.backend.services.billGenerate.TankBillService;

class TankWaterBillGenerationServiceTest {
   
    @Mock TankBillService service;

    @BeforeEach
    void setUp() {
      service = new TankBillService(100, 10, 30);
    }
  
    @Test
    public void testGenerateBill() {
      assertEquals(227500.0, service.generateBill());
    }
    
}
