package com.example.banksystem.model;

public class Customer {
    private String id;
    private String username;
    private Integer balance;

    public Customer(String id, String username, Integer balance) {
        this.id = id;
        this.username = username;
        this.balance = 0;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
