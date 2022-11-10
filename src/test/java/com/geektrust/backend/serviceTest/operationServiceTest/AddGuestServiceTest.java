package com.geektrust.backend.serviceTest.operationServiceTest;

import com.geektrust.backend.command.GeekCommunity;
import com.geektrust.backend.exceptions.WaterBillException;
import com.geektrust.backend.services.operations.AddGuestService;
import com.geektrust.backend.entity.AptType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class AddGuestServiceTest {
    
    @Mock AddGuestService service;
    @Mock GeekCommunity community;
  
    @BeforeEach
    void setUp() {
      service = AddGuestService.getInstance();
      community = new GeekCommunity(10, 30);
    }
  
    @Test
    public void testAddGuestWhenNotInitialized() {
      assertFalse(community.isInitialsedBillableCommunity());
  
      assertThrows(
          WaterBillException.class,
          () -> service.processOperation(Collections.singletonList("10"), community));
    }
  
    @Test
    public void testAddGuest() {
      community.initializeBillableCommunity(AptType.TW0_BHK, 3, 10);
      service.processOperation(Collections.singletonList("10"), community);
      assertEquals(Integer.valueOf(13), community.getTotalPeople());
    }

}
