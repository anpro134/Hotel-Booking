/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.controller.user.api;

import com.mycompany.hotelbooking.model.response.RoomResponse;
import com.mycompany.hotelbooking.service.RoomService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("booking")
public class BookingControllerAPI {
    
//    @Autowired
//    private RoomService roomService;
//    
//    @GetMapping("/hello-api")
//    public String helloAPI(){
//        return "Hello API";
//    }
//    
//    @GetMapping("/room-available")
//    public String getRoomAvaible(@RequestParam("numberAdult")int numberAdult,
//           @RequestParam("numberChild")int numberChild ){
//        List<RoomResponse>returnValue=new ArrayList<>();
//        
//        List<RoomDto>roomDtos=roomService.getRoomAvailable(numberChild, numberChild);
//        for(RoomDto dto:roomDtos){
//            RoomResponse response=new RoomResponse();
//            response.setId(dto.getId());
//            response.setBookingDetail(dto.getBookingDetail());
//            response.setRoomCategory(dto.getRoomCategory());
//            response.setRoomNumber(dto.getRoomNumber());
//            returnValue.add(response);
//        }
//        return returnValue.toString();
//    }
    
}
