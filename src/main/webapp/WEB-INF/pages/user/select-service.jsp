<%-- 
    Document   : select-service
    Created on : Oct 5, 2022, 7:58:45 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../include/user/css/room-css-page.jsp"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous"><!-- comment -->
    </head>
    <body>

        <form action="<c:url value="/add-service"/>"  >


            <div class="container">

                <div class="row">


                    <div class="col-7  ">




                        <c:forEach  items="${sessionScope.bookingDetails}" var="bD">
                            <div class=" shadow-none p-3 mb-5 bg-light rounded float-left" >
                                Room ${bD.room.roomCategory.name} 
                                <div class="w-100"></div>
                                <c:forEach items="${services}" var="s">


                                    <div class=" shadow p-2 mb-5 bg-white rounded float-left" style="width: 40%" >

                                        <c:forEach items="${images}" var="i">
                                            <c:if test="${s.id==i.service.id}">

                                                <img src="<c:url value="./././resources/user/images/${i.name}"/>" style="margin-right: 30px" width="200" height="150" alt="alt"/>
                                            </c:if>
                                        </c:forEach>
                                        <label>${s.name}</label>
                                        <input type="checkbox" id="serviceId" name="serviceId" value="${s.id}" onclick="myFunction(${s.id},${bD.room.id})"  > 
                                        <label for="serviceId1">Add</label>
                                        <strong>Price: <fmt:formatNumber value="${s.price}"/>$</strong>

                                    </div>











                                </c:forEach> 
                            </div>
                        </c:forEach>


                    </div> 

                    <div class="col-5  mt-4">

                        <ul class="list-group">
                            <li class="list-group-item">Booking Info</li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">Bright Hotel
                                <br>

                                <fmt:formatDate value="${booking.checkIn}"/>-> <fmt:formatDate value="${booking.checkOut}"/>                                   
                                <span class="badge badge-primary badge-pill"><c:if test="${day>1}">
                                        ${day}days
                                    </c:if>
                                    <c:if test="${day==1}">
                                        ${day}day
                                    </c:if></span>


                            </li>
                            <c:if test="${bookingDetails.size()>0}">
                                <c:forEach items="${bookingDetails}" var="bD">
                                    <li class="list-group-item">
                                        Room:${bD.room.roomCategory.name}
                                    </li>
                                </c:forEach>
                            </c:if>
                            <li id="service" class="list-group-item"></li>
                            <li class="list-group-item">
                                <strong ><div id="price">Price:${booking.price}$</div></strong>

                            </li>

                            <form action="<c:url value="/form-information"/>" >
                                <c:if test="${bookingDetails.size()==0}">
                                    <li class="list-group-item"><button type="submit" disabled formaction="<c:url value="/form-information"/>" class="btn btn-light btn-lg btn-block">Continue</button></li>
                                    </c:if>
                                    <c:if test="${bookingDetails.size()>0}">
                                    <li class="list-group-item"><button type="submit" formaction="<c:url value="/form-information"/>" class="btn btn-light btn-lg btn-block">Continue</button></li>
                                    </c:if>
                            </form>
                        </ul>




                    </div>

                </div>
                <div id="price"></div>

                <script type="text/javascript">





                    function myFunction(serviceId, roomId) {
                        var checkBox = $('input[type="checkbox"][name="serviceId"]:checked');


                        $.ajax({
                            type: 'GET',
                            contentType: "application/json",
                            url: "/HotelBooking/service/select-service?serviceId=" + serviceId + "&roomId=" + roomId,
                            dataType: 'json',
                            success: function (result) {
                                if (result.length >0) {


                                    var services = "";
                                    $.each(result, function (index, bD) {
                                        var price = "Price: " + bD.booking.price + "$";

                                        services += bD.service.name + ",";
                                        $("#price").html(price);
                                        $("#service").html(services);


                                    });
                                } else {

                                console.log("booking");
                                    $.ajax({
                                        type: 'GET',
                                        contentType: "application/json",
                                        url: "/HotelBooking/service/getBooking",
                                        dataType: 'json',
                                        success: function (result) {
                                            var price = "Price: " + result.price + "$";
                                            $("#price").html(price);
                                            var services = "";
                                            $("#service").html(services);
                                        },
                                        error: function (e) {
                                            console.log("ERROR: ", e);
                                        }

                                    });
                                }
                            },
                            error: function (e) {
                                console.log("ERROR: ", e);
                            }

                        });






                    }


                </script>
                <script
                src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.1/jquery.min.js"></script>


                <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
                </body>
                </html>

