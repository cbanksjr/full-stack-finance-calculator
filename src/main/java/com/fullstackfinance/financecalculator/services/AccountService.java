package com.fullstackfinance.financecalculator.services;

import com.fullstackfinance.financecalculator.dtos.AccountDTO;
import java.util.List;

public interface AccountService {
    List<AccountDTO> amountToAllocateFrom(long id);

    List<AccountDTO> iterateIds();

}
