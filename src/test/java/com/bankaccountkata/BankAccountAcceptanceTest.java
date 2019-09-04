package com.bankaccountkata;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAccountAcceptanceTest {

    @Test
    void adding_deposit_to_user_account_save_money_in_user_account() {

        Account account = new Account();
        HistoryAccount historyAccount = new HistoryAccount();
        Amount amount = new Ammount();
        Assertions.assertThat(account.deposit(amount).isEqualTo(historyAccount.statement(amount)));
    }
}
