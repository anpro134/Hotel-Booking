/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.service;

import com.mycompany.hotelbooking.entities.PaymentEntity;
import com.mycompany.hotelbooking.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    
    public void savePayment(PaymentEntity paymentEntity){
        paymentRepository.save(paymentEntity);
    }
    public PaymentEntity getPaymentByBookingId(long id){
        PaymentEntity paymentEntity=paymentRepository.getPaymentByBookingId(id);
        if(paymentEntity !=null){
            return paymentEntity;
        }
        return new PaymentEntity();
    }
}
