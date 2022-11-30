/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.model.request;

import com.mycompany.hotelbooking.entities.BookingDetailEntity;
import com.mycompany.hotelbooking.entities.RoomCategoryEntity;
import java.util.List;

/**
 *
 * @author DELL
 */
public class RoomRequest {
    
    private String roomNumber;
    
    private String status;
    
    private List<BookingDetailEntity>bookingDetail;
    
    private RoomCategoryEntity roomCategory;

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BookingDetailEntity> getBookingDetail() {
        return bookingDetail;
    }

    public void setBookingDetail(List<BookingDetailEntity> bookingDetail) {
        this.bookingDetail = bookingDetail;
    }

    public RoomCategoryEntity getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(RoomCategoryEntity roomCategory) {
        this.roomCategory = roomCategory;
    }
    
    
}
