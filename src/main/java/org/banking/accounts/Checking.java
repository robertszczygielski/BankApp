package org.banking.accounts;

import java.math.BigDecimal;

public class Checking extends Account {

    private static String accountType = "Checking";
    private BigDecimal charge;

    public static String getAccountType() {
        return accountType;
    }

    public static void setAccountType(String accountType) {
        Checking.accountType = accountType;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    @Override
    public String toString() {
        return "Checking{" +
                "charge=" + charge +
                '}';
    }

}
