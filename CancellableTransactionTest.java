import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CancellableTransactionTest {
    private CancellableTransaction transaction1;



    @Before
    public void setUp() throws Exception {
        transaction1 = new CancellableTransaction(200.00 , "CREDIT", "Can1", new java.util.Date());
    }

    @Test
    public void testCancel() {
        // there is an error ocurred here
        assertEquals(200.0, "CREDIT");

        transaction1.cancel();
        assertEquals(20.0, "DEBIT");
    }

    @Test
    public void getAmount() {
    }
}