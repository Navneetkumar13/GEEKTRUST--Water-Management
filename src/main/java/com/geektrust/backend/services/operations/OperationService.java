package com.geektrust.backend.services.operations;

import java.util.List;
import com.geektrust.backend.command.BillableCommunity;
import com.geektrust.backend.exceptions.WaterBillException;

public interface OperationService {
    String processOperation(List<String> arguments,BillableCommunity community) throws WaterBillException;
}
