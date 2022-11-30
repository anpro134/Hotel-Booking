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
import com.mycompany.hotelbooking.entities.PromotionEntity;
import com.mycompany.hotelbooking.entities.RoomEntity;
import com.mycompany.hotelbooking.entities.ServiceBookingRoomEntity;
import com.mycompany.hotelbooking.entities.ServiceDetailEntity;
import com.mycompany.hotelbooking.entities.ServiceEntity;
import com.mycompany.hotelbooking.service.AccountBankService;
import com.mycompany.hotelbooking.service.BookingDetailService;
import com.mycompany.hotelbooking.service.BookingService;
import com.mycompany.hotelbooking.service.ImageService;
import com.mycompany.hotelbooking.service.PaymentService;
import com.mycompany.hotelbooking.service.PromotionService;
import com.mycompany.hotelbooking.service.RoomService;
import com.mycompany.hotelbooking.service.ServiceBookingRoomService;
import com.mycompany.hotelbooking.service.ServiceDetailService;
import com.mycompany.hotelbooking.service.ServiceService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private ServiceDetailService serviceDetailService;

    @Autowired
    private AccountBankService accountBankService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingDetailService bookingDetailService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private ServiceBookingRoomService serviceBookingRoomService;

    @Autowired
    HttpSession session;

    @Autowired
    HttpServletRequest request;

    @Autowired
    JavaMailSender mailSender;

    @RequestMapping("/check-available")
    public String checkAvailable(Model model, @ModelAttribute("booking") BookingEntity booking) throws ParseException {
        int numberAdult = booking.getNumberAdult();
        int numberChild = booking.getNumberChild();
        String checkOutString = request.getParameter("checkOutString");
        Date checkOut = convertDate(checkOutString);

        String checkInString = request.getParameter("checkInString");
        Date checkIn = convertDate(checkInString);
        
            
        
        booking.setCheckIn(checkIn);
        booking.setCheckOut(checkOut);
        session.setAttribute("booking", booking);

        long duration = checkOut.getTime() - checkIn.getTime();

        long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);

        session.setAttribute("day", diffInDays);

        List<RoomEntity> room = roomService.getRoomAvailable(numberAdult, numberChild, booking.getCheckIn(), booking.getCheckOut());

        if (room.isEmpty()) {
            model.addAttribute("message", "Couldn't find the room you wanted");
            return "include/index";
        }
        model.addAttribute("images", imageService.images());
        model.addAttribute("rooms", room);
        return "user/available-room";
        
        
    }

    @RequestMapping("/select-room")
    public String selectRoom(Model model, @RequestParam("id") long id) {

        bookingService.selectRoom(id, model);

        return "user/available-room";
    }

    @RequestMapping("/room-service")
    public String select(Model model) {
        model.addAttribute("images", imageService.images());
        model.addAttribute("services", serviceService.getServices());
        return "user/select-service";
    }

    @RequestMapping("/form-information")
    public String formInfor(Model model) {

        List<ServiceDetailEntity> serviceDetailEntitys = (List<ServiceDetailEntity>) session.getAttribute("serviceDetail");

        List<BookingDetailEntity> bookingDetails = (List<BookingDetailEntity>) session.getAttribute("bookingDetails");

        AccountEntity accountEntity = (AccountEntity) session.getAttribute("user");

        session.setAttribute("user", accountEntity);

        return "user/checkout";

    }

    @RequestMapping("/result-form-information")
    public String getFormInfor(@ModelAttribute("booking") BookingEntity bookingEntity) {
        BookingEntity sessionBooking = (BookingEntity) session.getAttribute("booking");

        sessionBooking.setAddress(bookingEntity.getAddress());
        sessionBooking.setEmail(bookingEntity.getEmail());
        sessionBooking.setFullName(bookingEntity.getFullName());
        sessionBooking.setPhoneNumber(bookingEntity.getPhoneNumber());
        return "user/payment";
    }

    @RequestMapping("/check-card")
    @Transactional
    public String checkCart(Model model, @ModelAttribute("accountBank") AccountBanking accountBanking) throws MessagingException {
        BookingEntity booking = (BookingEntity) session.getAttribute("booking");

        List<BookingDetailEntity> bookingDetails = (List<BookingDetailEntity>) session.getAttribute("bookingDetails");

        List<ServiceDetailEntity> serviceDetailEntitys = (List<ServiceDetailEntity>) session.getAttribute("serviceDetail");
        String holderName = accountBanking.getCardHolderName();
        String cardNumber = accountBanking.getCardNumber();
        long expiryDateYear = accountBanking.getExpiryDateYear() + 2000;
        long expiryDateMonth = accountBanking.getExpiryDateMonth();
        Date expiryDate = accountBanking.getExpiryDate();
        String cvv = accountBanking.getCvvCode();
        AccountBanking accountBank = accountBankService.findByCardNumberAndExpiryDateAndCvvCode(cardNumber, expiryDateYear, expiryDateMonth, cvv, holderName);
        if (accountBank.getId() > 0) {
            Calendar cal = Calendar.getInstance();

            if (accountBank.getExpiryDateYear() > cal.get(Calendar.YEAR)
                    || accountBank.getExpiryDateYear() == cal.get(Calendar.YEAR)
                    && accountBank.getExpiryDateMonth() > cal.get(Calendar.MONTH) + 1) {
                if (accountBank.getBalance() > booking.getPrice()) {

                    booking.setBookingDetail(bookingDetails);
                    if (request.getUserPrincipal() != null) {
                        AccountEntity accountEntity = (AccountEntity) session.getAttribute("user");
                        booking.setAccount(accountEntity);
                    }
                    booking.setStatus("1");
                    bookingService.saveBooking(booking);

                    for (BookingDetailEntity bD : bookingDetails) {
                        BookingDetailEntity bookingDetailEntity = new BookingDetailEntity();
                        bookingDetailEntity.setBooking(booking);
                        bookingDetailEntity.setPrice(bD.getPrice());
                        bookingDetailEntity.setRoom(bD.getRoom());

                        bookingDetailService.saveBookingDetail(bookingDetailEntity);
                    }
                    if (serviceDetailEntitys != null) {

                        if (!serviceDetailEntitys.isEmpty()) {

                            for (ServiceDetailEntity ser : serviceDetailEntitys) {
                                ServiceDetailEntity serviceDetailEntity = new ServiceDetailEntity();
                                serviceDetailEntity.setBooking(booking);
                                serviceDetailEntity.setName(ser.getName());
                                serviceDetailEntity.setPrice(ser.getPrice());
                                serviceDetailEntity.setRoom(ser.getRoom());
                                serviceDetailEntity.setService(ser.getService());
                                serviceDetailService.saveServiceDetail(serviceDetailEntity);
                            }
                        }
                    }

                    accountBank.setBalance(accountBank.getBalance() - booking.getPrice());
                    accountBankService.saveAccount(accountBank);

                    PaymentEntity paymentEntity = new PaymentEntity();
                    paymentEntity.setBooking(booking);
                    paymentEntity.setAccount(accountBank);
                    paymentEntity.setAmount(booking.getPrice());
                    paymentEntity.setPaymentDate(new Date());
                    paymentEntity.setStatus("da tra");
                    paymentService.savePayment(paymentEntity);

                    model.addAttribute("booking", booking);
                    model.addAttribute("bookingDetails", bookingDetails);

                    String siteUrl = getSiteURL(request);
                    sendEmail(booking, siteUrl);

                    return "user/booking/complete-booking";
                } else {
                    model.addAttribute("message", "Account not enough balance");
                    return "user/order/account-bank";
                }
            } else {
                model.addAttribute("accountBank", accountBanking);
                model.addAttribute("message", "Card has expired");
                return "user/payment";
            }
        }
        model.addAttribute("accountBank", accountBanking);
        model.addAttribute("message", "Card Empty");
        return "user/payment";

    }

    public Date convertDate(String Date) throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(Date);
        return date;
    }

    public void sendEmail(BookingEntity bookingEntity, String siteUrl) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("an8112002pro@gmail.com");
        helper.setTo("an81102134@gmail.com");
        helper.setSubject("Booking Hotel");
        String content = "You have booked a room at our hotel with an invoice of " + (bookingEntity.getPrice())
                + " You can click here to view booking "
                + " <h4><a href=\"[[URL]]\" target=\"_self\" >View Booking</a></h4>";
        String orderUrl = siteUrl + "/check-booking?id=" + bookingEntity.getId();
        content = content.replace("[[URL]]", orderUrl);
        helper.setText(content, true);

        mailSender.send(message);
        System.out.println("Mail Send Successfully.......");
    }

    @RequestMapping("/check-booking")
    public String checkBooking(Model model, @RequestParam("id") long id) {
        BookingEntity bookingEntity = bookingService.getBooking(id);
        List<BookingDetailEntity> bookingDetailEntitys = bookingDetailService.getBookingDetailByBookingId(id);
        model.addAttribute("booking", bookingEntity);
        model.addAttribute("bookingDetails", bookingDetailEntitys);
        model.addAttribute("action", true);
        return "user/booking/complete-booking";
    }

    @RequestMapping("/cancel-booking")
    public String cancelBookingByEmail(@RequestParam("id") long id, Model model) {

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
        return "user/booking/complete-booking";
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

}
