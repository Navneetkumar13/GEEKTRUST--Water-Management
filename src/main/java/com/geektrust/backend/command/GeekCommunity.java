package com.geektrust.backend.command;

import com.geektrust.backend.exceptions.WaterBillException;

public class GeekCommunity extends BillableCommunity{
    public GeekCommunity(Integer allocatedWaterPerPersonLts,Integer numberOfBillableDaysInMonth){
        super(allocatedWaterPerPersonLts,numberOfBillableDaysInMonth);
    }

    @Override
    public Integer getTotalPeople(){
        if(!isInitialsedBillableCommunity()){
            throw new WaterBillException("Apartement type is not yet defined");
        }
        return getApartmentType().getNumberOfPeople() + getGuests();
    }

    @Override
    public int getTotalWaterConsumedInAMonth(){
        if(!isInitialsedBillableCommunity()){
            throw new WaterBillException("Apartement type is not yet defined");
        }
        return getNumberOfBillableDaysInMonth() * getTotalPeople() * getAllocatedWaterPerPersonLts();
    }
}
