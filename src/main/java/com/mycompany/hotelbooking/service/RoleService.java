/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.service;

import com.mycompany.hotelbooking.entities.RoleEntity;
import com.mycompany.hotelbooking.repository.RoleRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    
    @Autowired
    private RoleRepository roleRepository;
    
    public Set<RoleEntity>getRoles(String email){
        Set<RoleEntity>roles=roleRepository.findByAccount_Email(email);
        if(roles !=null && roles.size()>0){
            return roles;
        }
        return new HashSet<>();   
    }
    public RoleEntity getRoleUser(){
        RoleEntity roleEntity=roleRepository.findRoleUser();
        if(roleEntity!=null){
            return roleEntity;
        }
        return null;
    }
}
