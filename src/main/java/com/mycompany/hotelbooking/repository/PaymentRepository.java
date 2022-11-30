/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.repository;

import com.mycompany.hotelbooking.entities.PaymentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public interface PaymentRepository extends CrudRepository<PaymentEntity, Long>{
    
    @Query(value = "select p.* from payment p join booking b on p.booking_id=b.id\n" +
"where b.id=? ",nativeQuery = true)
    PaymentEntity getPaymentByBookingId(long id);
}
