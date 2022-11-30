<%-- 
    Document   : index
    Created on : Sep 22, 2022, 2:48:17 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" 
          prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- \saflkjwhapowopghwaioghsighisdw -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>JSP Page</title>
        <jsp:include page="../include/user/css-page.jsp"/>
    </head>
    <body >
        <jsp:include page="../include/user/header.jsp"/>
        <!-- END nav -->
        <jsp:include page="../include/user/banner.jsp"/>
        
            
<div class="container">
    <div class="row mb-5">
        <div class="col-md-12">
            
            <div class="block-32">
                <mvc:form action="${pageContext.request.contextPath}/check-available" modelAttribute="booking">
                    <div class="row">
                        <div class="col-md-6 mb-3 mb-lg-0 col-lg-3">
                            <label for="checkin">Check In</label>
                            <div class="field-icon-wrap">
                                <div class="icon"><span class="icon-calendar"></span></div>
                                <input type="text" name="checkInString" id="checkin_date" class="form-control">
                            </div>
                        </div>
                        <div class="col-md-6 mb-3 mb-lg-0 col-lg-3">
                            <label for="checkin">Check Out</label>
                            <div class="field-icon-wrap">
                                <div class="icon"><span class="icon-calendar"></span></div>
                                <input type="text" name="checkOutString" id="checkout_date" class="form-control">
                            </div>
                        </div>
                        <div class="col-md-6 mb-3 mb-md-0 col-lg-3">
                            <div class="row">
                                <div class="col-md-6 mb-3 mb-md-0">
                                    <label for="checkin">Adults</label>
                                    <div class="field-icon-wrap">
                                        <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                        <select name="numberAdult" id="" class="form-control">
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4+</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-3 mb-md-0">
                                    <label for="checkin">Children</label>
                                    <div class="field-icon-wrap">
                                        <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                        <select name="numberChild" id="" class="form-control">
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4+</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-3 align-self-end">
                            <button class="btn btn-primary btn-block">Check Availabilty</button>
                        </div>
                    </div>
                </mvc:form>
            </div>
        </div>
    </div>

    <div class="row site-section">
        <div class="col-md-12">
            <div class="row mb-5">
                <div class="col-md-7 section-heading">
                    <span class="subheading-sm">Services</span>
                    <h2 class="heading">Facilities &amp; Services</h2>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="media block-6">
                <div class="icon"><span class="flaticon-double-bed"></span></div>
                <div class="media-body">
                    <h3 class="heading">Luxury Rooms</h3>
                    <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
                </div>
            </div>      
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="media block-6">
                <div class="icon"><span class="flaticon-wifi"></span></div>
                <div class="media-body">
                    <h3 class="heading">Fast &amp; Free Wifi</h3>
                    <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="media block-6">
                <div class="icon"><span class="flaticon-customer-service"></span></div>
                <div class="media-body">
                    <h3 class="heading">Call Us 24/7</h3>
                    <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
                </div>
            </div>
        </div>

        <div class="col-md-6 col-lg-4">
            <div class="media block-6">
                <div class="icon"><span class="flaticon-taxi"></span></div>
                <div class="media-body">
                    <h3 class="heading">Travel Accomodation</h3>
                    <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
                </div>
            </div>      
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="media block-6">
                <div class="icon"><span class="flaticon-credit-card"></span></div>
                <div class="media-body">
                    <h3 class="heading">Accepts Credit Card</h3>
                    <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="media block-6">
                <div class="icon"><span class="flaticon-dinner"></span></div>
                <div class="media-body">
                    <h3 class="heading">Restaurant</h3>
                    <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="site-section block-13 bg-light">
    <div class="container">
        <div class="row mb-5">
            <div class="col-md-7 section-heading">
                <span class="subheading-sm">Featured Rooms</span>
                <h2 class="heading">Rooms &amp; Suites</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reprehenderit, iusto, omnis! Quidem, sint, impedit? Dicta eaque delectus tempora hic, corporis velit doloremque quod quam laborum, nobis iusto autem culpa quaerat!</p>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="nonloop-block-13 owl-carousel">
                    <c:forEach items="${rooms}" var="r">
                    <div class="item">
                        
                        <div class="block-34">
                            <div class="image">
                                <c:forEach items="${images}" var="s">
                                    <c:if test="${r.id==s.id}">
                                        
                                        <a href="#"><img src="<c:url value="resources/user/images/${s.name}"/>" alt="Image placeholder"></a>
                                    </c:if>
                                </c:forEach>
                                
                                
                            </div>
                            <div class="text">
                                <h2 class="heading">${r.name}</h2>
                                <div class="price"><sup>$</sup><span class="number">${r.price}</span><sub>/per night</sub></div>
                                <ul class="specs">
                                    <li><strong>Adults:</strong>${r.numberAdult} </li>
                                    <li><strong>Categories:</strong> Single</li>
                                    <li><strong>Facilities:</strong> Closet with hangers, HD flat-screen TV, Telephone</li>
                                    <li><strong>Size:</strong> 20m<sup>2</sup></li>
                                    <li><strong>Bed Type:</strong> ${r.numberBed}</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    </c:forEach>

                    

                </div>

            </div> <!-- .col-md-12 -->
        </div>
    </div>
