package kz.abzal.Entities;

public class User {
    private int id; //User's fields from database
    private String full_name;
    private int balance;
    private int deposit_balance;
    private int credit_balance;

    //bunch of getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getDeposit_balance() {
        return deposit_balance;
    }

    public void setDeposit_balance(int deposit_balance) {
        this.deposit_balance = deposit_balance;
    }

    public int getCredit_balance() {
        return credit_balance;
    }

    public void setCredit_balance(int credit_balance) {
        this.credit_balance = credit_balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", balance=" + balance +
                ", deposit_balance=" + deposit_balance +
                ", credit_balance=" + credit_balance +
                '}';
    }
}
