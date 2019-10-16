package com.bankaccountkata;

import java.time.LocalDateTime;

public class Account {

    public Amount balance;
    public AccountStatement accountStatement;

    public Account(Amount balance, AccountStatement accountStatement) {
        this.balance = balance;
        this.accountStatement = accountStatement;
    }

    public void deposit(Amount amountDeposit, LocalDateTime operationDate) {
        balance = balance.add(amountDeposit);
        accountStatement.add(new OperationLine(OperationType.DEPOSIT, balance, amountDeposit, operationDate));
    }

    public void withdrawal(Amount withdrawalAmount, LocalDateTime operationDate) {
        balance = balance.substract(withdrawalAmount);
        accountStatement.add(new OperationLine(OperationType.WITHDRAWAL, balance, withdrawalAmount, operationDate));
    }

}
