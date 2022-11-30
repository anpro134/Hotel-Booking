/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.repository;


import com.mycompany.hotelbooking.entities.PromotionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository  extends CrudRepository<PromotionEntity, Long>{
    
    @Query(value = "select * from promotion  p where p.code=? ",nativeQuery = true)
    PromotionEntity getPromotion(String code);
}
