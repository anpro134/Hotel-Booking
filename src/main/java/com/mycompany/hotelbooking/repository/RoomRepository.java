/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.repository;

import com.mycompany.hotelbooking.entities.RoomEntity;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, Long> {

    @Query(value = "select  r.* from  room r join room_category  rc on rc.id=r.room_category_id  \n"
            + "where rc.number_adult >=?1 && rc.number_child>=?2 and r.id\n"
            + "											 not in (                       \n"
            + " select r.id from room_category rc join room r on rc.id=r.room_category_id   \n"
            + "											join booking_detail bd on bd.room_id=r.id \n"
            + "                                            join booking b on b.id=bd.booking_id\n"
            + "                                            where rc.number_adult >=?1 && rc.number_child>=?2 and b.check_in between ?3 and ?4\n"
            + "                                            or b.check_out between ?3 and ?4\n"
            + "                                            or b.check_in < ?3 and b.check_out > ?4)", nativeQuery = true)
    List<RoomEntity> roomAvailable(int numberAdult, int numberChild, Date checkIn, Date checkOut);
}
