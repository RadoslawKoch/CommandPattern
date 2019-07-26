package transactionapp.abstr;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author RadoslawKoch
 */
public interface AccountDefinition {

    public BigDecimal getBalance();

    public void setBalance(BigDecimal balance);

    public int getNumber();

    public List<Transaction> getHistory();
}
