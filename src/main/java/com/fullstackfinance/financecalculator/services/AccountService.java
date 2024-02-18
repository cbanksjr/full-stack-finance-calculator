package com.fullstackfinance.financecalculator.services;

import com.fullstackfinance.financecalculator.dtos.AccountDTO;
import java.util.ArrayList;

public interface AccountService {
    ArrayList<AccountDTO> amountToAllocateFrom(long id);
}