</div>

<div class="site-section bg-light">
    <div class="container">
        <div class="row mb-5">
            <div class="col-md-7 section-heading">
                <span class="subheading-sm">Menus</span>
                <h2 class="heading">Restaurant Menu</h2>
            </div>
        </div>

        <div class="block-35">

            <ul class="nav" id="pills-tab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="true">Breakfast</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile" aria-selected="false">Lunch</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-contact" role="tab" aria-controls="pills-contact" aria-selected="false">Dinner</a>
                </li>
            </ul>
            <div class="tab-content" id="pills-tabContent">
                <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                    <div class="row">
                        <div class="col-md-12 block-13">
                            <div class="nonloop-block-13 owl-carousel">
                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_1.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Egg &amp; Asparagus</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">30.50</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_2.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Grilled Top Sirloin Steak</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">23.45</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_3.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Egg &amp; Grilled Steak</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">45.45</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_4.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Spicy Noodles</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">33.45</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_1.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Egg &amp; Asparagus</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">30.50</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_2.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Grilled Top Sirloin Steak</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">23.45</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_3.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Egg &amp; Grilled Steak</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">45.45</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_4.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Spicy Noodles</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">33.45</span></div>
                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>


                <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
                    <div class="row">
                        <div class="col-md-12 block-13">
                            <div class="nonloop-block-13 owl-carousel">
                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_2.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Grilled Top Sirloin Steak</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">23.45</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_1.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Egg &amp; Asparagus</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">30.50</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_3.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Egg &amp; Grilled Steak</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">45.45</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_4.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Spicy Noodles</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">33.45</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_1.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Egg &amp; Asparagus</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">30.50</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_2.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Grilled Top Sirloin Steak</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">23.45</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_3.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Egg &amp; Grilled Steak</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">45.45</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_4.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Spicy Noodles</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">33.45</span></div>
                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">
                    <div class="row">
                        <div class="col-md-12 block-13">
                            <div class="nonloop-block-13 owl-carousel">
                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_3.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Egg &amp; Grilled Steak</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">45.45</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_1.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Egg &amp; Asparagus</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">30.50</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_2.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Grilled Top Sirloin Steak</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">23.45</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_4.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Spicy Noodles</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">33.45</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_1.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Egg &amp; Asparagus</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">30.50</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_2.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Grilled Top Sirloin Steak</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">23.45</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_3.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Egg &amp; Grilled Steak</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">45.45</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="block-34">
                                        <div class="image">
                                            <a href="#"><img src="<c:url value="resources/user/images/menu_4.jpg"/>" alt="Image placeholder"></a>
                                        </div>
                                        <div class="text">
                                            <h2 class="heading">Spicy Noodles</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione quo vel aut ab qui quas!</p>
                                            <div class="price"><sup>$</sup><span class="number">33.45</span></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<jsp:include page="../include/user/footer.jsp"/>
<!-- loader -->
<div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

<jsp:include page="../include/user/js-page.jsp"/>
</body>
</html>
