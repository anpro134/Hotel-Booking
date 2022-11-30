/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "service")
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
   
    private String name;
    
    private double price;
    
    private String location;
    
    @Temporal(TemporalType.TIME)
    private Date openTime;
    
    @Temporal(TemporalType.TIME)
    private Date closeTime;
    
    private String description;
    
    private String status;
    
    @Transient
    private List<MultipartFile> imageFile;
    
    @OneToMany(mappedBy = "service")
    private List<ImageEntity> image;
    
    @OneToMany(mappedBy = "service")
    private List<ServiceBookingRoomEntity>serviceBookingRoom;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<MultipartFile> getImageFile() {
        return imageFile;
    }

    public void setImageFile(List<MultipartFile> imageFile) {
        this.imageFile = imageFile;
    }

    public List<ImageEntity> getImage() {
        return image;
    }

    public void setImage(List<ImageEntity> image) {
        this.image = image;
    }

    public List<ServiceBookingRoomEntity> getServiceBookingRoom() {
        return serviceBookingRoom;
    }

    public void setServiceBookingRoom(List<ServiceBookingRoomEntity> serviceBookingRoom) {
        this.serviceBookingRoom = serviceBookingRoom;
    }
    
    
}
