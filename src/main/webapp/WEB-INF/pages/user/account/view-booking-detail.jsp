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
                                        <li><a href="<c:url value="/rooms"/>">Rooms</a>

                                        </li>
                                        <li><a href="<c:url value="/services"/>">Services</a>

                                        </li>

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


        <section class="pages cart-page section-padding">
            <div class="container">
                <div class="row" id="printableArea">
                    <div class="col-xs-12">
                        <div class="table-responsive padding60">
                            <table class="wishlist-table text-center">
                                <thead>
                                    <tr>

                                        <th>Name Room</th>
                                        <th>Price</th>
                                        <th>Capacity</th>

                                        <th>&nbsp;</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach items="${bookingDetails}" var="bD">
                                        <tr>


                                            <td>${bD.room.roomCategory.name}</td>
                                            <td><fmt:formatNumber value="${bD.room.roomCategory.price}"/> $</td>
                                            <td>${bD.room.roomCategory.numberAdult}Adult ${bD.room.roomCategory.numberChild}Child</td>




                                        </tr>
                                    

                                </tbody>
                            </table>
                            <div class="col-md-12">
                                <div class="pull-right m-t-30 text-right">
                                    <p>Sub - Total amount: ${bD.booking.price}$</p>
                                    <p>Discount : $0 </p>
                                    
                                    <hr>
                                    <h3><b>Total : ${bD.booking.price}$</b> </h3> </div>
                                <div class="clearfix"></div>
                                </c:forEach>
                                <hr>
                                <div class="text-right">

                                    <button onclick="printDiv('printableArea')" class="btn btn-default btn-outline" type="button"> <span> Print</span> </button>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

            </div>

        </section>
        <script>
            function printDiv(divName) {
                var printContents = document.getElementById(divName).innerHTML;
                var originalContents = document.body.innerHTML;

                document.body.innerHTML = printContents;

                window.print();

                document.body.innerHTML = originalContents;
            }
        </script>
    </body>
</html>
