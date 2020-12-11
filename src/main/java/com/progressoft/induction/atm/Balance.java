package com.progressoft.induction.atm;

import java.math.BigDecimal;

public class Balance implements BankingSystem {
    String accountNumber;
    BigDecimal amount;


    @Override
    public BigDecimal getAccountBalance(String accountNumber) {
        return amount;
    }


    @Override
    public void debitAccount(String accountNumber, BigDecimal amount) {
        this.accountNumber=accountNumber;
        this.amount=amount;

    }
}
