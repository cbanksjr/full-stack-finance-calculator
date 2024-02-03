package com.fullstackfinance.financecalculator.services;

import com.fullstackfinance.financecalculator.dtos.AccountDTO;

public interface AccountService {
    AccountDTO setAmountToDeductFrom(String moneyToBeDeductedFrom);
    AccountDTO getAmountAfterDeductions();
    AccountDTO setAmountRemaining(String setAmountToDeductFrom, String getAmountAfterDeductions);
}
