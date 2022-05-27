package com.example.springday02.model;
// with darw samw
//transfer id from to id
public class Deposit {

    private String ID ;
    private double amount;

    public Deposit(String ID, double amount) {
        this.ID = ID;
        this.amount = amount;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
