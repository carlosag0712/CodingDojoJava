package codingDojo.JAVA_OOP.BankAccount;

public class BankAccountTest     {

    public static void main(String[] args) {
        BankAccount testAccount = new BankAccount();
        testAccount.PrintAccountBalance();
        testAccount.deposit("checking", 200);
        testAccount.PrintAccountBalance();
        System.out.println("Checking Balance: "+testAccount.getCheckingBalance());
        System.out.println("Savings Balance: "+ testAccount.getSavingsBalance());
        testAccount.withdraw("savings", 250);
        testAccount.PrintAccountBalance();

        BankAccount testAccount1 = new BankAccount();
        testAccount1.deposit("savings", 1000);
        testAccount1.PrintAccountBalance();

        BankAccount.PrintAccountsCount();
        BankAccount.PrintTotalBankBalance();




    }

}
