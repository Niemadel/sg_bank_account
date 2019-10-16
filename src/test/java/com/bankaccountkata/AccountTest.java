package com.bankaccountkata;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    void deposit_of_100_on_account_return_balance_of_100_on_account_with_balance_of_0() {
        Amount expectedBalance = Amount.of(new BigDecimal(100));
        Amount accountBalance = Amount.of(new BigDecimal(0));
        AccountStatement accountStatement = new AccountStatement(new ArrayList<>());
        Account account = new Account(accountBalance, accountStatement);
        Amount depositAmount = Amount.of(new BigDecimal(100));

        account.deposit(depositAmount);

        assertThat(account.balance).isEqualTo(expectedBalance);
    }

    @Test
    void deposit_of_100_on_account_return_balance_of_0_on_account_with_balance_of_minus_100() {
        Amount expectedBalance = Amount.of(new BigDecimal(0));
        Amount accountBalance = Amount.of(new BigDecimal(-100));
        AccountStatement accountStatement = new AccountStatement(new ArrayList<>());
        Account account = new Account(accountBalance, accountStatement);
        Amount depositAmount = Amount.of(new BigDecimal(100));

        account.deposit(depositAmount);

        assertThat(account.balance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawal_of_100_on_account_substract_100_on_account_with_initial_balance_of_200() {
        Amount expectedBalance = Amount.of(new BigDecimal(100));
        Amount accountBalance = Amount.of(new BigDecimal(200));
        AccountStatement accountStatement = new AccountStatement(new ArrayList<>());
        Account account = new Account(accountBalance, accountStatement);
        Amount withdrawalAmount = Amount.of(new BigDecimal(100));

        account.withdrawal(withdrawalAmount);

        assertThat(account.balance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawal_of_100_on_account_substract_100_on_account_with_balance_of_0() {
        Amount expectedBalance = Amount.of(new BigDecimal(-100));
        Amount accountBalance = Amount.of(new BigDecimal(0));
        AccountStatement accountStatement = new AccountStatement(new ArrayList<>());
        Account account = new Account(accountBalance, accountStatement);
        Amount withdrawalAmount = Amount.of(new BigDecimal(100));

        account.withdrawal(withdrawalAmount);

        assertThat(account.balance).isEqualTo(expectedBalance);
    }

    @Test
    void print_statement_with_balance_deposit_amount_and_operation_type_after_deposit() {
        Amount accountBalance = Amount.of(new BigDecimal(0));
        Amount expectedBalance = Amount.of(new BigDecimal(100));
        AccountStatement accountStatement = new AccountStatement(new ArrayList<>());
        Account account = new Account(accountBalance, accountStatement);
        Amount depositAmount = Amount.of(new BigDecimal(100));

        OperationLine expectedOperationLine = new OperationLine("deposit", expectedBalance, depositAmount);
        AccountStatement expectedStatement = new AccountStatement(new ArrayList<>());
        expectedStatement.add(expectedOperationLine);

        account.deposit(depositAmount);

        assertThat(account.accountStatement).isEqualTo(expectedStatement);
    }

}
