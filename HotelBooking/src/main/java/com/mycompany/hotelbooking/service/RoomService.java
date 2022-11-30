/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.service;

import com.mycompany.hotelbooking.entities.RoomEntity;
import com.mycompany.hotelbooking.repository.RoomRepository;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;
    
    public List<RoomEntity> getRoomAvailable(int numberAdult,int numberChild){
        List<RoomEntity> roomEntitys=roomRepository.roomAvailable(numberAdult, numberChild);
        if(!roomEntitys.isEmpty()){
            return roomEntitys;
        }
        return new ArrayList<>();
    }
    
    public RoomEntity findByRoomId(long id){
        Optional<RoomEntity> roomEntity=roomRepository.findById(id);
        if(roomEntity.isPresent()){
            return roomEntity.get();
        }
        return new RoomEntity();
    }
}
