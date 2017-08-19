package org.banking.accounts;

public class Savings extends Account {

    private static String accountType = "Saving";

    @Override
    public String toString() {
        return "Savings{" +
                super.toString() + "}";
    }
}
