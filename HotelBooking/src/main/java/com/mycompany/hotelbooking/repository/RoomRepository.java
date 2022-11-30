/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.repository;

import com.mycompany.hotelbooking.entities.RoomEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, Long>{
    
    @Query(value = "select * from room r join room_category rc on r.room_category_id=rc.id where \n" +
" (rc.number_adult=?1 or rc.number_adult>?1) and (rc.number_child>?2 or rc.number_child=?2)\n" +
" and r.status='unused'",nativeQuery = true)
    List<RoomEntity>roomAvailable(int numberAdult,int numberChild);
}
