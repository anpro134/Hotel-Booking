/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.controller.user;

import com.mycompany.hotelbooking.entities.AccountEntity;
import com.mycompany.hotelbooking.entities.BookingDetailEntity;
import com.mycompany.hotelbooking.entities.RoomCategoryEntity;
import com.mycompany.hotelbooking.entities.RoomEntity;
import com.mycompany.hotelbooking.entities.ServiceDetailEntity;
import com.mycompany.hotelbooking.service.AccountService;
import com.mycompany.hotelbooking.service.ImageService;
import com.mycompany.hotelbooking.service.ManageRoomService;
import com.mycompany.hotelbooking.service.RoomCategoryService;
import com.mycompany.hotelbooking.service.ServiceService;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private RoomCategoryService roomCategoryService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ManageRoomService manageRoomService;

    @Autowired
    HttpSession session;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("rooms", roomCategoryService.getRoomCategory());
        model.addAttribute("images", imageService.images());
        model.addAttribute("services", serviceService.getServices());
        session.removeAttribute("booking");
        if (session.getAttribute("bookingDetails") != null) {
            List<BookingDetailEntity> bookingDetailEntitys = (List<BookingDetailEntity>) session.getAttribute("bookingDetails");
            bookingDetailEntitys.removeAll(bookingDetailEntitys);
            List<RoomEntity> rooms = (List<RoomEntity>) session.getAttribute("roomSession");

            rooms.removeAll(rooms);
        }
        if (session.getAttribute("serviceDetail") != null) {
            List<ServiceDetailEntity> detailEntitys = (List<ServiceDetailEntity>) session.getAttribute("serviceDetail");
            detailEntitys.removeAll(detailEntitys);
        }

        if (request.getUserPrincipal() != null) {
            String email = request.getUserPrincipal().getName();

            AccountEntity accountEntity = accountService.getAccount(email);
            session.setAttribute("user", accountEntity);

        }
        return "include/index";
    }

    @RequestMapping("/login")
    public String checkloginPage(Model model, @RequestParam(value = "error", required = false) boolean error
    ) {
        if (error == true) {
            model.addAttribute("typeMessage", "fail");
            model.addAttribute("message", "Login Fail!!!");
        }

        return "user/login";
    }

    @RequestMapping("/rooms")
    public String viewRooms(Model model, @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        manageRoomService.viewRoomPage(page, size, model);
        model.addAttribute("images", imageService.images());
        return "user/room/rooms";
    }

    @RequestMapping("/search-room")
    public String searchRooms(Model model, @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            @RequestParam("value") String value) {
        manageRoomService.seachRoomPage(value, page, size, model);
        model.addAttribute("images", imageService.images());
        return "user/room/rooms";
    }

    @RequestMapping("/services")
    public String viewServices(Model model) {
        model.addAttribute("services", serviceService.getServices());
        model.addAttribute("images", imageService.images());
        return "user/services/services";
    }

    @RequestMapping("/register")
    public String registerPage(Model model) {
        return "user/login/register";
    }

    @RequestMapping("/403")
    public String accessDenied(Model model) {
        return "403Page";
    }

}
