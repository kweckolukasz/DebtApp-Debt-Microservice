package com.debtApp.debt.model;

import javax.persistence.*;

@Entity
public class DebtItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(nullable = false)
    private String creditor;

    @Column(nullable = false)
    private String debtor;

    @Column(nullable = false)
    private int groupId;


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

    public String getCreditor() {
        return creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
    }

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
