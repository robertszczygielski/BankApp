package org.banking.accounts;

import java.math.BigDecimal;

public abstract class Account {

    private BigDecimal balance;
    private BigDecimal interests;
    private int accountNumber;
    private static int numberOfAccounts = 1;

    Account() {
        accountNumber = numberOfAccounts++;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        if (this.balance == null) {
            this.balance = balance;
        }
        this.balance = this.balance.add(balance);
    }

    public BigDecimal getInterests() {
        return interests;
    }

    public void setInterests(BigDecimal interests) {
        this.interests = interests;
    }

    public void withdraw(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", interests=" + interests +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
