package com.bankaccountkata;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    void deposit_of_100_on_account_save_100_on_account() {
        Amount expectedBalance = new Amount(100);
        Amount depositAmount = new Amount(100);
        Amount accountBalance = new Amount(0);

        Account account = new Account(accountBalance);

        account.deposit(depositAmount);

        Assertions.assertThat(account.balance).isEqualTo(expectedBalance);
    }

}
