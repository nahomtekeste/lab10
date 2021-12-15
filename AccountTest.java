import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    private Customer customer1;
    private Transaction transact1;
    private Transaction transact2;
    private Transaction transact3;
    private Account account1;

    @org.junit.Before
    public void setUp() throws Exception {
        customer1 = new Customer("Fernando","Alonso");
        transact1 = new Transaction(200.0 , "CREDIT" , "REF1" , new java.util.Date());
        transact2 = new Transaction(100.0 , "DEBIT" , "REF2" , new java.util.Date());
        transact3 = new Transaction(300.0 , "CREDIT" , "REF3" , new java.util.Date());
        account1 = new Account(customer1, "12345");

        account1.addTransaction(transact1);
        account1.addTransaction(transact2);
        account1.addTransaction(transact3);


    }
    @Test
    public void testAddTransaction(){
        // this could be also be change to CancellableTransaction

        Transaction transact1 = new CancellableTransaction(200.0 , "CREDIT" , "test" , new java.util.Date());
        account1.addTransaction(transact1);
        assertEquals(400.00, account1.getBalance(), 0.1);
        assertEquals("default",
                account1.getTransactions()[3].getReference());




    }
}