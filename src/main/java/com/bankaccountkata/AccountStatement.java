package com.bankaccountkata;

import java.util.List;
import java.util.Objects;

public class AccountStatement {

    private List<OperationLine> operationLines;

    AccountStatement(List<OperationLine> operationLines) {
        this.operationLines = operationLines;
    }

    void add(OperationLine operationLine) {
        operationLines.add(operationLine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountStatement that = (AccountStatement) o;
        return Objects.equals(operationLines, that.operationLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationLines);
    }

    @Override
    public String toString() {
        return "AccountStatement{" +
                "operationLines=" + operationLines +
                '}';
    }
}
