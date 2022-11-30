/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.utils;

import com.mycompany.hotelbooking.entities.BookingEntity;
import com.mycompany.hotelbooking.model.Booking;

/**
 *
 * @author DELL
 */
public class BookingUtil {
    public static Booking convertBookingEntityToBooking(BookingEntity bookingEntity){
        Booking b=new Booking();
        if(bookingEntity !=null){
            b.setPrice(bookingEntity.getPrice());
        }
        return b;
    }
}
