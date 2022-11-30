/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.service;

import com.mycompany.hotelbooking.entities.ImageEntity;
import com.mycompany.hotelbooking.repository.ImageRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    
    @Autowired
    private  ImageRepository imageRepository;
    
    public List<ImageEntity>images(){
        List<ImageEntity>imageEntitys=(List<ImageEntity>) imageRepository.findAll();
        if(!imageEntitys.isEmpty()){
            return imageEntitys;
        }
        return new ArrayList<>();
    }
}
