package com.example.itpg7;

public class ClientModel {

    String name;
    String dob;
    String region;
    String accounttype;
    String occupation;
    String language;
    String nationality;
    String portfolio;


    public ClientModel(String name, Integer ID,String dob, String region, String accounttype, String occupation, String language, String nationality, String portfolio) {

        this.name = name;
        this.dob = dob;
        this.region = region;
        this.accounttype = accounttype;
        this.occupation = occupation;
        this.nationality = nationality;
        this.portfolio = portfolio;
        this.language = language;

    }

    public ClientModel() {}



    public String getLanguage(){return language;}

    public void setLanguage(String language) {this.language = language;}

    public String getNationality(){return nationality;}

    public void setNationality(String nationality){this.nationality = nationality;}

    public String getPortfolio(){return portfolio;}

    public void setPortfolio(String portfolio){this.portfolio = portfolio;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoB() {
        return dob;
    }

    public void setDoB(String doB) {
        dob = doB;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        region = region;
    }

    public String getAccountType() {
        return accounttype;
    }

    public void setAccountType(String accountType) {
        accounttype = accountType;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String Occupation) {
        occupation = Occupation;
    }


}
