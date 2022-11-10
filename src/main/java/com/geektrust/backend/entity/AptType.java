package com.geektrust.backend.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import com.geektrust.backend.exceptions.WaterBillException;
import java.util.Arrays;
import java.util.Optional;

public enum AptType {
    TW0_BHK(2,3),
    THREE_BHK(3,5);

    private AptType(Integer numberOfRooms,Integer numberOfPeople){
        if(numberOfPeople == null){
            throw new NullPointerException();
        }
        if(numberOfRooms == null){
            throw new NullPointerException();
        }
        this.numberOfRooms = numberOfRooms;
        this.numberOfPeople = numberOfPeople;
    }

    private static Map<Integer, AptType> lookup = new HashMap<>();

  static {
    lookup =
        Arrays.stream(AptType.values())
            .collect(Collectors.toMap(AptType::getNumberOfRooms, Function.identity()));
  }

  public static AptType fromNumberOfRooms(int rooms) throws WaterBillException {
    return Optional.ofNullable(lookup.get(rooms)).orElseThrow(() -> new WaterBillException(WaterBillException.INVALID_COMMAND));
  }

    private Integer numberOfPeople;
    private Integer numberOfRooms;

    public Integer getNumberOfPeople(){
        return numberOfPeople;
    }
    public Integer getNumberOfRooms(){
        return numberOfRooms;
    }
}
