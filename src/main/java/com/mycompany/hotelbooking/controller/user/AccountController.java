/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.controller.user;

import com.mycompany.hotelbooking.entities.AccountBanking;
import com.mycompany.hotelbooking.entities.AccountEntity;
import com.mycompany.hotelbooking.entities.BookingDetailEntity;
import com.mycompany.hotelbooking.entities.BookingEntity;
import com.mycompany.hotelbooking.entities.PaymentEntity;
import com.mycompany.hotelbooking.entities.RoleEntity;
import com.mycompany.hotelbooking.entities.RoomEntity;
import com.mycompany.hotelbooking.enums.Gender;
import com.mycompany.hotelbooking.enums.UserStatus;
import com.mycompany.hotelbooking.service.AccountBankService;
import com.mycompany.hotelbooking.service.AccountService;
import com.mycompany.hotelbooking.service.BookingDetailService;
import com.mycompany.hotelbooking.service.BookingService;
import com.mycompany.hotelbooking.service.PaymentService;
import com.mycompany.hotelbooking.service.RoleService;
import com.mycompany.hotelbooking.service.RoomService;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

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
    private PaymentService paymentService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;

    @Autowired
    JavaMailSender mailSender;

    @RequestMapping("/manage-account")
    public String showInfor(Model model, @RequestParam(name = "message", required = false) String message,
            @RequestParam(name = "typeMessage", required = false) String typeMessage) {
        String email = request.getUserPrincipal().getName();
        AccountEntity accountEntity = accountService.getAccount(email);
        model.addAttribute("gender", Arrays.asList(Gender.values()));
        model.addAttribute("typeMessage", typeMessage);
        model.addAttribute("message", message);
        session.setAttribute("user", accountEntity);
        return "user/account/account";
    }

    @RequestMapping("/update-user")
    public String updateUser(@ModelAttribute("account") AccountEntity accountEntity) {

        accountEntity.setUserRoles(roleService.getRoles(accountEntity.getEmail()));
        accountService.saveAccount(accountEntity);
        return "redirect:/manage-account?message=Update Sucessfully!!!!&typeMessage=success";
    }

    @RequestMapping("/change-password")
    public String changePassword(Model model) {
        AccountEntity accountEntity = (AccountEntity) session.getAttribute("user");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String existingPassword = request.getParameter("password");
        String dbPassword = accountEntity.getPassword();
        String newPassword = request.getParameter("newPassword");
        String passwordConfirm = request.getParameter("passwordConfirm");
        if (passwordEncoder.matches(existingPassword, dbPassword)) {
            if (newPassword.equals(passwordConfirm)) {
                String password = passwordEncoder.encode(newPassword);
                accountEntity.setPassword(password);
                accountService.saveAccount(accountEntity);
                return "redirect:/manage-account?message=Update Successfully&typeMessage=success";
            }
            model.addAttribute("message", "The  password does not match the confirmation password");
            model.addAttribute("typeMessage", "fail");
            model.addAttribute("gender", Arrays.asList(Gender.values()));
            return "user/account/account";
        }
        model.addAttribute("message", "Password does not match");
        model.addAttribute("typeMessage", "fail");
        model.addAttribute("gender", Arrays.asList(Gender.values()));
        return "user/account/account";
    }

    @RequestMapping("/manage-user-booking")
    public String getBookings(Model model,@RequestParam(name = "message",required = false)String message,
        @RequestParam(name = "typeMessage",required = false)String typeMessage    ) {
        String email = request.getUserPrincipal().getName();
        AccountEntity accountEntity = accountService.getAccount(email);
        List<BookingEntity> bookings = (List<BookingEntity>) bookingService.getBookingByUserId(accountEntity.getId());
        model.addAttribute("bookings", bookings);
        model.addAttribute("message",message );
        model.addAttribute("typeMessage", typeMessage);
        return "user/account/history-booking";
    }

    @RequestMapping("/view-detail-booking")
    public String viewDetailBooking(Model model, @RequestParam("id") long id) {
        List<BookingDetailEntity> bookingDetailEntitys = bookingDetailService.getBookingDetailByBookingId(id);
        model.addAttribute("bookingDetails", bookingDetailEntitys);
        return "user/account/view-booking-detail";
    }

    @RequestMapping("/cancelBooking")
    public String cancelBooking(Model model, @RequestParam("id") long id) {
        
        accountService.cancelBookingService(id,model);
        return "redirect:/manage-user-booking";
    }

    @RequestMapping("/result-register")
    public String resultRegister(Model model, @ModelAttribute("account") AccountEntity account) throws MessagingException {
        AccountEntity accountEntity = accountService.getAccount(account.getEmail());
        if (accountEntity.getId() > 0) {
            model.addAttribute("message", "Email already used");
            model.addAttribute("typeMessage", "fail");
            model.addAttribute("account", account);
            return "user/login/register";
        }
        accountService.registerUser(account);
        accountService.saveAccount(account);
        String siteUrl = getSiteURL(request);
        sendEmail(account, siteUrl);
        model.addAttribute("typeMessage", "success");
        model.addAttribute("message", "Sign Up Success. To use the account you must activate it. Enter your email to check");
        return "user/login/register";
    }

    public void sendEmail(AccountEntity account, String siteUrl) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("an8112002pro@gmail.com");
        helper.setTo("an81102134@gmail.com");
        helper.setSubject("Register Account");
        String content = "You have registered an account at our hotel"
                + " Click here to activate your account "
                + " <h4><a href=\"[[URL]]\" target=\"_self\" >Activate Account</a></h4>";
        String orderUrl = siteUrl + "/active-account?email=" + account.getEmail();
        content = content.replace("[[URL]]", orderUrl);
        helper.setText(content, true);

        mailSender.send(message);
        System.out.println("Mail Send Successfully.......");
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @RequestMapping("/active-account")
    public String activeAccount(Model model, @RequestParam("email") String email) {
        AccountEntity accountEntity = accountService.getAccount(email);
        accountEntity.setStatus(UserStatus.ACTIVE);
        accountService.saveAccount(accountEntity);
        model.addAttribute("message", "Account Activation Successful");
        model.addAttribute("typeMessage", "success");
        return "user/login";
    }

}
