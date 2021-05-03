package com.example.itpg7;

public class ShareModel {

    String price;
    String volume;
    String name;


    public ShareModel(String price, String volume,String name )
    {
        this.name = name;
        this.price = price;
        this.volume = volume;
    }

    public ShareModel(){}

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
