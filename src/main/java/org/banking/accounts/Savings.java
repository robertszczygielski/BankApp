package org.banking.accounts;

import java.math.BigDecimal;

public class Savings extends Account {

    private static String accountType = "Saving";
    private BigDecimal interestRate;

    public static String getAccountType() {
        return accountType;
    }

    public static void setAccountType(String accountType) {
        Savings.accountType = accountType;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Savings{" +
                "interestRate=" + interestRate +
                '}';
    }
}
