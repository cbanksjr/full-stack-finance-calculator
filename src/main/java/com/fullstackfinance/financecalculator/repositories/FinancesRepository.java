package com.fullstackfinance.financecalculator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fullstackfinance.financecalculator.dtos.FinancesDTO;

public interface FinancesRepository extends CrudRepository<FinancesDTO, Long> {

    void save(double moneyToBeDeductedFrom);

}
