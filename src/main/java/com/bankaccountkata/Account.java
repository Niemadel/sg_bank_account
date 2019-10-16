package com.bankaccountkata;

public class Account {

    public Amount balance;
    public AccountStatement accountStatement;

    public Account(Amount balance, AccountStatement accountStatement) {
        this.balance = balance;
        this.accountStatement = accountStatement;
    }

    public void deposit(Amount amountDeposit) {
        balance = balance.add(amountDeposit);
        accountStatement.add(new OperationLine("deposit", balance, amountDeposit));
    }

    public void withdrawal(Amount withdrawalAmount) {
        balance = balance.substract(withdrawalAmount);
    }

}
