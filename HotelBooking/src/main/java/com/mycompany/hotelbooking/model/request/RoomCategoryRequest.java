/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.model.request;

import com.mycompany.hotelbooking.entities.ImageEntity;
import com.mycompany.hotelbooking.entities.RoomEntity;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Cuiqu
 */
public class RoomCategoryRequest {

    private String name;

    private String description;

    private double price;

    private String area;

    private int numberBed;

    private int numberAdult;
    
    private int numberChild;


    private List<RoomEntity> room;

    private List<ImageEntity> image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getNumberBed() {
        return numberBed;
    }

    public void setNumberBed(int numberBed) {
        this.numberBed = numberBed;
    }

    public int getNumberAdult() {
        return numberAdult;
    }

    public void setNumberAdult(int numberAdult) {
        this.numberAdult = numberAdult;
    }

    public int getNumberChild() {
        return numberChild;
    }

    public void setNumberChild(int numberChild) {
        this.numberChild = numberChild;
    }

    

    

    public List<RoomEntity> getRoom() {
        return room;
    }

    public void setRoom(List<RoomEntity> room) {
        this.room = room;
    }

    public List<ImageEntity> getImage() {
        return image;
    }

    public void setImage(List<ImageEntity> image) {
        this.image = image;
    }
}
