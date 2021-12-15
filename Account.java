/**
 * represents a bank account
 *
 */
public class Account
{
    // the customer
    private Customer customer;
    // the account number
    private String accountNumber;
    // the account balance
    private double balance;
    // the maximum number of transactions
    private final int MAX_TRANSACTIONS = 10;         
    // array to hold transactions
    private Transaction[] transactions;   
    // the number of Transactions in the array                                 
    private int numberOfTransactions;       


    public Account(Customer customer, String accountNumber)
    {
        transactions = new Transaction[MAX_TRANSACTIONS];   
        numberOfTransactions = 0;
        this.customer = customer;
        this.accountNumber = accountNumber;
        balance = 0.0f;
    }
    
    public String getAccountNumber()
    {
        return accountNumber;
    }

    public String getCustomerName()
    {
        return (customer.getFirstName() + " " + customer.getLastName());
    }

    public double getBalance()
    {
        return balance;
    }
    
    public int getNumberOfTransactions()
    {
        return numberOfTransactions;
    }
    
    /**
     * prints details of the account and its current transactions
     * 
     */
    public void displayTransactions()   
    {
        System.out.format("Account: %s\nCustomer: %s\n",
            accountNumber,this.getCustomerName());

        for(int i=0;i<numberOfTransactions;i++)
        {
            Transaction trans = transactions[i];

            System.out.format("%4.2f    %s    %s    %s\n", trans.getAmount(),
                    trans.getType(),
                    trans.getReference(),
                    trans.getDateString());
        }
    }

    public void addTransaction(Transaction newTransaction)
    {
        if(numberOfTransactions < MAX_TRANSACTIONS)
        {
            transactions[numberOfTransactions] = newTransaction;
            numberOfTransactions++;
        }
        updateBalance();
    }

    public Transaction[] getTransactions()
    {
        return transactions;
    }
    
    public Transaction getTransaction(String reference)
    {
       Transaction target = null;
       int i = 0;
       while(i<numberOfTransactions)
       {
           if(transactions[i].getReference().equals(reference))
           {
               target = transactions[i];
               break;
           }
           i++;
       }
       return target;
    }
    
    public void removeTransaction(String reference)
    {
       int i = 0;
       boolean found = false;
       while(i<numberOfTransactions)
       {
           if(transactions[i].getReference().equals(reference))
           {
               found = true;
               break;
           }
           i++;
       }
       if(found)
       {
           for(int j=i;j<numberOfTransactions;j++)
           {
               transactions[j] = transactions[j+1];
           }
           transactions[numberOfTransactions]=null;
           numberOfTransactions--;
       }
       updateBalance();
    }

     // calculates the total value of all transactions and assigns this total to the account balance
    private void updateBalance()
    {
        double total = 0.0;   // total value of all transactions
        for(int i=0;i<numberOfTransactions;i++)
        {
            Transaction trans = transactions[i];
            if (trans.getType().equals("CREDIT"))
            {
                total = total + trans.getAmount();
            }
            else if(trans.getType().equals("DEBIT"))
            {
                total = total - trans.getAmount();
            }
        }
        this.balance = total;    // assign total to account balance field
    }


    public String toString()
    {
        return String.format("Account number: %s, Customer: %s", 
            accountNumber, this.getCustomerName());
    }

}

