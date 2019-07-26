package transactionapp.impl;

import transactionapp.abstr.Transaction;
import java.math.BigDecimal;

/**
 *
 * @author RadoslawKoch
 */
//Command
public class Widthdraw 
    extends Transaction{

    public Widthdraw(Account from, BigDecimal amount) {
        super(from, from, amount);
    }

    @Override
    public void execute() {
        BigDecimal current = this.from.getBalance().subtract(this.amount);
        this.from.setBalance(current);
    }
}
