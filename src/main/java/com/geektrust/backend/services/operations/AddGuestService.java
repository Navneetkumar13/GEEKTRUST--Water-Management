package com.geektrust.backend.services.operations;

import java.util.List;
import com.geektrust.backend.command.BillableCommunity;
import com.geektrust.backend.exceptions.WaterBillException;

public class AddGuestService implements OperationService{
    private static final AddGuestService instance = new AddGuestService();

    public static AddGuestService getInstance(){
        return instance;
    }

    private AddGuestService() {}

    @Override
    public String processOperation(List<String> arguments, BillableCommunity community) throws WaterBillException {
        int guests = Integer.parseInt(arguments.get(0));
        if(!community.isInitialsedBillableCommunity()){
            throw new WaterBillException("Add Apartment before adding guests");
        }
        community.addGuests(guests);
        return null;
    }
}
