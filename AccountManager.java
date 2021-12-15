import java.util.Scanner;
import java.util.Date;

/**
 * Write a description of class AccountManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AccountManager
{
    // the account
    private Account account;
    // reader for reading user input
    private Scanner reader;

    /**
     * Constructor for objects of class AccountManager
     */
    public AccountManager(Account account)
    {
        this.account = account;
        reader = new Scanner(System.in);
    }

    public void start()
    {
        System.out.println("WELCOME TO THE ACCOUNT MANAGER APPLICATION");

        boolean finished = false;
       // printMenu();
        while (finished == false)
        {
            printMenu();
            String input = reader.nextLine();
            int opt=0;
            try
            {
                opt = Integer.parseInt(input);
            }
            catch (Exception e){}

            if(opt==1)
            {
                listDetails();
            }
            else if(opt==2)
            {
                listDetailsOfTransaction();
            }
            else if(opt==3)
            {
                recordTransaction();
            }
            else if(opt==4)
            {
                deleteTransaction();
            }
            else if(opt==5)
            {
                System.out.println("closing loop now ");
                finished = true;
            }
            else
            {
                System.out.println("Command not recognised");
            }


//            switch (opt){
//                case 1:
//                    listDetails();
//                    break;
//                case 2:
//                    listDetailsOfTransaction();
//                    break;
//                case 3:
//                    recordTransaction();
//                    break;
//                case 4:
//                    deleteTransaction();
//                    break;
//                case 5:
//                    System.out.println("closing loop");
//                    finished = true;
//                    break;
//            }
        }
    }

    // this display the menu options
    public void printMenu(){

        System.out.println("\n***********************");
        System.out.println("         MENU          ");
        System.out.println("***********************");
        System.out.println("1. list transactions\n2. list a specified transaction\n3. add a new transaction\n4. delete a transaction\n5. quit");
        System.out.println("Select Options :\n >");

    }

    public void recordTransaction(){

        System.out.print("Transaction amount to add?\n>");
        String inputAmount = reader.nextLine();
        double amount = Double.parseDouble(inputAmount);
        //double amount = reader.nextDouble();

//        // get type
        System.out.print("Transaction type?\n>");
        String type = reader.nextLine();


        // DONE TO DO: get reference
        System.out.print("Transaction reference ?\n>");
        String reference = reader.nextLine();

        // date is today's date
        Date date = new Date();


        // DONE TO DO: create transaction and add to account
        Transaction transact = new Transaction(amount,type,reference,date);
        account.addTransaction(transact);
    }

    // this is a  list of details

    public void listDetails(){
        account.displayTransactions();
        account.getBalance();

    }

    // return the Transaction object with that reference
    public void listDetailsOfTransaction(){

        //  get reference
        System.out.print("Transaction reference ?\n>");
        String reference = reader.nextLine();
        reference.toString();
    }

    // this method is used to delete the transaction
    public void deleteTransaction(){

        System.out.print("Transaction reference ?\n>");
        String reference = reader.nextLine();
        account.removeTransaction(reference);
    }

    public static void main(String[] args)
    {

        Customer cust = new Customer("Fernando", "Alonso");
        //Account object for the customer
        Account account = new Account(cust, "12345");// account object for customer

        // an AccountManager for the account,
        AccountManager accountManager = new AccountManager(account);
        accountManager.start();

    }

}

