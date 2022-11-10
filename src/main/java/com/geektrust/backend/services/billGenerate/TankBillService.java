package com.geektrust.backend.services.billGenerate;

//Tank Water Bill Generation class extending BaseBillGeneration Class to generate bill

public class TankBillService extends BaseBillGenerationService{
    
  public TankBillService(int people, int lts, int days) {
    super(people, lts, days, 1);
  }

  @Override
  protected void updateBillRateUptoMax() {
    getBillRateUptoMax().put(500, 2.0);
    getBillRateUptoMax().put(1500, 3.0);
    getBillRateUptoMax().put(3000, 5.0);
    getBillRateUptoMax().put(Integer.MAX_VALUE, 8.0);
  }
}
