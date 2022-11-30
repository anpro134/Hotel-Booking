/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.service;

import com.mycompany.hotelbooking.entities.BookingDetailEntity;
import com.mycompany.hotelbooking.entities.BookingEntity;
import com.mycompany.hotelbooking.entities.RoomEntity;
import com.mycompany.hotelbooking.repository.BookingRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomService roomService;

    @Autowired
    private AccountBankService accountBankService;

    @Autowired
    HttpSession session;

    @Autowired
    private BookingDetailService bookingDetailService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ImageService imageService;

    public void saveBooking(BookingEntity bookingEntity) {
        bookingRepository.save(bookingEntity);
    }

    public List<BookingEntity> getBookingByUserId(long id) {
        List<BookingEntity> bookings = bookingRepository.getBookingByUserId(id);
        if (!bookings.isEmpty()) {
            return bookings;
        }
        return new ArrayList<>();
    }

    public BookingEntity getBooking(long id) {
        Optional<BookingEntity> bookingEntity = bookingRepository.findById(id);
        if (bookingEntity.isPresent()) {
            return bookingEntity.get();
        }
        return new BookingEntity();
    }

    public void deleteBooking(long id) {
        bookingRepository.deleteById(id);
    }

    public void selectRoom(long id, Model model) {
        RoomEntity room = roomService.findByRoomId(id);
        long day=(long) session.getAttribute("day");
        List<BookingDetailEntity> bookingDetails = (List<BookingDetailEntity>) session.getAttribute("bookingDetails");
        if (bookingDetails == null) {
            bookingDetails = new ArrayList<>();
        }
        List<RoomEntity> roomSession = (List<RoomEntity>) session.getAttribute("roomSession");
        if (roomSession == null) {
            roomSession = new ArrayList<>();
        }
        roomSession.add(room);
        BookingEntity bookingEntity = (BookingEntity) session.getAttribute("booking");
        bookingEntity.setBookingDate(new Date());
        double count = 0;

        BookingDetailEntity bookingDetailEntity = new BookingDetailEntity();
        bookingDetailEntity.setRoom(room);
        bookingDetailEntity.setPrice(room.getRoomCategory().getPrice()*day);

        bookingDetails.add(bookingDetailEntity);

        for (BookingDetailEntity bd : bookingDetails) {
            count += (bd.getPrice());
        }

        bookingEntity.setPrice(count);

        int numberAdult = bookingEntity.getNumberAdult();
        int numberChild = bookingEntity.getNumberChild();
        List<RoomEntity> rooms = roomService.getRoomAvailable(numberAdult, numberChild, bookingEntity.getCheckIn(), bookingEntity.getCheckOut());
        
           for( RoomEntity r:new ArrayList<>(roomSession)){
               for(RoomEntity rs:new ArrayList<>(rooms)){
                   if(r.getId()==rs.getId()){
                       rooms.remove(rs);
                   }
               }
           }
        

        session.setAttribute("roomSession", roomSession);
        session.setAttribute("bookingDetails", bookingDetails);
        session.setAttribute("booking", bookingEntity);
        model.addAttribute("images", imageService.images());
        model.addAttribute("rooms", rooms);
        model.addAttribute("bDetails", bookingDetails);
    }
}
