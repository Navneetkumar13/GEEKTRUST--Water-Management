package com.geektrust.backend.commandTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import com.geektrust.backend.command.Commands;
import com.geektrust.backend.entity.Operators;

 class CommandTest {
    
    @Mock Commands command;

  @BeforeEach
  void setUp() {
    command = Mockito.mock(Commands.class);
  }

  @Test
  void testFromWithValidInput() {
    String input = "ALLOT_WATER 3 1:5";
    Commands command = Commands.from(input);
    assertEquals(Operators.ALLOT_WATER, command.getOperator());
    assertEquals(Arrays.asList("3", "1:5"), command.getOperands());
    input = "ADD_GUESTS 10";
    command = Commands.from(input);
    assertEquals(Operators.ADD_GUESTS, command.getOperator());
    assertEquals(Collections.singletonList("10"), command.getOperands());
    input = "BILL";
    command = Commands.from(input);
    assertEquals(Operators.BILL, command.getOperator());
    assertEquals(Collections.emptyList(), command.getOperands());
  }

  @Test
  void testFromWithValidArgumentCardinality() {
    final String input = "ALLOT_WATER 3 1:5";
    assertDoesNotThrow(() -> Commands.from(input));
    final String anotherInput = "ADD_GUESTS 5";
    assertDoesNotThrow(() -> Commands.from(anotherInput));
  }

  @Test
  void testFromWithInValidOperation() {
    final String input = "ADD_GUESTS 10 2";
    assertThrows(UnsupportedOperationException.class, () -> Commands.from(input));
    final String anotherInput = "ALLOT_WATER 3";
    assertThrows(UnsupportedOperationException.class, () -> Commands.from(anotherInput));
  }

  @Test
  void testConstructorWithNullValues() {
    assertThrows(NullPointerException.class, () -> new Commands(Operators.ALLOT_WATER, null));
     assertThrows(NullPointerException.class, () -> new Commands(null, new ArrayList<>()));
     assertThrows(NullPointerException.class, () -> new Commands(null, null));
  }
}
