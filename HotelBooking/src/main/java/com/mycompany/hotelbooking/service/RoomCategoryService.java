/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.service;

import com.mycompany.hotelbooking.entities.RoomCategoryEntity;
import com.mycompany.hotelbooking.repository.RoomCategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
