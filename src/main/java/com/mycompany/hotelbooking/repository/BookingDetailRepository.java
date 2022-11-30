/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.repository;

import com.mycompany.hotelbooking.entities.BookingDetailEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public interface BookingDetailRepository extends CrudRepository<BookingDetailEntity, Long> {
    
    @Query(value = "select * from booking_detail bd join booking b on bd.booking_id=b.id where b.id=? ",nativeQuery = true)
    List<BookingDetailEntity>getBookingDetailByBookingId(long id);
}
