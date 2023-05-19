package com.example.task71p.model;

public class Advert {
    private String name, phoneNumber, description, date, location, type;
    private int advertID;

    public Advert() {
    }

    public Advert(int advertID, String name, String phoneNumber, String description, String date, String location, String type) {
        this.advertID = advertID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.date = date;
        this.location = location;
        this.type = type;
    }

    public Advert(String name, String phoneNumber, String description, String date, String location, String type) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.date = date;
        this.location = location;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAdvertID() {
        return advertID;
    }

    public void setAdvertID(int advertID) {
        this.advertID = advertID;
    }
}
