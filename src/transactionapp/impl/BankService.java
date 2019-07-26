package transactionapp.impl;

import transactionapp.abstr.Transaction;
import java.util.HashMap;
import java.util.Map;
import transactionapp.abstr.BankServiceDefinition;

/**
 *
 * @author RadoslawKoch
 */
//Invoker
public class BankService
    implements BankServiceDefinition{

    private final Map<Integer,Transaction> transactions = new HashMap();
    
    @Override
    public void executeTransaction(Transaction trs){
        this.transactions.put(trs.getId(), trs);
        trs.getFrom().getHistory().add(trs);
        if(trs.getClass().getSimpleName().equals("Transfer")){
            trs.getTo().getHistory().add(trs);
        }
        trs.setDone(true);
        trs.execute();
    }
    
    @Override
    public void saveTransaction(Transaction trs){
        this.transactions.put(trs.getId(), trs);
    }
    
    @Override
    public void cancelTransaction(Integer id){
        Transaction trs = this.transactions.get(id);
        transactions.remove(id);
        if(trs==null || !trs.isDone())
            return;
        String className = trs.getClass().getSimpleName();
        switch (className) {
            case "Widthdraw":
                new Deposit(trs.getTo(),trs.getAmount()).execute();
                break;
            case "Deposit":
                new Widthdraw(trs.getTo(),trs.getAmount()).execute();
                break;
            default:
                new Transfer(trs.getTo(),trs.getFrom(),trs.getAmount()).execute();
                break;
        }
        
        trs.getFrom().getHistory().remove(trs);
        if(className.equals("Transfer")){
            trs.getTo().getHistory().remove(trs);
        }
        System.out.println("Cancel was successful.");
    }
    
    @Override
    public void batchExecution(){
        transactions.values().stream().filter((x) -> (!x.isDone())).map((x) -> {
            x.execute();
            return x;
        }).forEach((x) -> {
            x.setDone(true);
        });
    }   
}
