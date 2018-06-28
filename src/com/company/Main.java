package com.company;

import java.util.Scanner;
// create a program that implements a simple  BankArrayList with the following cabilibilities
//Able to store, modify, remove and query bank name.
//you will want to create a seperate class for BankAccount( account number)
//create master class (BankArrayList) that holds the ArrayList of BankAccounts
//The BankArrayList class has the functinalities listed above.
//Add a menu of options that are avaliable.
//Options: quit, print list of banks account, add new bank account, update exisiting bank account, remove bank account
//and search/ find bank account.

//when adding or updating be sure to check if the bank account already exists(use name)
//Be sure not to expose the inner working of the ArrayList to BankArrayList
//e.g. no ints, no get(i) etc
//BankArrayList should do everything with bank account objects only


public class Main {
    private static Scanner scanner=new Scanner(System.in);
    private static BankArrayList bankArrayList=new BankArrayList(123456789);

    public static void main (String[]args){

        boolean quit=false;

        printAction();
        while(!quit){
            System.out.println("\n Enter action: (6 to show acailable actions)");
            int action=scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("\nShutting down...");
                    quit=true;
                    break;
                case 1:
                    printAccounts();
                    break;
                case 2:
                    addNewAccount();
                    break;
                case 3:
                    updateAccount();
                    break;
                case 4:
                    removeAccount();
                    break;
                case 5:
                    queryAccount();
                    break;
                case 6:
                    printAction();
                    break;

            }
        }

    }
    private static void addNewAccount(){
        System.out.println("Enter acount number: ");
        int accountNumber=scanner.nextInt();
        BankAccount newContact= BankAccount.createBankAccount(accountNumber);
        if(bankArrayList.addNewAccount(newContact)){
            System.out.println("New account added: name= "+accountNumber);

        }else{
            System.out.println("Cannot add," +accountNumber+" already on file");
        }
    }
    private static void updateAccount(){
        System.out.println("Enter existing account number: ");
        int accountNumber=scanner.nextInt();
        BankAccount existingAccountRecord=bankArrayList.queryBankAccount(accountNumber);
        if(existingAccountRecord==null){
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Enter new account number: ");
        int newAccountNumber=scanner.nextInt();

        BankAccount newAccount=BankAccount.createBankAccount(newAccountNumber);
        if(bankArrayList.updateAccountNumber(existingAccountRecord,newAccount)){
            System.out.println("Successfully updated record.");
        }
        else{
            System.out.println("Error updating record.");
        }
    }
    private static void removeAccount() {
        System.out.println("Enter existing account number: ");
        int account = scanner.nextInt();
        BankAccount existingAccountRecord = bankArrayList.queryBankAccount(account);
        if (existingAccountRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        if(bankArrayList.remoeveAccount(existingAccountRecord)){
            System.out.println("Successfully deleted.");
        }else{
            System.out.println("Error deleting contact");
        }
    }
    private static void queryAccount() {
        System.out.println("Enter existing account number: ");
        int account = scanner.nextInt();
        BankAccount existingAccountRecord = bankArrayList.queryBankAccount(account);
        if (existingAccountRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Account Number found: " + existingAccountRecord.getAccountNumber());
    }



    private static void printAccounts(){
        bankArrayList.printAccounts();

    }
    private static void printAction(){
        System.out.println("\n Available actions:\npress");
        System.out.println("0 - to shutdown\n"+
                "1 - to print accountNumbers\n"+
                "2 - to add a new account\n"+
                "3 - to update an existing account\n"+
                "4 - to remove an existing account\n"+
                "5 - query if an existing account exists\n"+
                "6 - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }


}
