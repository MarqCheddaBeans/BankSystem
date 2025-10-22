package com.pluralsight;

//Create a BankAccount class with private fields: accountNumber, accountHolder, balance, isActive
//Implement public getter methods for safe data access
//Create public methods: deposit(), withdraw(), getAccountInfo()
//Include private helper methods: validateAmount(), updateBalance()

import java.util.Scanner;

public class BankAccount {
    Scanner scan = new Scanner(System.in);

    private int accountNumber;
    private String accountHolder;
    private double balance;
    private boolean isActive;

    public BankAccount(int accountNumber, String accountHolder, double balance, boolean isActive) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.isActive = isActive;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void deposit(){

        System.out.print("Please enter deposit amount: ");
        double amount = scan.nextDouble();

        this.balance += amount;

        System.out.println("Deposit successful!");
        System.out.println("New Balance: " + this.balance);

    }

    public void withdraw(){

        System.out.println("Please enter withdrawal amount");
         double amount = scan.nextDouble();

         if(balance < amount){
             System.out.println("You dont got it like that, try again.");
         }else{
             amount *= -1;
             balance += amount;
             System.out.println("Withdrawal successful!");
             System.out.println("Your balance is: " + balance);
         }
    }

    public void getAccountInfo(){

            System.out.println("Your Account Number is: " + accountNumber);
            System.out.println("Account holder is: " + accountNumber);
            System.out.println("Account balance is: " + balance);
            if(isActive){
                System.out.println("Your account is currently active");
            }else{
                System.out.println("Your account is not currently active");
            }
    }

}
