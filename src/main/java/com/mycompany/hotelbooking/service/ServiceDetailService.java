/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.service;

import com.mycompany.hotelbooking.entities.ServiceDetailEntity;
import com.mycompany.hotelbooking.repository.ServiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDetailService {
    
    @Autowired
    private ServiceDetailRepository serviceDetailRepository;
    
    public void saveServiceDetail(ServiceDetailEntity serviceDetailEntity){
        serviceDetailRepository.save(serviceDetailEntity);
    }
}
