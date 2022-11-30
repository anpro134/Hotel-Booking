/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.service;


import com.mycompany.hotelbooking.entities.PromotionEntity;
import com.mycompany.hotelbooking.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {
    
    @Autowired
    private PromotionRepository promotionRepository;
    
    public PromotionEntity getPromotion(String code){
        PromotionEntity promotion=promotionRepository.getPromotion(code);
        if(promotion !=null ){
            return promotion;
        }
        return new PromotionEntity();
    }
    public void savePromotion(PromotionEntity promotionEntity){
        promotionRepository.save(promotionEntity);
    }
}
