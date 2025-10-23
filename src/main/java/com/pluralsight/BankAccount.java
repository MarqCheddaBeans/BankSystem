package com.pluralsight;

//Create a BankAccount class with private fields: accountNumber, accountHolder, balance, isActive
//Implement public getter methods for safe data access
//Create public methods: deposit(), withdraw(), getAccountInfo()
//Include private helper methods: validateAmount(), updateBalance()

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccount {
    Scanner scan = new Scanner(System.in);

    private String accountNumber;
    private String accountHolder;
    private double balance;
    private boolean isActive;

    public BankAccount(String accountNumber, String accountHolder, double balance, boolean isActive) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.isActive = isActive;
    }

    public String getAccountNumber() {
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
        if(isActive){
            System.out.println("Your Account Number is: " + accountNumber);
            System.out.println("Account holder is: " + accountNumber);
            System.out.println("Account balance is: " + balance);
            }else{
                System.out.println("Cannot provide account info. Your account is INACTIVE");
            }
    }

    public static void createNewAccount(List<BankAccount> allBankAccounts){

        try(BufferedWriter buffWrite = new BufferedWriter(new FileWriter("UserAccounts.csv"))){


        }catch(IOException e){
            System.out.println("Failure creating account, try again later");
        }



    }

    public static List<BankAccount> readAccounts(String filePath){

        //Create instance of BankAccount object
        List<BankAccount> accounts = new ArrayList<>();

        //try\catch with resources creating buffered reader, containing fileReader reading UserAccounts.csv
        try(BufferedReader buffRead = new BufferedReader (new FileReader("UserAccounts.csv"))){

            //Create String to store data from file
            String line;

            //cycles through file until end and stores each line in String line
            while((line = buffRead.readLine()) !=null){
                //store elements of read lines into String array, split by delimiter
                String[] userAccounts = line.split("\\|");

                //Checks for header and skips, header == no bueno
                if(userAccounts[0].contains("Account")){
                    continue;
                }

                //try\catch to parse and store split elements from userAccounts
                try{
                    String accNum = userAccounts[0];
                    String accName = userAccounts[1];
                    double amount = Double.parseDouble(userAccounts[2]);
                    boolean isActive = Boolean.parseBoolean(userAccounts[3]);

                    //Store into accounts list created earlier
                    accounts.add(new BankAccount(accNum,accName,amount,isActive));

                    //handle any thrown exception and display error message
                }catch (Exception e){
                    System.out.println("You done did it");
                }

            }

        }catch(IOException e){
            System.out.println("File not found");
        }
        return accounts;
    }

}
