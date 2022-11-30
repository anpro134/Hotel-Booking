/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Service {
    private long id;
   
    private String name;
    
    private double price;
    
    private String location;
    
    
    private Date openTime;
    
    
    private Date closeTime;
    
    private String description;
    
    private String status;
    
    
    
   
    
    
    
    private List<ServiceBookingRoom>serviceBookingRoom;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ServiceBookingRoom> getServiceBookingRoom() {
        return serviceBookingRoom;
    }

    public void setServiceBookingRoom(List<ServiceBookingRoom> serviceBookingRoom) {
        this.serviceBookingRoom = serviceBookingRoom;
    }
    
    
}
