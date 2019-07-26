package transactionapp.impl;

import transactionapp.abstr.Transaction;
import java.math.BigDecimal;

/**
 *
 * @author RadoslawKoch
 */
//Command
public class Transfer 
    extends Transaction{

    public Transfer(Account from, Account to, BigDecimal amount) {
        super(from, to, amount);
    }

    @Override
    public void execute() {
        this.from.setBalance(this.from.getBalance().subtract(amount));
        this.to.setBalance(this.to.getBalance().add(amount));
    }
}
