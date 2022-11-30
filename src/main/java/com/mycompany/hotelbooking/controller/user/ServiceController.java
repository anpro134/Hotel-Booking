/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.controller.user;

import com.mycompany.hotelbooking.entities.BookingDetailEntity;
import com.mycompany.hotelbooking.entities.BookingEntity;
import com.mycompany.hotelbooking.entities.RoomEntity;
import com.mycompany.hotelbooking.entities.ServiceBookingRoomEntity;
import com.mycompany.hotelbooking.entities.ServiceDetailEntity;
import com.mycompany.hotelbooking.entities.ServiceEntity;
import com.mycompany.hotelbooking.model.Booking;
import com.mycompany.hotelbooking.model.BookingDetail;
import com.mycompany.hotelbooking.model.ServiceBookingRoom;
import com.mycompany.hotelbooking.model.ServiceDetail;
import com.mycompany.hotelbooking.service.RoomService;
import com.mycompany.hotelbooking.service.ServiceService;
import com.mycompany.hotelbooking.utils.BookingDetailUtil;
import com.mycompany.hotelbooking.utils.BookingUtil;
import com.mycompany.hotelbooking.utils.ServiceBookingRoomUtil;
import com.mycompany.hotelbooking.utils.ServiceDetailUtil;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private HttpSession session;

    @Autowired
    HttpServletRequest request;

    @RequestMapping(value = "/hello-api", method = RequestMethod.GET)
    public Object helloApi() {
        return "Hello API";
    }

    @RequestMapping(value = "/select-service", method = RequestMethod.GET)
    public ResponseEntity<List<ServiceDetail>> selectService(@RequestParam("serviceId") long serviceId,
            @RequestParam("roomId") long roomId) {
        List<BookingDetailEntity> bookingDetailEntitys = (List<BookingDetailEntity>) session.getAttribute("bookingDetails");

        List<ServiceDetailEntity> serviceDetails = (List<ServiceDetailEntity>) session.getAttribute("serviceDetail");
        if (serviceDetails == null) {
            serviceDetails = new ArrayList<>();
        }

        RoomEntity roomEntity = roomService.findByRoomId(roomId);
        ServiceEntity serviceEntity = serviceService.getServiceById(serviceId);
        BookingEntity bookingEntity = (BookingEntity) session.getAttribute("booking");
        boolean check = false;
        if (!serviceDetails.isEmpty()) {
            for (ServiceDetailEntity ser : new ArrayList<>(serviceDetails)) {
                if (ser.getRoom().getId() == roomId && ser.getService().getId() == serviceId) {
                    serviceDetails.remove(ser);
                    check=true;
                    break;
                } else {
                    check = false;
                    
                }
            }
        } else {
            check = false;
        }
        if (check == false) {
            ServiceDetailEntity serviceDetailEntity = new ServiceDetailEntity();
            serviceDetailEntity.setBooking(bookingEntity);
            serviceDetailEntity.setService(serviceEntity);
            serviceDetailEntity.setPrice(serviceEntity.getPrice());
            serviceDetailEntity.setRoom(roomEntity);
            serviceDetailEntity.setName(serviceEntity.getName());
            serviceDetails.add(serviceDetailEntity);
        }

        bookingEntity.setPrice(countPrice(serviceDetails, bookingDetailEntitys));

        //convert BookingDetailEntity->BookingDetail
        List<ServiceDetail> serviceDetail = new ArrayList<>();
        for (ServiceDetailEntity s : serviceDetails) {
            ServiceDetail detail = ServiceDetailUtil.convertServiceDetailEntityToServiceDetail(s);
            serviceDetail.add(detail);
        }
        session.setAttribute("serviceDetail", serviceDetails);
        session.setAttribute("booking", bookingEntity);

        return new ResponseEntity<List<ServiceDetail>>(serviceDetail, HttpStatus.OK);

    }

    @RequestMapping(value = "/getBooking",method = RequestMethod.GET)
    public ResponseEntity<Booking>getBooking(){
        BookingEntity bookingEntity = (BookingEntity) session.getAttribute("booking");
        Booking b=BookingUtil.convertBookingEntityToBooking(bookingEntity);
        return new ResponseEntity<Booking>(b,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/cancelService", method = RequestMethod.GET)
    public ResponseEntity<List<ServiceDetail>> cancelService(@RequestParam("serviceId") long serviceId,
            @RequestParam("roomId") long roomId) {
        BookingEntity bookingEntity = (BookingEntity) session.getAttribute("booking");
        List<ServiceDetailEntity> detailEntitys = (List<ServiceDetailEntity>) session.getAttribute("serviceDetail");

        List<BookingDetailEntity> bookingDetailEntitys = (List<BookingDetailEntity>) session.getAttribute("bookingDetails");

        for (ServiceDetailEntity ser : new ArrayList<>(detailEntitys)) {
            if (ser.getRoom().getId() == roomId && ser.getService().getId() == serviceId) {
                detailEntitys.remove(ser);
            }
        }
        bookingEntity.setPrice(countPrice(detailEntitys, bookingDetailEntitys));
        List<ServiceDetail> serviceDetail = new ArrayList<>();
        for (ServiceDetailEntity s : detailEntitys) {
            ServiceDetail detail = ServiceDetailUtil.convertServiceDetailEntityToServiceDetail(s);
            serviceDetail.add(detail);
        }
        session.setAttribute("serviceDetail", detailEntitys);
        session.setAttribute("booking", bookingEntity);
        return new ResponseEntity<List<ServiceDetail>>(serviceDetail, HttpStatus.OK);
    }

    public double countPrice(List<ServiceDetailEntity> serviceDetails, List<BookingDetailEntity> bdes) {
        double countBookingDetail = 0;
        double countServiceDetail = 0;
        double count = 0;
        for (BookingDetailEntity bd : bdes) {

            countBookingDetail += bd.getPrice();
        }
        for (ServiceDetailEntity ser : serviceDetails) {
            countServiceDetail += ser.getPrice();
        }

        return count = countBookingDetail + countServiceDetail;
    }
    
}
