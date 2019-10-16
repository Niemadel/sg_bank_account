package com.bankaccountkata;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    void deposit_of_100_on_account_save_100_on_account() {
        Amount expectedBalance = Amount.of(new BigDecimal(100));
        Amount accountBalance = Amount.of(new BigDecimal(0));
        Account account = new Account(accountBalance);
        Amount depositAmount = Amount.of(new BigDecimal(100));

        account.deposit(depositAmount);

        assertThat(account.balance).isEqualTo(expectedBalance);
    }

}
