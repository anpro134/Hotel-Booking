/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.service;

import com.mycompany.hotelbooking.entities.RoomCategoryEntity;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ManageRoomService {
    
    @Autowired
    private RoomCategoryService roomCategoryService;
    
    public void viewRoomPage(Optional<Integer> page,Optional<Integer> size,Model model){
        int currentPage=page.orElse(1);
        int pageSize=size.orElse(2);
        Page<RoomCategoryEntity> 
        pageRoom= roomCategoryService.pageRoomCategoryEntity(currentPage-1, pageSize, Sort.by("name").ascending());
        int totalPages=pageRoom.getTotalPages();
        model.addAttribute("action", "view");
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("rooms", pageRoom);
    }
    public void seachRoomPage(String value,Optional<Integer> page,Optional<Integer> size,Model model){
        int currentPage=page.orElse(1);
        int pageSize=size.orElse(2);
        Page<RoomCategoryEntity> 
        pageRoom= roomCategoryService.findRoomCategoryByName(value, currentPage-1, pageSize,Sort.by("id").ascending());
        int totalPages=pageRoom.getTotalPages();
        model.addAttribute("action", "search");
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("value", value);
        model.addAttribute("rooms", pageRoom);
    }
    
}
