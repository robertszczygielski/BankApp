package org.banking.accounts;

public class Checking extends Account {

    private static String accountType = "Checking";

    @Override
    public String toString() {
        return "Checking{" + super.toString() + "}";
    }
}
