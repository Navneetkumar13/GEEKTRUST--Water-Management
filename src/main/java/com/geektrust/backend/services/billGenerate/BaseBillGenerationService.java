package com.geektrust.backend.services.billGenerate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Base Class of bill Generation

public abstract class BaseBillGenerationService {
    
    private final int days;
    private final int people;
    private final int lts;
    private final double ratio;
    private final Map<Integer, Double> billRateUptoMax;

    public BaseBillGenerationService(int people, int lts, int days, double ratio) {
        this.billRateUptoMax = new HashMap<>();
        this.people = people;
        this.lts = lts;
        this.days = days;
        this.ratio = ratio;
        updateBillRateUptoMax();
      }

      protected abstract void updateBillRateUptoMax();
    
      public Map<Integer, Double> getBillRateUptoMax(){
        return billRateUptoMax;
      }

      public double generateBill(){
        double totalConsumption = people * lts * days * ratio;
        List<Integer> slabs = billRateUptoMax.keySet().stream().sorted().collect(Collectors.toList());
        double bill = 0;
        
        int prevSlabLimit = 0;
        for (int slab: slabs){
            int slabDiff = slab - prevSlabLimit;
            double slabRate = billRateUptoMax.get(slab);
            if(totalConsumption < slabDiff){
              bill += totalConsumption * slabRate;
              totalConsumption = 0;
            }else{
                totalConsumption -= slabDiff;
                bill += slabDiff * slabRate;
            }
            prevSlabLimit = slab;
        }
        if (totalConsumption >= 1) {
            bill += totalConsumption * billRateUptoMax.get(Integer.MAX_VALUE);
            totalConsumption = 0;
          }
        
          return bill;
      }
    
}
