/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.service;

import com.mycompany.hotelbooking.entities.AccountBanking;
import com.mycompany.hotelbooking.entities.AccountEntity;
import com.mycompany.hotelbooking.entities.BookingDetailEntity;
import com.mycompany.hotelbooking.entities.BookingEntity;
import com.mycompany.hotelbooking.entities.PaymentEntity;
import com.mycompany.hotelbooking.entities.RoleEntity;
import com.mycompany.hotelbooking.entities.RoomEntity;
import com.mycompany.hotelbooking.enums.UserStatus;
import com.mycompany.hotelbooking.repository.AccountRepository;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingDetailService bookingDetailService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private AccountBankService accountBankService;

    @Autowired
    HttpSession session;

    @Autowired
    private PaymentService paymentService;

    public AccountEntity getAccount(String email) {
        AccountEntity accountEntity = accountRepository.findByEmail(email);
        if (accountEntity != null) {
            return accountEntity;
        }
        return new AccountEntity();
    }

    public void saveAccount(AccountEntity accountEntity) {
        accountRepository.save(accountEntity);
    }

    public void cancelBookingService(long id, Model model) {
        BookingEntity bookingEntity = bookingService.getBooking(id);
        List<BookingDetailEntity> bookingDetailEntitys = bookingDetailService.getBookingDetailByBookingId(id);

        PaymentEntity paymentEntity = paymentService.getPaymentByBookingId(bookingEntity.getId());
        AccountBanking accountBanking = accountBankService.getAccountBankByPaymentId(paymentEntity.getId());

        Date checkIn = bookingEntity.getCheckIn();

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(checkIn);
        calendar.add(Calendar.DATE, -1);

        checkIn = calendar.getTime();
        Date now = new Date();

        if (now.before(checkIn)) {
            double invoice20 = bookingEntity.getPrice() * 20 / 100;
            double invoice80 = bookingEntity.getPrice() - invoice20;

            accountBanking.setBalance(accountBanking.getBalance() + invoice80);
            accountBankService.saveAccount(accountBanking);
            bookingService.deleteBooking(id);
            model.addAttribute("message", "Cancel booking successfully");
            model.addAttribute("typeMessage", "success");
        } else {
            bookingEntity.setStatus("3");
            bookingService.saveBooking(bookingEntity);
            model.addAttribute("message", "It's too late to cancel the booking");
            model.addAttribute("typeMessage", "fail");

        }

    }

    public void registerUser(AccountEntity account) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(account.getPassword());
        account.setPassword(password);
        RoleEntity roleEntity = roleService.getRoleUser();
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleEntity);
        account.setUserRoles(roles);
        account.setStatus(UserStatus.BLOCK);

    }
}
