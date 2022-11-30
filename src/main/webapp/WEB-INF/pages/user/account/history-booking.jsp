<%-- 
    Document   : history-booking
    Created on : Oct 18, 2022, 9:55:03 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
                            <h2>Booking</h2>
                            <ul class="text-left">
                                <li><a href="<c:url value="/home"/>">Home</a></li>
                                <li><span> // </span>History Booking</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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
        <c:if test="${bookings.size()==0}">
            <h2 style="text-align: center;">You don't have any bookings yet</h2>
        </c:if>
        <c:if test="${bookings.size()>0}">
            <section class="pages cart-page section-padding">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-responsive padding60 ">
                                <table class="wishlist-table text-center  " >
                                    <thead>
                                        <tr>

                                            <th><i class="fa-solid fa-envelope"></i> Email</th>
                                            <th><i class="fa-solid fa-money-bill-1-wave"></i>  Price</th>
                                            <th><i class="fa-solid fa-location-dot"></i> Address</th>
                                            <th><i class="fa-solid fa-calendar-days"></i> Date</th>
                                            <th><i class="fa-solid fa-calendar-days"></i> CheckIn</th>
                                            <th><i class="fa-solid fa-calendar-days"></i> CheckOut</th>
                                            <th>Status</th>
                                            <th>&nbsp;</th>
                                        </tr>
                                    </thead>
                                    <c:forEach items="${bookings}" var="b">
                                        <tbody>


                                            <tr>


                                                <td>${b.email}</td>
                                                <td><fmt:formatNumber value="${b.price}"/> $</td>
                                                <td>${b.address}</td>
                                                <td>${b.bookingDate}</td>
                                                <td>${b.checkIn}</td>
                                                <td>${b.checkOut}</td>

                                                <td>
                                                    <c:choose >
                                                        <c:when test="${b.status =='1'}">
                                                            <p class="btn btn-warning">Processing</p> 
                                                        </c:when>
                                                        <c:when test="${b.status =='3'}">
                                                            <p class="btn btn-warning">Processing</p> 
                                                        </c:when>
                                                        <c:otherwise >
                                                            <p class="btn btn-success">Processed</p>   
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                                <td style="width: 100px">
                                                    <a href="<c:url value="/view-detail-booking?id=${b.id}"/>" class="btn btn-success" title="View Detail" ><i class="fa-solid fa-eye"></i></a>
                                                        <c:if test="${b.status == '1'}">
                                                        <a href="<c:url value="/cancelBooking?id=${b.id}"/>" onclick="return confirm('Do you really want to cancel your booking? ');" type="button" class="btn btn-danger" title="Cancel Booking"><i class="fa-solid fa-circle-xmark"></i></a>
                                                        </c:if>
                                                        <c:if test="${b.status == '3'}">
                                                        <a href="<c:url value="/cancelBooking?id=${b.id}"/>"  onclick="return confirm('Do you really want to cancel your booking? ');" type="button" class="btn btn-danger" title="Cancel Booking"><i class="fa-solid fa-circle-xmark"></i></a>
                                                        </c:if>

                                                </td>
                                            </tr>


                                        </tbody>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </c:if>
    </body>
</html>
