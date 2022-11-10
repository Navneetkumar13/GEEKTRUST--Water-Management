package com.geektrust.backend.services.billGenerate;

//Corporation Bill Generation class extending BaseBillGeneration Class to generate bill

public class CorporationBillService extends BaseBillGenerationService{
    public CorporationBillService(int people, int lts, int days, double ratio) {
        super(people, lts, days, ratio);
    
      }
    
      @Override
      protected void updateBillRateUptoMax() {
        getBillRateUptoMax().put(Integer.MAX_VALUE, 1.0);
      }
}
