package com.fullstackfinance.financecalculator.services;

import com.fullstackfinance.financecalculator.dtos.AccountDTO;

public interface AccountService {
    AccountDTO amountToAllocateFrom(long id);
}
