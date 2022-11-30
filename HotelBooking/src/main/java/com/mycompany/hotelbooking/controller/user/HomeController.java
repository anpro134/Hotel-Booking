/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.controller.user;

import com.mycompany.hotelbooking.service.ImageService;
import com.mycompany.hotelbooking.service.RoomCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @RequestMapping(value ={"/", "/home"},method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("rooms",roomCategoryService.getRoomCategory());
        model.addAttribute("images", imageService.images());
        return "include/index";
    }
    @RequestMapping("/login")
    public String checkloginPage(Model model, @RequestParam(value = "error", required = false) boolean error
            ) {
        if (error==true) {
            model.addAttribute("typeMessage", "fail");
            model.addAttribute("message", "Login Fail!!!");
        }
        
        return "user/login";
    }
    @RequestMapping("/403")
    public String accessDenied(Model model) {
        return "403Page";
    }
    
}
