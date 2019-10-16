package com.bankaccountkata;

import java.time.LocalDateTime;
import java.util.Objects;

public class OperationLine {

    private OperationType operationType;
    private Amount balance;
    private Amount operationAmount;
    private LocalDateTime operationDate;

    public OperationLine(OperationType operationType, Amount balance, Amount operationAmount, LocalDateTime operationDate) {
        this.operationType = operationType;
        this.balance = balance;
        this.operationAmount = operationAmount;
        this.operationDate = operationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationLine that = (OperationLine) o;
        return operationType == that.operationType &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(operationAmount, that.operationAmount) &&
                Objects.equals(operationDate, that.operationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, balance, operationAmount, operationDate);
    }
}