package com.geektrust.backend.serviceTest.operationServiceTest;

import com.geektrust.backend.command.GeekCommunity;
import com.geektrust.backend.services.operations.AllotWaterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AllotWaterServiceTest {
    
    @Mock AllotWaterService service;
    @Mock GeekCommunity community;
  
    @BeforeEach
    void setUp() {
      service = AllotWaterService.getInstance();
      community = new GeekCommunity(10, 30);
    }
  
    @Test
    public void testAllotWater() {
      assertFalse(community.isInitialsedBillableCommunity());
      service.processOperation(Arrays.asList("2", "1:3"), community);
      assertEquals(Integer.valueOf(3), community.getTotalPeople());
      assertTrue(community.isInitialsedBillableCommunity());
    }

}
