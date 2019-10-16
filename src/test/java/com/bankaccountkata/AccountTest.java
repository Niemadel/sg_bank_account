package com.bankaccountkata;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    LocalDateTime dateOfOperation = LocalDateTime.of(2019, 10, 16, 17, 39);

    @Test
    void deposit_of_100_on_account_return_balance_of_100_on_account_with_balance_of_0() {
        Amount expectedBalance = Amount.of(new BigDecimal(100));
        Amount accountBalance = Amount.of(new BigDecimal(0));
        AccountStatement initialAccountStatement = new AccountStatement(new ArrayList<>());
        Account account = new Account(accountBalance, initialAccountStatement);
        Amount depositAmount = Amount.of(new BigDecimal(100));

        account.deposit(depositAmount, dateOfOperation);

        assertThat(account.balance).isEqualTo(expectedBalance);
    }

    @Test
    void deposit_of_100_on_account_return_balance_of_0_on_account_with_balance_of_minus_100() {
        Amount expectedBalance = Amount.of(new BigDecimal(0));
        Amount accountBalance = Amount.of(new BigDecimal(-100));
        AccountStatement initialAccountStatement = new AccountStatement(new ArrayList<>());
        Account account = new Account(accountBalance, initialAccountStatement);
        Amount depositAmount = Amount.of(new BigDecimal(100));

        account.deposit(depositAmount, dateOfOperation);

        assertThat(account.balance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawal_of_100_on_account_substract_100_on_account_with_initial_balance_of_200() {
        Amount expectedBalance = Amount.of(new BigDecimal(100));
        Amount accountBalance = Amount.of(new BigDecimal(200));
        AccountStatement initialAccountStatement = new AccountStatement(new ArrayList<>());
        Account account = new Account(accountBalance, initialAccountStatement);
        Amount withdrawalAmount = Amount.of(new BigDecimal(100));

        account.withdrawal(withdrawalAmount, dateOfOperation);

        assertThat(account.balance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawal_of_100_on_account_substract_100_on_account_with_balance_of_0() {
        Amount expectedBalance = Amount.of(new BigDecimal(-100));
        Amount accountBalance = Amount.of(new BigDecimal(0));
        AccountStatement initialAccountStatement = new AccountStatement(new ArrayList<>());
        Account account = new Account(accountBalance, initialAccountStatement);
        Amount withdrawalAmount = Amount.of(new BigDecimal(100));

        account.withdrawal(withdrawalAmount, dateOfOperation);

        assertThat(account.balance).isEqualTo(expectedBalance);
    }

    @Test
    void print_statement_with_balance_and_deposit_amount_and_operation_type_after_deposit() {
        Amount accountBalance = Amount.of(new BigDecimal(0));
        Amount expectedBalance = Amount.of(new BigDecimal(100));
        AccountStatement initialAccountStatement = new AccountStatement(new ArrayList<>());
        Account account = new Account(accountBalance, initialAccountStatement);
        Amount depositAmount = Amount.of(new BigDecimal(100));

        LocalDateTime date = LocalDateTime.of(2019, 10, 16, 17, 39);
        OperationLine expectedOperationLine = new OperationLine(OperationType.DEPOSIT, expectedBalance, depositAmount, date);
        AccountStatement expectedStatement = new AccountStatement(new ArrayList<>());
        expectedStatement.add(expectedOperationLine);

        account.deposit(depositAmount, date);

        assertThat(account.accountStatement).isEqualTo(expectedStatement);
    }

    @Test
    void print_statement_with_balance_and_withdrawal_amount_and_operation_type_after_withdrawal() {
        Amount accountBalance = Amount.of(new BigDecimal(200));
        Amount expectedBalance = Amount.of(new BigDecimal(100));
        AccountStatement initialAccountStatement = new AccountStatement(new ArrayList<>());
        Account account = new Account(accountBalance, initialAccountStatement);
        Amount withdrawalAmount = Amount.of(new BigDecimal(100));

        OperationLine expectedOperationLine = new OperationLine(OperationType.WITHDRAWAL, expectedBalance, withdrawalAmount, dateOfOperation);
        AccountStatement expectedStatement = new AccountStatement(new ArrayList<>());
        expectedStatement.add(expectedOperationLine);

        account.withdrawal(withdrawalAmount, dateOfOperation);

        assertThat(account.accountStatement).isEqualTo(expectedStatement);
    }

}
