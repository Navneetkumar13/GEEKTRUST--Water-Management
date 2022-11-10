package com.geektrust.backend.enitityTest;

import com.geektrust.backend.entity.AptType;
import com.geektrust.backend.exceptions.WaterBillException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ApartmentTypeTest {
    
    @Test
    public void testValidConversion() {
      assertEquals(AptType.TW0_BHK, AptType.fromNumberOfRooms(2));
      assertEquals(AptType.THREE_BHK, AptType.fromNumberOfRooms(3));
    }

    @Test
    public void testInValidConversion() {
      assertThrows(WaterBillException.class, () -> AptType.fromNumberOfRooms(20));
    }
}
