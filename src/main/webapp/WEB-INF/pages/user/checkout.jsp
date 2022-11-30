<%-- 
    Document   : checkout
    Created on : Oct 9, 2022, 7:41:31 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../include/user/css/checkout-css-page.jsp"/>
    </head>
    <body>
        <div class="checkout">
            <div class="container">
                <div class="row">
                    <!-- Billing Info -->
                    <div class="col-lg-6">
                        <div class="billing checkout_section">
                            <div class="section_title">Billing Address</div>
                            <div class="section_subtitle">Enter your address info</div>
                            <div class="checkout_form_container">
                                <mvc:form id="form-1" action="${pageContext.request.contextPath}/result-form-information" modelAttribute="booking">


                                    <div class="validate">
                                        <!-- Company -->
                                        <label for="checkout_company">FullName</label>
                                        <input name="fullName" id="fullname"  value="${sessionScope.user.fullName}"type="text" id="checkout_company" class="checkout_input">
                                        <span class="form-message" ></span>
                                    </div>

                                    <div class="validate">
                                        <!-- Address -->
                                        <label for="checkout_address">Address*</label>
                                        <input type="text" id="address" value="${sessionScope.user.address}" name="address" id="checkout_address" class="checkout_input" required="required">
                                        <span class="form-message" ></span>
                                    </div>



                                    <div class="validate">
                                        <!-- Phone no -->
                                        <label for="checkout_phone">Phone Number*</label>
                                        <input type="phone" id="phonenumber" value="${sessionScope.user.phoneNumber}" name="phoneNumber" id="checkout_phone" class="checkout_input" required="required">
                                        <span class="form-message" ></span>
                                    </div>
                                    <div class="validate">
                                        <!-- Email -->
                                        <label for="checkout_email">Email Address*</label>
                                        <input type="email" id="email" value="${sessionScope.user.email}" name="email" id="checkout_email" class="checkout_input" required="required">
                                        <span class="form-message" ></span>
                                    </div>


                                </div>
                            </div>
                        </div>

                        <!-- Order Info -->

                        <div class="col-lg-6">
                            <div class="order checkout_section">
                                <div class="section_title">Your Booking</div>
                                <div class="section_subtitle">Booking details</div>

                                <!-- Order details -->
                                <div class="order_list_container">
                                    <div class="order_list_bar d-flex flex-row align-items-center justify-content-start">
                                        <div class="order_list_title">Room</div>
                                        <div class="order_list_value ml-auto">Total</div>
                                    </div>
                                    <ul class="order_list">
                                        <c:forEach items="${bookingDetails}" var="bD">
                                            <li class="d-flex flex-row align-items-center justify-content-start">

                                                <div class="order_list_title">${bD.room.roomCategory.name}</div>
                                                <div class="order_list_value ml-auto">$${bD.room.roomCategory.price}</div>

                                            </li>
                                        </c:forEach>


                                        <li class="d-flex flex-row align-items-center justify-content-start">
                                            <div class="order_list_title">Total</div>
                                            <div class="order_list_value ml-auto">$${booking.price}</div>
                                        </li>
                                    </ul>
                                </div>

                                <!-- Payment Options -->


                                <!-- Order Text -->
                                <div class="order_text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pharetra temp or so dales. Phasellus sagittis auctor gravida. Integ er bibendum sodales arcu id te mpus. Ut consectetur lacus.</div>
                                <button type="submit">Place Order</button>
                            </div>
                        </div>
                    </div>
                </mvc:form>
            </div>
        </div>
        <script>

            document.addEventListener('DOMContentLoaded', function () {
            // Mong muốn của chúng ta
            Validator({
            form: '#form-1',
                    formGroupSelector: '.validate',
                    errorSelector: '.form-message',
                    rules: [
                            Validator.isRequired('#fullname', 'Please enter your full name'),
                            Validator.isRequired('#password', 'Please enter password'),
                            Validator.isRequired('#phonenumber', 'Please enter phonenumber'),
                            Validator.isRequired('#email', 'Please enter email'),
                            Validator.maxLength('#fullname', 50),
                            Validator.maxLength('#address', 100),
                            Validator.isEmail('#email'),
                            Validator.isPhone('#phonenumber'),
                            Validator.isRequired('#address', 'Please enter your address'),
                            Validator.minLength('#fullname', 6),
                            Validator.Word('#fullname'),
                    ],
            });

        </script>
    </body>
</html>
