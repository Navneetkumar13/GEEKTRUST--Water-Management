package com.geektrust.backend.services.operations;

import java.util.List;
import com.geektrust.backend.command.BillableCommunity;
import com.geektrust.backend.entity.AptType;
import com.geektrust.backend.exceptions.WaterBillException;

public class AllotWaterService implements OperationService{

    private static final AllotWaterService instance = new AllotWaterService();

    public static AllotWaterService getInstance(){
        return instance;
    }

    private AllotWaterService() {}

    @Override
    public String processOperation(List<String> arguments, BillableCommunity community) throws WaterBillException{
        int numberOfRooms = Integer.parseInt(arguments.get(0));
        String[] split = arguments.get(1).split(":");

        community.initializeBillableCommunity(AptType.fromNumberOfRooms(numberOfRooms), Integer.parseInt(split[0]), (Integer.parseInt(split[0]) + Integer.parseInt(split[1])));

        return null;
    }

}
