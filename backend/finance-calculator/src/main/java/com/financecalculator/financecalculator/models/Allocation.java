package com.financecalculator.financecalculator.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Allocation {
    @Id
    @GeneratedValue
    private long id;

    private double initialAmount;
    private double allocatedAmount;
    private double totalAllocation;
    private double allocationTakenOut;
    private double totalAllocationTakenOut;
    private double percent;
}
