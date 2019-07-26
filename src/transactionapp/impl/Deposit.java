package transactionapp.impl;

import transactionapp.abstr.Transaction;
import java.math.BigDecimal;

/**
 *
 * @author RadoslawKoch
 */
//Command
public class Deposit 
    extends Transaction{

    public Deposit(Account from, BigDecimal amount) {
        super(from, from, amount);
    }

    @Override
    public void execute() {
        BigDecimal current = this.from.getBalance().add(this.amount);
        this.from.setBalance(current);
    }
}
