/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.service;

import com.mycompany.hotelbooking.entities.ServiceEntity;
import com.mycompany.hotelbooking.repository.ServiceRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {
    
    @Autowired
    private ServiceRepository serviceRepository;
    
    public List<ServiceEntity>getServices(){
        List<ServiceEntity>services=(List<ServiceEntity>) serviceRepository.findAll();
        if(!services.isEmpty()){
            return services;
        }
        return new ArrayList<>();
    }
    
    public ServiceEntity getServiceById(long id){
        Optional<ServiceEntity> serviceEntity=serviceRepository.findById(id);
        if(serviceEntity.isPresent()){
            return serviceEntity.get();
        }
        return new ServiceEntity();
    }
}
