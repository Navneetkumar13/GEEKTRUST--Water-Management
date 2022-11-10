package com.geektrust.backend.command;

import java.util.Objects;
import com.geektrust.backend.entity.AptType;
import com.geektrust.backend.exceptions.WaterBillException;

public abstract class BillableCommunity {
    private final Integer allocatedWaterPerPersonLts;
    private final Integer numberOfBillableDaysInMonth;
    private AptType apartmentType;
    private Integer corporationShare;
    private Integer totalShare;
    private int guests;

    public BillableCommunity(Integer allocatedWaterPerPersonLts,Integer numberOfBillableDaysInMonth){
        if(allocatedWaterPerPersonLts == null){
            throw new NullPointerException();
        }
        if(numberOfBillableDaysInMonth == null){
            throw new NullPointerException();
        }
        this.allocatedWaterPerPersonLts = allocatedWaterPerPersonLts;
        this.numberOfBillableDaysInMonth = numberOfBillableDaysInMonth;
    }

    public Integer getAllocatedWaterPerPersonLts(){
        
        return allocatedWaterPerPersonLts;
    }

    public Integer getNumberOfBillableDaysInMonth(){
        
        return numberOfBillableDaysInMonth;
    }

    // public void setApartmentType(){
    //     this.apartmentType = apartmentType;
    // }

    public AptType getApartmentType(){
        return apartmentType;
    }

    public Integer getCorporationShare(){
        return corporationShare;
    }

    public Integer getTotalShare(){
        return totalShare;
    }

    // public void setGuests(){
    //     this.guests = guests;
    // }

    public int getGuests(){
        return guests;
    }

    public void addGuests(int guests){
        if(!isInitialsedBillableCommunity()){
            throw new WaterBillException("Apartemnt type is not yet defined");
        }
     this.guests += guests;
    }

    public boolean isInitialsedBillableCommunity(){
        return Objects.nonNull(apartmentType) && Objects.nonNull(totalShare) && Objects.nonNull(corporationShare);
    }

    public abstract Integer getTotalPeople();

    public abstract int getTotalWaterConsumedInAMonth();

    public void initializeBillableCommunity(AptType apartmentType,Integer corporationShare,Integer totalShare){
        this.totalShare = totalShare;
        this.apartmentType = apartmentType;
        this.corporationShare = corporationShare;
    }
}
