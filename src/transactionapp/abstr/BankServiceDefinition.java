package transactionapp.abstr;

import transactionapp.abstr.Transaction;

/**
 *
 * @author RadoslawKoch
 */
public interface BankServiceDefinition {

    void executeTransaction(Transaction transaction);
    
    void saveTransaction(Transaction transaction);
    
    void cancelTransaction(Integer id);
    
    void batchExecution();
}
