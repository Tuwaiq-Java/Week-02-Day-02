package com.example.springday02.model;

public class Withdraw {

    private int ID;
    private double amount;

    public Withdraw(int ID, double amount) {
        this.ID = ID;
        this.amount = amount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
