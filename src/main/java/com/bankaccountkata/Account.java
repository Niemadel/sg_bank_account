package com.bankaccountkata;

public class Account {

    private HistoryAccount historyAccount;

    public Account(HistoryAccount historyAccount) {
        this.historyAccount = historyAccount;
    }

    public Amount deposit(Amount amount) {
        return amount;

    }

}
