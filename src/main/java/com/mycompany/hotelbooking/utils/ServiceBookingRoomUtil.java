/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.utils;

import com.mycompany.hotelbooking.entities.ServiceBookingRoomEntity;
import com.mycompany.hotelbooking.model.Booking;
import com.mycompany.hotelbooking.model.BookingDetail;
import com.mycompany.hotelbooking.model.Service;
import com.mycompany.hotelbooking.model.ServiceBookingRoom;

/**
 *
 * @author DELL
 */
public class ServiceBookingRoomUtil {
    
    public static ServiceBookingRoom convertServiceBookingRoomEntityToServiceBookingRoom(ServiceBookingRoomEntity bookingRoomEntity){
        ServiceBookingRoom serviceBookingRoom=new ServiceBookingRoom();
        if(bookingRoomEntity!=null){
            serviceBookingRoom.setPrice(bookingRoomEntity.getPrice());
            if(bookingRoomEntity.getBookingDetail()!=null){
                BookingDetail bd=new BookingDetail();
                bd.setPrice(bookingRoomEntity.getBookingDetail().getPrice());
                if(bookingRoomEntity.getBookingDetail().getBooking()!=null){
                    Booking b=new Booking();
                    b.setPrice(bookingRoomEntity.getBookingDetail().getBooking().getPrice());
                    bd.setBooking(b);
                }
                serviceBookingRoom.setBookingDetail(bd);
            }
            if(bookingRoomEntity.getService()!=null){
                Service service=new Service();
                service.setName(bookingRoomEntity.getService().getName());
                service.setPrice(bookingRoomEntity.getService().getPrice());
                service.setId(bookingRoomEntity.getService().getId());
                serviceBookingRoom.setService(service);
            }
        }
        return serviceBookingRoom;
    }
}
