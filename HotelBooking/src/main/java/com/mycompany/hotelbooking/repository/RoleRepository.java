/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelbooking.repository;


import com.mycompany.hotelbooking.entities.RoleEntity;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Set<RoleEntity> findByAccount_Email(String email);
    
    @Query(value = "select * from role r where r.role= 'ROLE_USER'",nativeQuery = true)
    RoleEntity findRoleUser();
}
