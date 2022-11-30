<%-- 
    Document   : room
    Created on : Oct 4, 2022, 7:49:58 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous"><!-- comment -->
        <jsp:include page="../include/user/css/room-css-page.jsp"/>
        <script src="https://kit.fontawesome.com/8cd8834013.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="row mt-1">

            <div class="col-12 ">
                <div class="dc" style="border: solid 1px black;  background-color: black "></div> 
                <div class="row mt-1">

                    <div class="col-3 ml-4">
                        Check In
                        <button type="button" class="btn btn-secondary" value="<fmt:formatDate value="${sessionScope.booking.checkIn}"/>"><fmt:formatDate value="${sessionScope.booking.checkIn}"/></button>

                    </div>
                    <div class="col-3">
                        Check Out
                        <button type="button" class="btn btn-secondary" value="<fmt:formatDate value="${sessionScope.booking.checkOut}"/>"><fmt:formatDate value="${sessionScope.booking.checkOut}"/></button>

                    </div>
                    <div class="col-3">

                        <button type="button" class="btn btn-secondary" > ${booking.numberAdult+booking.numberChild} people</button>

                    </div>
                </div>

                <div class="dc mt-1" style="border: solid 1px black;background-color: black "></div>
            </div>
        </div>
        <div class="container-fluid">

            <div class="row">
                <div class="col-7 room  " >
                    <h1 style="text-align: center; padding:100px 200px;">Choose your room</h1>
                    <c:if test="${rooms.size()==0}">
                        <h2 style="text-align: center;">The room you want is sold out</h2>
                    </c:if>
                    <c:forEach items="${rooms}" var="r">

                        <div class=" select-room "style="border-top:  5px solid red;  padding: 20px; box-shadow: 0 0 30px 1px #999;
                             border-radius: 10px">
                            <div class="" >
                                <c:forEach items="${images}" var="i">

                                    <c:if test="${r.roomCategory.id==i.roomCategory.id}">

                                        <img src="<c:url value="./././resources/user/images/${i.name}"/>" style="margin-right: 30px" width="300" height="200" alt="alt"/>
                                    </c:if>
                                </c:forEach>
                            </div>



                            <div class=" room-info"  >
                                <div class="room-info-item">
                                    <b>Room ${r.roomCategory.name}</b>  <br>
                                    <label for=""><i  class="fa-solid fa-person"></i>: ${r.roomCategory.numberAdult} adults and 
                                        ${r.roomCategory.numberChild} childs </label>   
                                    <i class="fas fa-chart-area"></i>: ${r.roomCategory.area}m<sup>2</sup> <br>
                                    <i class="fa-solid fa-bed"></i>: ${r.roomCategory.numberBed}
                                    <div class="rom-info-price " >

                                        <p><strong>Price: ${r.roomCategory.price}$</strong></p>
                                        <p>For ${booking.numberAdult}adults,${booking.numberChild}child</p>
                                    </div>
                                </div>
                                <a class="select" onclick="return confirm('Are you sure you want to book this room ? ');" href="<c:url value="/select-room?id=${r.id}"/> " >Select</a>   
                            </div>


                        </div>


                        <br>
                        <br>
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
                        <c:if test="${bDetails !=null && bDetails.size()>0}">
                            <c:forEach items="${bookingDetails}" var="bD">
                                <li class="list-group-item">
                                    Room:${bD.room.roomCategory.name}
                                </li>
                            </c:forEach>
                        </c:if>

                        <li class="list-group-item">
                            <strong>Price:${booking.price}$</strong>

                        </li>

                        <form action="<c:url value="/form-information"/>" >
                            <c:if test="${bookingDetails.size()==0}">
                                <li class="list-group-item"><button type="submit" disabled formaction="<c:url value="/room-service"/>" class="btn btn-light btn-lg btn-block">Continue</button></li>
                                </c:if>
                                <c:if test="${bookingDetails.size()>0}">
                                <li class="list-group-item"><button type="submit" formaction="<c:url value="/room-service"/>" class="btn btn-light btn-lg btn-block">Continue</button></li>
                                </c:if>
                        </form>
                    </ul>





                </div>
            </div>


        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    </body>
</html>
