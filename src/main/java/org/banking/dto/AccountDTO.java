package org.banking.dto;

import org.banking.dto.enumerators.AccountType;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountDTO implements Serializable {
    private AccountType accountType;
    private BigDecimal balance;
    private BigDecimal interests;
    private int accountNumber;
    private BigDecimal delegate;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getInterests() {
        return interests;
    }

    public void setInterests(BigDecimal interests) {
        this.interests = interests;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getDelegate() {
        return delegate;
    }

    public void setDelegate(BigDecimal delegate) {
        this.delegate = delegate;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountDTO that = (AccountDTO) o;

        return accountNumber == that.accountNumber
                && accountType == that.accountType
                && (balance != null ? balance.equals(that.balance) : that.balance == null)
                && (interests != null ? interests.equals(that.interests) : that.interests == null)
                && (delegate != null ? delegate.equals(that.delegate) : that.delegate == null);
    }

    @Override
    public int hashCode() {
        int result = accountType != null ? accountType.hashCode() : 0;
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (interests != null ? interests.hashCode() : 0);
        result = 31 * result + accountNumber;
        result = 31 * result + (delegate != null ? delegate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountType=" + accountType +
                ", balance=" + balance +
                ", interests=" + interests +
                ", accountNumber=" + accountNumber +
                ", delegate=" + delegate +
                '}';
    }
}
