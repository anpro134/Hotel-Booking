/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.service;

import com.mycompany.hotelbooking.entities.ServiceBookingRoomEntity;
import com.mycompany.hotelbooking.repository.ServiceBookingRoomRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Service
public class ServiceBookingRoomService {
    
    @Autowired
    private  ServiceBookingRoomRepository serviceBookingRoomRepository;
    
    
    public void saveServiceBookingRoom(ServiceBookingRoomEntity serviceBookingRoomEntity){
        serviceBookingRoomRepository.save(serviceBookingRoomEntity);
    }
    public ServiceBookingRoomEntity getSBRById(long id){
        Optional<ServiceBookingRoomEntity> serviceBookingRoomEntity=serviceBookingRoomRepository.findById(id);
        if(serviceBookingRoomEntity.isPresent()){
            return serviceBookingRoomEntity.get();
        }
        return new ServiceBookingRoomEntity();
    }
}
