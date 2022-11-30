/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.service;

import com.mycompany.hotelbooking.entities.RoomCategoryEntity;
import com.mycompany.hotelbooking.repository.RoomCategoryRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class RoomCategoryService {
    
    @Autowired
    private RoomCategoryRepository roomCategoryRepository;
    
    public List<RoomCategoryEntity>getRoomCategory(){
        List<RoomCategoryEntity>roomCategoryEntitys=(List<RoomCategoryEntity>) roomCategoryRepository.findAll();
        if(!roomCategoryEntitys.isEmpty()){
            return roomCategoryEntitys;
        }
        return new ArrayList<>();
    }
    public Page<RoomCategoryEntity>pageRoomCategoryEntity(int currentPage,int pageSize,Sort sort){
        Page<RoomCategoryEntity>pages=roomCategoryRepository.roomCategory(PageRequest.of(currentPage, pageSize, sort));
        if(pages !=null){
            return pages;
        }
        return null;
    }
    
    public Page<RoomCategoryEntity>findRoomCategoryByName(String value,int currentPage,int pageSize,Sort sort){
        Page<RoomCategoryEntity>pages=roomCategoryRepository.findRoomCategoryByName(value,PageRequest.of(currentPage, pageSize,sort));
        if(pages !=null){
            return pages;
        }
        return null;
    }
    
    
}
