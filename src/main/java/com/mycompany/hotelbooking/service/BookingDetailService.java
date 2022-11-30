/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.service;

import com.mycompany.hotelbooking.entities.BookingDetailEntity;
import com.mycompany.hotelbooking.repository.BookingDetailRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class BookingDetailService {
    
    @Autowired
    private BookingDetailRepository bookingDetailRepository;
    
    public void saveBookingDetail(BookingDetailEntity bookingDetailEntity){
        bookingDetailRepository.save(bookingDetailEntity);
    }
    
    public List<BookingDetailEntity> getBookingDetailByBookingId(long id){
        List<BookingDetailEntity> bookingDetails=bookingDetailRepository.getBookingDetailByBookingId(id);
        if(bookingDetails.size()>0){
            return bookingDetails;
        }
        return new ArrayList<>();
    }
    public BookingDetailEntity getBookingDetail(long id){
        Optional<BookingDetailEntity> bde=bookingDetailRepository.findById(id);
        if(bde.isPresent()){
            return bde.get();
        }
        return new BookingDetailEntity();
    }
}
