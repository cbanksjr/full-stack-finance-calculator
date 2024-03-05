package com.financecalculator.financecalculator.services;

import java.util.List;

import com.financecalculator.financecalculator.dtos.AccountDTO;

public interface AccountService {

    List<AccountDTO> retrieveAmounts();

}
