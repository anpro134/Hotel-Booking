/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.utils;

import com.mycompany.hotelbooking.entities.BookingDetailEntity;
import com.mycompany.hotelbooking.entities.ServiceBookingRoomEntity;
import com.mycompany.hotelbooking.model.Booking;
import com.mycompany.hotelbooking.model.BookingDetail;
import com.mycompany.hotelbooking.model.Service;
import com.mycompany.hotelbooking.model.ServiceBookingRoom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class BookingDetailUtil {
    public static BookingDetail convertBookingDetailEntityToBookingDetail(BookingDetailEntity bookingDetailEntity){
        BookingDetail bookingDetail=new BookingDetail();
        if(bookingDetailEntity!=null){
            bookingDetail.setPrice(bookingDetailEntity.getPrice());
            
            if(bookingDetailEntity.getBooking()!=null){
                Booking booking=new Booking();
                booking.setPrice(bookingDetailEntity.getBooking().getPrice());
               
                bookingDetail.setBooking(booking);
            }
            if(bookingDetailEntity.getServiceBookingRoom()!=null){
                List<ServiceBookingRoomEntity>serviceBookingRooms=bookingDetailEntity.getServiceBookingRoom();
                List<ServiceBookingRoom>serviceBooking=new ArrayList<>();
                
                for(ServiceBookingRoomEntity ser:serviceBookingRooms){
                    ServiceBookingRoom serviceBookingRoom=new ServiceBookingRoom();
                    serviceBookingRoom.setPrice(ser.getPrice());
                    //Set Service 
                    if(ser.getService()!=null){
                        Service service=new Service();
                        service.setId(ser.getService().getId());
                        service.setName(ser.getService().getName());
                        serviceBookingRoom.setService(service);
                    }
                    serviceBooking.add(serviceBookingRoom);
                    
                }
                bookingDetail.setServiceBookingRoom(serviceBooking);
            }
        }
        return bookingDetail;
    } 
        
}
