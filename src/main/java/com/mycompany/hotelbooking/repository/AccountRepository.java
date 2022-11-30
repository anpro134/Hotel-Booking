/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelbooking.repository;


import com.mycompany.hotelbooking.entities.AccountEntity;
import com.mycompany.hotelbooking.enums.UserStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

    AccountEntity findByEmailLikeAndStatusLike(String email,
            UserStatus status);
    
    @Query(value = "select * from account a where a.email=? ",nativeQuery = true)
    AccountEntity findByEmail(String email);
}
