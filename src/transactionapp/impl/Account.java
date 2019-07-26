package transactionapp.impl;

import transactionapp.abstr.Transaction;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import transactionapp.abstr.AccountDefinition;

/**
 *
 * @author RadoslawKoch
 */
//Receiver
public class Account 
    implements AccountDefinition{

    private BigDecimal balance;
    private final int number;
    private final List<Transaction> history = new ArrayList();

    public Account(int number) {
        this.number = number;
        this.balance = BigDecimal.valueOf(0);
    }
    
    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public List<Transaction> getHistory() {
        return history;
    }

    @Override
    public String toString() {
        return "Account{" + "balance=" + balance + ", number=" + number + '}';
    }
}
