package com.bankaccountkata;

public class Account {

    public Amount balance;

    public Account(Amount balance) {
        this.balance = balance;
    }

    public void deposit(Amount amountDeposit) {
        balance = balance.add(amountDeposit);
    }
}
