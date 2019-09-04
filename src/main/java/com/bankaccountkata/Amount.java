package com.bankaccountkata;

public class Amount {

    private double money;

    public Amount(double money) {
        this.money = money;
    }

    public Amount add(Amount amountDeposited) {
        return new Amount(money + amountDeposited.money);
    }
}
