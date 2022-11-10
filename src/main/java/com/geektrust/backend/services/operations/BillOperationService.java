package com.geektrust.backend.services.operations;

import java.util.List;
import java.util.StringJoiner;
import com.geektrust.backend.command.BillableCommunity;
import com.geektrust.backend.services.billGenerate.CorporationBillService;
import com.geektrust.backend.services.billGenerate.BoreWellBillService;
import com.geektrust.backend.services.billGenerate.TankBillService;

public class BillOperationService implements OperationService{
    private static final BillOperationService instance = new BillOperationService();

    public static BillOperationService getInstance(){
        return instance;
    }

    private BillOperationService() {}

    @Override
    public String processOperation(List<String> arguments, BillableCommunity community){
        StringJoiner bill = new StringJoiner(" ");
        bill.add(Integer.toString(community.getTotalWaterConsumedInAMonth()));
        double billValue = 0.0;

        billValue += new TankBillService(community.getGuests(), community.getAllocatedWaterPerPersonLts(), community.getNumberOfBillableDaysInMonth()).generateBill();

        billValue += new CorporationBillService(community.getApartmentType().getNumberOfPeople(), community.getAllocatedWaterPerPersonLts(), community.getNumberOfBillableDaysInMonth(), 1.0 * community.getCorporationShare() / community.getTotalShare()).generateBill();

        billValue += new BoreWellBillService(community.getApartmentType().getNumberOfPeople(), community.getAllocatedWaterPerPersonLts(), community.getNumberOfBillableDaysInMonth(), 1.0 * (community.getTotalShare() - community.getCorporationShare()) / community.getTotalShare()).generateBill();

        bill.add(Integer.toString((int) Math.ceil(billValue)));
        
        return bill.toString();
    }
}
