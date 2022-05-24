package model.springex;

public class Customer {
    private int id;
    private String username;
    private int balance=0;

    public Customer(int id, String username, int balance) {
        this.id = id;
        this.username = username;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBalance() {

        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
