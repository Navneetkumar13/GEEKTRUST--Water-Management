package com.geektrust.backend.services.billGenerate;

// BoreWell Water Bill Generation class extending BaseBillGeneration Class to generate bill

public class BoreWellBillService extends BaseBillGenerationService{
    
    public BoreWellBillService(int people, int lts, int days, double ratio){
        super(people, lts, days, ratio);
    }

    @Override
    protected void updateBillRateUptoMax() {
      getBillRateUptoMax().put(Integer.MAX_VALUE, 1.5);
  }
}
