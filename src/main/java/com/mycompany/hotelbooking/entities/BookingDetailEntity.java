/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "booking_detail")
public class BookingDetailEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private double price;
    
    
    
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private BookingEntity booking;
    
    @OneToMany(mappedBy = "bookingDetail")
    private List<GuestRoomEntity>guestRoom;
    
    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity room;
    
    @OneToMany(mappedBy = "bookingDetail",orphanRemoval = true,cascade = CascadeType.ALL)
    private List<ServiceBookingRoomEntity> serviceBookingRoom;

    

    
    
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

    public BookingEntity getBooking() {
        return booking;
    }

    public void setBooking(BookingEntity booking) {
        this.booking = booking;
    }

    public List<GuestRoomEntity> getGuestRoom() {
        return guestRoom;
    }

    public void setGuestRoom(List<GuestRoomEntity> guestRoom) {
        this.guestRoom = guestRoom;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    public List<ServiceBookingRoomEntity> getServiceBookingRoom() {
        return serviceBookingRoom;
    }

    public void setServiceBookingRoom(List<ServiceBookingRoomEntity> serviceBookingRoom) {
        this.serviceBookingRoom = serviceBookingRoom;
    }
    
    
}
