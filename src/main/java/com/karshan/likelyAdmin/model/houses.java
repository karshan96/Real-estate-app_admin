/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karshan.likelyAdmin.model;

/**
 *
 * @author Rasa Karshanguna
 */
public class houses {
    private String date;
    private String address;
    private String description;
    private String imageUrl;
    private String phone;
    private int amount;
    private int squrefoot;
    private int bathrooms;
    private int bedrooms;
    private int kitchen;
    private int garages;

    public houses(String date, String address, String description, String imageUrl, String phone, int amount, int squrefoot, int bathrooms, int bedrooms, int kitchen, int garages) {
        this.date = date;
        this.address = address;
        this.description = description;
        this.imageUrl = imageUrl;
        this.phone = phone;
        this.amount = amount;
        this.squrefoot = squrefoot;
        this.bathrooms = bathrooms;
        this.bedrooms = bedrooms;
        this.kitchen = kitchen;
        this.garages = garages;
    }

    public houses() {
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSqurefoot() {
        return squrefoot;
    }

    public void setSqurefoot(int squrefoot) {
        this.squrefoot = squrefoot;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getKitchen() {
        return kitchen;
    }

    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
    }

    public int getGarages() {
        return garages;
    }

    public void setGarages(int garages) {
        this.garages = garages;
    }
    
    
}
