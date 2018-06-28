package com.company;

public class BankAccount {
    private int accountNumber;

    public BankAccount(int anAccountNumber){
        this.accountNumber=anAccountNumber;

    }
    public int getAccountNumber(){
        return accountNumber;

    }

    public static BankAccount createBankAccount(int anAccountNumber){
        return new BankAccount(anAccountNumber);
    }

}
