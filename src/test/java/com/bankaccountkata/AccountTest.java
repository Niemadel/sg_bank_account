package com.bankaccountkata;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    void deposit_of_100_on_account_save_100_on_account() {

        Operation operation = new Operation();
        HistoryAccount historyaccount = new HistoryAccount(operation);
        Account account = new Account(historyaccount);
        Amount saving = account.deposit(new Amount(100));

        Assertions.assertThat(saving.money).isEqualTo(100);
    }
}
