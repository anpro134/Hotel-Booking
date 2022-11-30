/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.utils;

import com.mycompany.hotelbooking.entities.ServiceDetailEntity;
import com.mycompany.hotelbooking.model.Booking;
import com.mycompany.hotelbooking.model.Service;
import com.mycompany.hotelbooking.model.ServiceDetail;

/**
 *
 * @author DELL
 */
public class ServiceDetailUtil {
    public static ServiceDetail convertServiceDetailEntityToServiceDetail(ServiceDetailEntity serviceDetailEntity){
        ServiceDetail serviceDetail=new ServiceDetail();
        if(serviceDetailEntity!=null){
            serviceDetail.setName(serviceDetailEntity.getName());
            serviceDetail.setPrice(serviceDetailEntity.getPrice());
            if(serviceDetailEntity.getBooking()!=null){
                Booking b=new Booking();
                b.setPrice(serviceDetailEntity.getBooking().getPrice());
                serviceDetail.setBooking(b);
            }
            if(serviceDetailEntity.getService()!=null){
                Service service=new Service();
                service.setName(serviceDetailEntity.getService().getName());
                service.setPrice(serviceDetailEntity.getService().getPrice());
                serviceDetail.setService(service);
            }
        }
        return serviceDetail;
    }
}
