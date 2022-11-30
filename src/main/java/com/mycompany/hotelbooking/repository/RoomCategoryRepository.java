/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.repository;

import com.mycompany.hotelbooking.entities.RoomCategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomCategoryRepository  extends CrudRepository<RoomCategoryEntity, Long>{
    
    
    @Query(value = "select * from room_category ",nativeQuery = true)
    Page<RoomCategoryEntity>roomCategory(Pageable pageable);
        
    
    @Query(value = "select * from room_category rc where rc.name like %?1% ",nativeQuery = true)
    Page<RoomCategoryEntity>findRoomCategoryByName(String value,Pageable pageable);
    
    
}
