/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.repository;

import com.mycompany.hotelbooking.entities.AccountBanking;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountBankRepository extends CrudRepository<AccountBanking, Long> {

    @Query(value = "select * from account_banking a where a.card_number= ?1 and a.expiry_date_year= ?2 and a.expiry_date_month= ?3 and a.cvv_code= ?4 and a.cardholder_name= ?5", nativeQuery = true)
    AccountBanking findByCardNumberAndExpiryDateAndCvvCode(String cNumber, long expiryDateYear,long expiryDateMonth, String cvvCode, String cardholderName);

    @Query(value = "select * from account_banking a where a.card_number= ?1  and a.cvv_code= ?2", nativeQuery = true)
    AccountBanking findByCardNumberAndCvvCode(String cNumber, String cvvCode);

    @Query(value = "select ab.* from payment p join account_banking ab on p.accountbank_id=ab.id\n"
            + "where p.id=? ", nativeQuery = true)
    AccountBanking getAccountBankByPaymentId(long id);
}
