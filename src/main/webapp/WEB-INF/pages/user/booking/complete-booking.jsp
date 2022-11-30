<%-- 
    Document   : complete-booking
    Created on : Oct 19, 2022, 10:13:25 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib  prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../../include/user/css/account-css-page.jsp"/>
        <script src="https://kit.fontawesome.com/8cd8834013.js" crossorigin="anonymous"></script>

    </head>
    <body>
        <header class="header-one header-two">

            <div class="container text-center">
                <div class="row">
                    <div class="col-sm-2">
                        <div class="logo">
                            BrightHotel

                        </div>
                    </div>
                    <div class="col-sm-8">
                        <div class="header-middel">
                            <div class="mainmenu">
                                <nav>
                                    <ul>
                                        <li><a href="<c:url value="/home"/>">Home</a></li>
                                        <li><a href="<c:url value="/rooms"/>">Room</a>

                                        </li>

                                        <li><a href="<c:url value="/services"/>">Service</a></li>
                                        
                                            <sec:authorize access="!isAuthenticated()">
                                            <li class="nav-item"><a href="<c:url value="/register"/> " class="nav-link">Register</a></li>
                                            <li class="nav-item"><a href="<c:url value="/login"/> " class="nav-link">Login</a></li>

                                        </sec:authorize>
                                        <sec:authorize access="isAuthenticated()">
                                            <li class="dropdown">
                                                <a data-toggle="dropdown" href="">Account<span class="caret"></span></a>
                                                <ul class="dropdown-menu" style="margin-top: -3px;">
                                                    <li><a  href="<c:url value="/manage-account"/>"><i class="fas fa-user"></i> Account Info</a></li>
                                                    <li><a href="<c:url value="/manage-user-booking"/>"> <i class="fas fa-history"></i>  Manage Booking</a></li>
                                                    <li><a href="<c:url value="/logout"/>"> <i class="fas fa-sign-out-alt"></i> Logout</a></li>
                                                </ul>
                                            </li>
                                        </sec:authorize>
                                    </ul>
                                </nav>
                            </div>
                            <!-- mobile menu start -->

                        </div>

                    </div>

                </div>
            </div>
        </header>


        <div class="pages-title section-padding">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="pages-title-text text-center">
                            <h2>Booking Complete</h2>
                            <ul class="text-left">
                                <li><a href="">Home</a></li>
                                <li><span> // </span>Complete Booking</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- pages-title-end -->
        <!-- order-complete content section start -->
        <c:if test="${message!=null && message!='' &&typeMessage=='fail'}">
            <div  style="text-align: center"class="alert alert-danger" role="alert">
                ${message}
            </div>
        </c:if>
        <c:if test="${message!=null && message!='' &&typeMessage=='success'}">
            <div  style="text-align: center"class="alert alert-success" role="alert">
                ${message}
            </div>
        </c:if>
        <section class="pages checkout order-complete section-padding">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 text-center">
                        <div class="complete-title">
                            <p>Thank you. Your booking has been received; Your booking has been received.</p>
                            <p>Please Wait for Review</p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-6">
                        <div class="padding60">
                            <div class="log-title">
                                <h3><strong>YOUR BOOKING</strong></h3>
                            </div>
                            <div class="cart-form-text pay-details">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Date Booking</th>
                                            <th>Room Name</th>

                                            <td>Price</td>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <c:forEach items="${bookingDetails}" var="bD">
                                            <tr>
                                                <th>${booking.checkIn}->${booking.checkOut}</th>
                                                <th>${bD.room.roomCategory.name}</th>

                                                <td><fmt:formatNumber value="${bD.price}" /></td>
                                            </tr>

                                        </c:forEach>

                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <th>Total Price</th>

                                            <td><fmt:formatNumber  value="${booking.price}"/> VNĐ</td>
                                        </tr>

                                    </tfoot>
                                </table>
                                <c:if test="${booking.status == '1' && action==true ||booking.status == '3' && action==true}">
                                    <a href="<c:url value="/cancel-booking?id=${booking.id}"/>" onclick="return confirm('Do you really want to cancel your booking?');" type="button" class="btn btn-danger">Cancel Booking</a>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6">
                        <div class="order-details padding60">
                            <div class="log-title">
                                <h3><strong>Customer Details</strong></h3>
                            </div>
                            <div class="por-dse clearfix">
                                <ul>
                                    <li><span>Customer Name<strong>:</strong></span> ${booking.fullName}</li>
                                    <li><span>Email<strong>:</strong></span> ${booking.email}</li>
                                    <li><span>Phone Number<strong>:</strong></span> ${booking.phoneNumber}</li>
                                </ul>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
