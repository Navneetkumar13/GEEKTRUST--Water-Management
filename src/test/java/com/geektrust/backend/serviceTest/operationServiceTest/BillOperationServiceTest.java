package com.geektrust.backend.serviceTest.operationServiceTest;

import com.geektrust.backend.command.GeekCommunity;
import com.geektrust.backend.entity.AptType;
import com.geektrust.backend.services.operations.BillOperationService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BillOperationServiceTest {
    
    @Mock BillOperationService service;
    @Mock GeekCommunity community;
  
    @BeforeEach
    void setUp() {
      service = BillOperationService.getInstance();
      community = new GeekCommunity(10, 30);
      community.initializeBillableCommunity(AptType.TW0_BHK, 3, 10);
    }
  

    @Test
    public void testWithNoGuest() {
      assertEquals("900 1215", service.processOperation(null, community));
    }
  
    @Test
    public void testWithGuest() {
      community.addGuests(10);
      assertEquals("3900 12715", service.processOperation(null, community));
    }
  
    @Test
    public void testWithNoGuestAndRounding() {
      community.initializeBillableCommunity(AptType.TW0_BHK, 1, 3);
      assertEquals("900 1200", service.processOperation(null, community));
    }
  
    @Test
    public void testWithGuestAndRounding() {
      community.addGuests(15);
      community.initializeBillableCommunity(AptType.TW0_BHK, 1, 3);
      assertEquals("5400 24700", service.processOperation(null, community));
    }

}
