/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.service;

import com.mycompany.hotelbooking.entities.AccountBanking;
import com.mycompany.hotelbooking.repository.AccountBankRepository;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountBankService {
    
    @Autowired
    private AccountBankRepository accountBankRepository;
    
    public AccountBanking findByCardNumberAndExpiryDateAndCvvCode(String cNumber,long expiryDateYear,long expiryDateMonth,String cvvCode,String cardHolderName){
        AccountBanking account=accountBankRepository.findByCardNumberAndExpiryDateAndCvvCode(cNumber, expiryDateYear, expiryDateMonth, cvvCode, cardHolderName);
        if(account !=null){
            return account;
        }else{
            return new AccountBanking();
        }
    }
    public void saveAccount(AccountBanking accountBanking){
        accountBankRepository.save(accountBanking);
    }
    public AccountBanking findByCardNumberAndCvvCode(String cNumber,String cvvCode){
        AccountBanking account=accountBankRepository.findByCardNumberAndCvvCode(cNumber, cvvCode);
        if(account !=null){
            return account;
        }else{
            return new AccountBanking();
        }
    }
    
    public AccountBanking getAccountBankByPaymentId(long id){
        AccountBanking accountBanking=accountBankRepository.getAccountBankByPaymentId(id);
        if(accountBanking!= null){
            return accountBanking;
        }
        return new AccountBanking();
    }
}
