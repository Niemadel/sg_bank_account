package com.bankaccountkata;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountAcceptanceTest {

    @Test
    void print_statement_with_two_operation_on_account() {

        LocalDateTime dateOfOperation1 = LocalDateTime.of(2019, 10, 16, 17, 39);
        LocalDateTime dateOfOperation2 = LocalDateTime.of(2019, 11, 18, 14, 32);

        Amount accountBalance = Amount.of(new BigDecimal(200));
        Amount expectedBalance1 = Amount.of(new BigDecimal(100));
        AccountStatement initialAccountStatement = new AccountStatement(new ArrayList<>());
        Account account = new Account(accountBalance, initialAccountStatement);
        Amount withdrawalAmount = Amount.of(new BigDecimal(100));

        OperationLine expectedOperationLine1 = new OperationLine(OperationType.WITHDRAWAL, expectedBalance1, withdrawalAmount, dateOfOperation1);
        AccountStatement expectedStatement = new AccountStatement(new ArrayList<>());
        expectedStatement.add(expectedOperationLine1);

        account.withdrawal(withdrawalAmount, dateOfOperation1);

        Amount expectedBalance2 = Amount.of(new BigDecimal(150));
        Amount depositAmount = Amount.of(new BigDecimal(50));

        OperationLine expectedOperationLine2 = new OperationLine(OperationType.DEPOSIT, expectedBalance2, depositAmount, dateOfOperation2);
        expectedStatement.add(expectedOperationLine2);
        account.deposit(depositAmount, dateOfOperation2);

        assertThat(account.accountStatement).isEqualTo(expectedStatement);
    }


}
