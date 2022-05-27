package com.example.springday02.Exerci;

public class CustomerClass {
    private String ID ;
    private String Username;
    private int Balance ;

    public CustomerClass(String ID, String username, int balance) {
        this.ID = ID;
        Username = username;
        Balance = balance;
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }
}
