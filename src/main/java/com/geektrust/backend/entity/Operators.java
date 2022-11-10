package com.geektrust.backend.entity;

import java.util.function.Supplier;
import com.geektrust.backend.services.operations.AddGuestService;
import com.geektrust.backend.services.operations.AllotWaterService;
import com.geektrust.backend.services.operations.BillOperationService;
import com.geektrust.backend.services.operations.OperationService;

public enum Operators {

    ALLOT_WATER(2,AllotWaterService::getInstance),
    ADD_GUESTS(1, AddGuestService::getInstance),
    BILL(0, BillOperationService::getInstance);



     private Operators(Integer numberOfArguments,Supplier<? extends OperationService> operationService){
        if(operationService == null){
            throw new NullPointerException();
        }
          this.numberOfArguments = numberOfArguments;
         this.operationService = operationService;
     }
    
    private Integer numberOfArguments;
    private Supplier<? extends OperationService> operationService;


    public Integer getNumberOfArguments(){
        if(numberOfArguments == null){
            throw new NullPointerException();
        }
        return numberOfArguments;
    }

    public Supplier<? extends OperationService> getOperationService(){
        return operationService;
    }
}

