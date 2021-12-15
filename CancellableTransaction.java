import java.util.Date;

public class CancellableTransaction extends Transaction{

    private boolean cancelled;

    public CancellableTransaction(){
        this.cancelled = false;
    }
    public CancellableTransaction(double amount, String type, String reference, Date date){
        new Transaction(amount,type,reference, date);
        this.cancelled = false;
    }

    public void cancel(){
        cancelled = true;
        type = "DEBIT";
    }
    public double getAmount(){
        if (cancelled ==false){
            return amount;
        }else {
            return amount * 0.10;// this will return 10% of the amount or the value
        }

    }

}
