package com.bankaccountkata;

import java.math.BigDecimal;
import java.util.Objects;

public class Amount {

    private BigDecimal money;

    private Amount(BigDecimal money) {
        this.money = money;
    }

    public static Amount of(BigDecimal money) {
        money = money.setScale(2, BigDecimal.ROUND_CEILING);
        return new Amount(money);
    }

    public Amount add(Amount amountDeposited) {
        return new Amount(money.add(amountDeposited.money));
    }

    public Amount substract(Amount withdrawalAmount) {
        return new Amount(money.subtract(withdrawalAmount.money));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return Objects.equals(money, amount.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public String toString() {
        return "Amount{" +
                "money=" + money +
                '}';
    }

}
