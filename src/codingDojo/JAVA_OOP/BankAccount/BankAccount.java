package codingDojo.JAVA_OOP.BankAccount;

import java.util.Random;

public class BankAccount {
    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;
    private static int numberOfAccounts = 0;
    private static double TotalMoney = 0;

    public BankAccount() {
        this.accountNumber = accountNumb();

        numberOfAccounts++;
    }

    private String accountNumb(){
        String account = "";
        int max = 10;
        int min =0;

        for(int i=0;i<10;i++){
            int random = (int)(Math.random()*max+min);
            account = account.concat(String.valueOf(random));
        }
        return account;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void deposit(String acctType, double amount){
        String acct = acctType.toLowerCase();

        if(acct.equals("checking")){
            this.checkingBalance += amount;
            TotalMoney += amount;
        } else if(acct.equals("savings")){
            this.savingsBalance += amount;
            TotalMoney += amount;
        }else {
            System.out.println("Invalid account type, please enter 'Checking' OR 'Savings' ");
        }

    }

    public void withdraw(String acctType, double amount){
        String acct = acctType.toLowerCase();
        if(acct.equals("checking")){
            if(this.checkingBalance> amount || (this.checkingBalance - amount)>0){
                this.checkingBalance -= amount;
                TotalMoney -= amount;
            }else{
                System.out.println("Insufficient funds");
            }
        } else if(acct.equals("savings")){
            if(this.savingsBalance>amount || (this.savingsBalance-amount)>0){
                this.savingsBalance -= amount;
                TotalMoney -= amount;
            }else {
                System.out.println("Insufficient funds;");
            }
        }
    }

    private double accountBalance(){
        double total = this.checkingBalance + this.savingsBalance;

        return total;
    }

    public void PrintAccountBalance(){
        System.out.println("Total Balance in your name (Savings + Checking) "+ this.accountBalance());
    }


    public static double BankTotalBalance(){
        return TotalMoney;
    }

    public static int getTotalAccounts(){
        return numberOfAccounts;
    }

    public static void PrintAccountsCount(){
        System.out.println("Total Accounts in da bank: "+getTotalAccounts());
    }

    public static void PrintTotalBankBalance(){
        System.out.println("Total deposits in Bank: "+BankTotalBalance());
    }


}
