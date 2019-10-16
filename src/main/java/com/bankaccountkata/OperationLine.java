package com.bankaccountkata;

import java.util.Objects;

public class OperationLine {

    private String operationType;
    private Amount balance;
    private Amount deposit;

    public OperationLine(String operationType, Amount balance, Amount deposit) {
        this.operationType = operationType;
        this.balance = balance;
        this.deposit = deposit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationLine that = (OperationLine) o;
        return Objects.equals(operationType, that.operationType) &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(deposit, that.deposit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, balance, deposit);
    }

    @Override
    public String toString() {
        return "OperationLine{" +
                "operationType='" + operationType + '\'' +
                ", balance=" + balance +
                ", deposit=" + deposit +
                '}';
    }
}
