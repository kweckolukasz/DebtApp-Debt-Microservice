package com.debtApp.debt.model;

public class DebtItem {

    private int Id = 0;
    private String owner = "some debt owner";

    public DebtItem(int id) {
        Id = id;
    }

    public DebtItem() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
