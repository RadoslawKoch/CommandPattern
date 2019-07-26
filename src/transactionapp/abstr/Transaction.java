
package transactionapp.abstr;

import transactionapp.abstr.Command;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import transactionapp.impl.Account;

/**
 *
 * @author RadoslawKoch
 */

//COMMAND
public abstract class Transaction 
    implements Command{
    
    private static int counter = 0;
    protected int id;  
    protected final LocalDateTime time;
    protected final Account from;
    protected final Account to;
    protected final BigDecimal amount;
    protected boolean done = false;

    public Transaction(Account from, Account to, BigDecimal amount) {
        this.id = ++counter;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.time = LocalDateTime.now();
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Account getFrom() {
        return from;
    }

    public Account getTo() {
        return to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{ id=" + id + ", time=" + time + ", from=" + from + ", to=" + to + ", amount=" + amount + ", done=" + done + '}';
    }

    
    
    
    
    
    

}