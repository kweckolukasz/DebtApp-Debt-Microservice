package com.debtApp.debt.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DebtItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(nullable = false)
    private int creditorId;

    @Column(nullable = false)
    private int debtorId;

    @Column(nullable = false)
    private int groupId;

    @Column(nullable = false)
    private int value;


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

    public int getCreditorId() {
        return creditorId;
    }

    public void setCreditorId(int creditorId) {
        this.creditorId = creditorId;
    }

    public int getDebtorId() {
        return debtorId;
    }

    public void setDebtorId(int debtorId) {
        this.debtorId = debtorId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
