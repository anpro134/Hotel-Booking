<%-- 
    Document   : account
    Created on : Oct 13, 2022, 10:52:05 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib  uri="http://www.springframework.org/security/tags" 
           prefix="sec" %>
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
                            <h2>Account Information</h2>
                            <ul class="text-left">
                                <li><a href="<c:url value="/home"/>">Home</a></li>
                                <li><span> // </span>Account</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- pages-title-end -->
        <!-- My account content section start -->
        <c:if test="${typeMessage =='success' }">
            <div class="alert alert-success text-center">
                ${message}
            </div>
        </c:if>
        <c:if test="${typeMessage =='fail' }">
            <div class="alert alert-danger text-center">
                ${message}
            </div>
        </c:if>
        <section class="pages my-account-page section-padding">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-sm-12">
                        <div class="padding60">
                            <div class="log-title">
                                <h3><strong>My Account</strong></h3>
                            </div>
                            <div class="prament-area main-input" id="doitk">
                                <ul class="panel-group" id="accordion">
                                    <li class="panel">
                                        <div class="account-title" data-toggle="collapse" data-parent="#accordion" data-target="#collapse1">
                                            <label>
                                                <input type="radio" checked value="forever" name="rememberme" />
                                                Personal Information
                                            </label>
                                        </div>
                                        <div id="collapse1" class="panel-collapse collapse in">
                                            <div class="single-log-info">
                                                <div class="bulling-title">
                                                    <b>

                                                    </b>
                                                    <div class="custom-input">
                                                        <mvc:form action="${pageContext.request.contextPath}/update-user" id="form-1"
                                                                  method="post" modelAttribute="account">
                                                            <input type="hidden" name="id" value="${sessionScope.user.id}">
                                                            <input type="hidden" name="password" value="${sessionScope.user.password}">
                                                            <input type="hidden" name="status" value="${sessionScope.user.status}">

                                                            <div class="validate ">
                                                                <input style="color: black" type="text" id="fullname" name="fullName" placeholder="Full Name" required value="${sessionScope.user.fullName}" />
                                                                <span class="form-message"></span>
                                                            </div>


                                                            <div class="custom-select ">
                                                                <select style="color: black" class="form-control" name="gender" title="Giới tính">
                                                                    <c:forEach items="${gender}" var="g">
                                                                        <c:if test="${sessionScope.user.gender==g}">
                                                                            <option value="${g}" selected>${g}</option>
                                                                        </c:if>
                                                                        <c:if test="${sessionScope.user.gender!=g}">
                                                                            <option value="${g}" >${g}</option>
                                                                        </c:if>

                                                                    </c:forEach>
                                                                </select>

                                                            </div>

                                                            <input  type="email" id="email" name="email" readonly placeholder="Email" required value="${sessionScope.user.email}" />



                                                            <div class="validate">
                                                                <input style="color: black" id="phonenumber" type="text" name="phoneNumber" placeholder="Phone Number" value="${sessionScope.user.phoneNumber}" />
                                                                <span class="form-message"></span>
                                                            </div>

                                                            <div class="validate">
                                                                <input style="color: black" id="address" type="text" name="address" placeholder="Address" required value="${sessionScope.user.address}" />
                                                                <span class="form-message"></span>
                                                            </div>

                                                            <div class="submit-text">
                                                                <button type="submit_tt">Save</button>
                                                            </div>

                                                        </mvc:form>
                                                    </div>
                                                </div>
                                            </div>
                                    </li>
                                    <li class="panel">
                                        <div class="account-title" data-toggle="collapse" data-parent="#accordion" data-target="#collapse4">
                                            <label>
                                                <input type="radio" value="forever" name="rememberme" />
                                                Change Password
                                            </label>
                                        </div>
                                        <div id="collapse4" class="panel-collapse collapse">
                                            <div class="single-log-info">
                                                <div class="custom-input">
                                                    <mvc:form action="${pageContext.request.contextPath}/change-password" 
                                                              id="form-2"    method="post" modelAttribute="userE">
                                                        <div class="validate">
                                                            <input type="password" id="currentpassword" placeholder="Current password " name="password"  />
                                                            <span class="form-message"></span>
                                                        </div>

                                                        <div class="validate">
                                                            <input type="password" placeholder="New Password " id="password" name="newPassword" />
                                                            <span class="form-message"></span>
                                                        </div>
                                                        <div class="validate">
                                                            <input type="password" placeholder="Repeat Password" id="password_confirmation" name="passwordConfirm" />
                                                            <span class="form-message"></span>
                                                        </div>
                                                        <div class="submit-text text-left">
                                                            <button type="submit_pw" value="submit form">Save</button>
                                                        </div>
                                                    </mvc:form>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
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
                            Validator.isRequired('input[name="gender"]', 'Please select this field'),
                            Validator.isRequired('#phonenumber', 'Please enter phonenumber'),
                            Validator.isRequired('#email', 'Please enter email'),
                            Validator.isEmail('#email'),
                            Validator.isPhone('#phonenumber'),
                            Validator.isRequired('#address', 'Please enter your address'),
                            Validator.minLength('#password', 6),
                            Validator.minLength('#fullname', 6),
                            Validator.maxLength('#fullname', 50),
                            Validator.maxLength('#address', 100),
                            Validator.Word('#fullname'),
                            Validator.isRequired('#password_confirmation'),
                            Validator.isConfirmed('#password_confirmation', function () {
                            return document.querySelector('#form-1 #password').value;
                            }, 'Re-entered password is incorrect')
                    ],
            });
                    Validator({
                    form: '#form-2',
                            formGroupSelector: '.validate',
                            errorSelector: '.form-message',
                            rules: [
                                    Validator.minLength('#currentpassword', 6),
                                    Validator.minLength('#password', 6),
                                    Validator.isRequired('#password_confirmation'),
                                    Validator.isConfirmed('#password_confirmation', function () {
                                    return document.querySelector('#form-2 #password').value;
                                    }, 'Re-entered password is incorrect')
                            ],
                    });




        </script>

        <jsp:include page="../../include/user/js-page.jsp"/>

    </body>
</html>
