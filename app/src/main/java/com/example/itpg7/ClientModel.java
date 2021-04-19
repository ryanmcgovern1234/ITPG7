package com.example.itpg7;

import java.util.Date;

public class ClientModel {

    String name;
    Integer ID;
    String DoB;
    String Region;
    String AccountType;
    String Occupation;
    Date kycdate;

    public ClientModel(String name, Integer ID,String DoB, String Region, String AccountType, String Occupation, Date kycdate) {

        this.name = name;
        this.ID = ID;
        this.DoB = DoB;
        this.Region = Region;
        this.AccountType = AccountType;
        this.Occupation = Occupation;
        this.kycdate = kycdate;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String doB) {
        DoB = doB;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String accountType) {
        AccountType = accountType;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public Date getKYCdate() {
        return kycdate;
    }

    public void setKYCdate(Date kycdate) {
        this.kycdate = kycdate;
    }
}
