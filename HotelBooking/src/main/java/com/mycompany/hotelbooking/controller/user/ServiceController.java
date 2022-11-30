/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.controller.user;

import com.mycompany.hotelbooking.entities.RoomEntity;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ServiceController {
    
//    @Autowired
//    private RoomService roomService;
    
   @RequestMapping(value = "/hello-api",method=RequestMethod.GET)
    public Object helloApi(){
        return "Hello API";
    } 
    
//    @RequestMapping(value = "/room-available",method = RequestMethod.GET)
//    public Object roomAvailable(@RequestParam("numberAdult")int numberAdult,@RequestParam("numberChild")int numberChild){
//        List<RoomEntity>roomEntitys=roomService.roomAvailable(numberAdult, numberChild);
//        if(roomEntitys.size()>0){
//            return roomEntitys;
//        }
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }
    
}
