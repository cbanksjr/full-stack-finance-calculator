package com.financecalculator.financecalculator.dtos;

import lombok.Data;

@Data
public class SavingsDTO{
   private double initialAmount; 
   private double allocatedAmount; 
   private double totalAllocation;
   private double allocationTakenOut;
   private double totalAllocationTakenOut;
   private double percent; 
}
