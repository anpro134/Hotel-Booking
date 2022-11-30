/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.model;

import java.util.List;

/**
 *
 * @author DELL
 */
public class BookingDetail {
    private long id;
    
    private double price;
    
    
    private Booking booking;
    
    
    
    
    
//    private RoomEntity room;
    
    
    private List<ServiceBookingRoom> serviceBookingRoom;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public List<ServiceBookingRoom> getServiceBookingRoom() {
        return serviceBookingRoom;
    }

    public void setServiceBookingRoom(List<ServiceBookingRoom> serviceBookingRoom) {
        this.serviceBookingRoom = serviceBookingRoom;
    }
    
    
}
