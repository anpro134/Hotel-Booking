/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.controller.user;

import com.mycompany.hotelbooking.entities.BookingDetailEntity;
import com.mycompany.hotelbooking.entities.BookingEntity;
import com.mycompany.hotelbooking.entities.RoomEntity;
import com.mycompany.hotelbooking.service.RoomService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {
    
    @Autowired
    private RoomService roomService;
    
    @Autowired
    HttpSession session;
    
    @Autowired
    HttpServletRequest request;
    
    @RequestMapping("/check-available")
    public String checkAvailable(Model model,@ModelAttribute("booking")BookingEntity booking) throws ParseException{
        int numberAdult=booking.getNumberAdult();
        int numberChild=booking.getNumberChild();
        String checkOutString=request.getParameter("checkOutString");
        Date checkOut=convertDate(checkOutString);
        
        String checkInString=request.getParameter("checkInString");
        Date checkIn=convertDate(checkInString);
        System.out.println("CheckIn "+checkIn+
                            "CheckOut "+checkOut);
        booking.setCheckIn(checkIn);
        booking.setCheckOut(checkOut);
        session.setAttribute("booking", booking);
        List<RoomEntity> room=roomService.getRoomAvailable(numberAdult, numberChild);
        model.addAttribute("rooms",room );
        return "user/available-room";
    }
    
    @RequestMapping("/select-room")
    public String selecRoom(Model model,@RequestParam("id")long id){
        RoomEntity room=roomService.findByRoomId(id);
        BookingEntity bookingEntity=(BookingEntity) session.getAttribute("booking");
        bookingEntity.setCheckIn(new Date());
        bookingEntity.setCheckOut(new Date());
        bookingEntity.setPrice(room.getRoomCategory().getPrice());
        BookingDetailEntity bookingDetailEntity=new BookingDetailEntity();
        bookingDetailEntity.setRoom(room);
        session.setAttribute("booking", bookingEntity);
        
        return "user/available-room";
    }
    public Date convertDate(String Date) throws ParseException{
        
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(Date);
        return date;
    }
    
}
