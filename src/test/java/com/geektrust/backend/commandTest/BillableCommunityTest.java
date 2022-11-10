package com.geektrust.backend.commandTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

import com.geektrust.backend.command.BillableCommunity;
import com.geektrust.backend.command.GeekCommunity;
import com.geektrust.backend.entity.AptType;
import com.geektrust.backend.exceptions.WaterBillException;

 class BillableCommunityTest {
    @Mock BillableCommunity community;

  @BeforeEach
  void setUp() {
    community = new GeekCommunity(10, 30);
  }

  @Test
  void testGetTotalWaterConsumedInAMonth() {
    community.initializeBillableCommunity(AptType.TW0_BHK, 1, 5);
    community.addGuests(10);
    community.addGuests(20);
    community.getTotalWaterConsumedInAMonth();
    assertEquals(33 * 300, community.getTotalWaterConsumedInAMonth());
  }

  @Test
  void testInitializeBillableCommunityWithValidValues() {
    community.initializeBillableCommunity(AptType.TW0_BHK, 1, 5);
    assertTrue(community.isInitialsedBillableCommunity());
  }

  @Test
  void testIsInitializedBillableCommunityReturnsFalse() {
    assertFalse(community.isInitialsedBillableCommunity());
  }

  @Test
  void testGetTotalPeopleWhenNotInitialized() {
    assertThrows(WaterBillException.class, () -> community.getTotalPeople());
  }

  @Test
  void testTotalWaterConsumedInAMonthWhenNotInitialized() {
    assertThrows(WaterBillException.class, () -> community.getTotalWaterConsumedInAMonth());
  }

  @Test
  void testGetTotalPeople() {
    community.initializeBillableCommunity(AptType.THREE_BHK, 1, 5);
    community.addGuests(10);
    community.addGuests(20);
    assertEquals(Integer.valueOf(35), community.getTotalPeople());
  }

  @Test
  void testAddGuestsWhenNotInitialized() {
    assertThrows(WaterBillException.class, () -> community.addGuests(10));
  }

  @Test
  void testAddGuests() {
    community.initializeBillableCommunity(AptType.TW0_BHK, 1, 5);
    community.addGuests(10);
    assertEquals(Integer.valueOf(13), community.getTotalPeople());
  }
}
