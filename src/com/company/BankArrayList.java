package com.company;

import java.util.ArrayList;
public class BankArrayList {
    private int accountNumber;
    private ArrayList<BankAccount> bankAccounts;

    public BankArrayList(int accountNumber) {
        this.accountNumber = accountNumber;
        this.bankAccounts = new ArrayList<BankAccount>();
    }

    public boolean addNewAccount(BankAccount accountNumber){
        if(findAccount(accountNumber.getAccountNumber())>=0){
            System.out.println("Account is already on file");
            return false;
        }
        bankAccounts.add(accountNumber);
        return true;
    }

    public boolean updateAccountNumber(BankAccount oldAccount, BankAccount newAccount){
        int foundPosition=findAccount(oldAccount);
        if(foundPosition<0){
            System.out.println(oldAccount.getAccountNumber()+", was not found.");
            return false;
        }
        this.bankAccounts.set(foundPosition, newAccount);
        System.out.println(oldAccount.getAccountNumber()+", was replaced with "+newAccount.getAccountNumber());
        return true;
    }

    private int findAccount(BankAccount accountNumber){
        return this.bankAccounts.indexOf(accountNumber);//will give int 0 or greater
    }
    private int findAccount(int accountNumber){
        for(int i=0;i<bankAccounts.size();i++){
            BankAccount account=this.bankAccounts.get(i);
            if(account.getAccountNumber()==accountNumber){
                return 1;
            }
        }
        return -1;
    }

    public boolean remoeveAccount(BankAccount accountNumber){
        int foundPosition=findAccount(accountNumber);
        if(foundPosition<0){
            System.out.println(accountNumber.getAccountNumber()+", was not found.");
            return false;
        }
        this.bankAccounts.remove(foundPosition);
        System.out.println(accountNumber.getAccountNumber()+", was deleted.");
        return true;
    }

    public void printAccounts() {
        for (int i = 0; i < this.bankAccounts.size(); i++) {
            System.out.println("Accounts List");
            // OR
//            BankAccount account=this.bankAccounts.get(i);
//            System.out.println((i+1)+"."+account.getAccountNumber());
//
            System.out.println((i + 1) + "." +
                    this.bankAccounts.get(i).getAccountNumber());

        }
    }

    public int queryBankAccount(BankAccount account){
        if(findAccount(account)>=0){
            return account.getAccountNumber();
        }
        return -1;
    }
    public BankAccount queryBankAccount(int accountNumber){
        int position=findAccount(accountNumber);
        if(position>=0){
            return this.bankAccounts.get(position);
        }
        return  null;

    }
}







