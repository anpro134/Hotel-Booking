<%-- 
    Document   : register
    Created on : Oct 22, 2022, 3:20:00 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../../include/user/css/register-css-page.jsp"/>
        <script src="https://kit.fontawesome.com/8cd8834013.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
            <div class="wrapper wrapper--w680">
                <div class="card card-4">

                    <div class="card-body">
                        <c:if test="${message!=null&& message!=''}">
                            <c:if test="${typeMessage=='success'}">
                                <div class="alert alert-danger" role="alert" style="color: #0000FF;text-align: center;">
                                    <h3>${message}!<h3>
                                            </div>
                                        </c:if>
                                        <c:if test="${typeMessage=='fail'}">
                                            <div class="alert alert-danger" role="alert" style="color: red;text-align: center;">
                                                <h3>${message}!<h3>
                                                        </div>
                                                    </c:if>
                                                </c:if>
                                                <br>
                                                <h2 class="title"><strong>Registration Form</strong></h2>

                                                <mvc:form action="${pageContext.request.contextPath}/result-register" modelAttribute="account"  id="form-1" >


                                                    <div class=" row-space">
                                                        <div class="col-4">
                                                            <div class="input-group">
                                                                <label class="label">full name</label>
                                                                <input class="input--style-4 form-control" type="text" name="fullName" value="${account.fullName}" id="fullname">
                                                                <span class="form-message" ></span>
                                                            </div>
                                                        </div>


                                                    </div>
                                                    <div class="row-space">
                                                        <div class="col-4">
                                                            <div class="input-group">
                                                                <label class="label">Address</label>
                                                                <input class="input--style-4" id="address" value="${account.address}" type="text" name="address">
                                                                <span class="form-message"></span>
                                                            </div>
                                                        </div> 
                                                    </div>
                                                    <div class="row-space">            
                                                        <div class="col-4">
                                                            <div class="input-group">
                                                                <label class="label">Email</label>
                                                                <input class="input--style-4"  type="email" id="email" name="email">
                                                                <span class="form-message"></span>
                                                            </div>
                                                        </div>


                                                    </div>
                                                    <div class="row-space">
                                                        <div class="col-4">
                                                            <div class="input-group">
                                                                <label class="label">Gender</label>
                                                                <div class="p-t-10">
                                                                    <label class="radio-container ">Male
                                                                        <input type="radio"  name="gender" value="Male">
                                                                        <span class="checkmark"></span>
                                                                    </label>
                                                                    <label class="radio-container">Female
                                                                        <input type="radio" name="gender" value="Female">
                                                                        <span class="checkmark"></span>
                                                                    </label>
                                                                    <label class="radio-container">Other
                                                                        <input type="radio" name="gender" value="Other">
                                                                        <span class="checkmark"></span>
                                                                    </label>

                                                                </div>
                                                                <span class="form-message"></span>
                                                            </div>
                                                        </div>

                                                    </div>
                                                    <div class="row-space">
                                                        <div class="col-4">
                                                            <div class="input-group">
                                                                <label class="label">Phone Number</label>
                                                                <input class="input--style-4" value="${account.phoneNumber}" type="text" id="phonenumber" name="phoneNumber">
                                                                <span class="form-message"></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row-space">
                                                        <div class="col-4">
                                                            <div class="input-group">
                                                                <label class="label">Password</label>
                                                                <input class="input--style-4" id="password" type="password" name="password">
                                                                <span class="form-message"></span>
                                                            </div>
                                                        </div> 
                                                    </div>
                                                    <div class="row-space">
                                                        <div class="col-4">
                                                            <div class="input-group">
                                                                <label class="label">Repeat Password</label>
                                                                <input class="input--style-4" id="password_confirmation" type="password" name="re-password">
                                                                <span class="form-message"></span>
                                                            </div>
                                                        </div> 

                                                    </div>
                                                    <div class="row-space " style="text-align: center" >
                                                        <div class="col-12">
                                                            <div class="p-t-15">
                                                                <button class="btn btn--radius-2 btn--blue"  type="submit">Submit</button>
                                                            </div>
                                                        </div>
                                                        <div class="col-12">
                                                            <div class="p-t-15">
                                                                <a style="text-decoration: none;" href="<c:url value="/home"/>"class="btn btn--radius-2 btn--blue">Cancel</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </mvc:form>

                                                </div>
                                                </div>
                                                </div>
                                                </div>


                                                <script>

                                                    document.addEventListener('DOMContentLoaded', function () {
                                                        // Mong muốn của chúng ta
                                                        Validator({
                                                            form: '#form-1',
                                                            formGroupSelector: '.input-group',
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
                                                                Validator.maxLength('#password', 30),
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


                                                    });

                                                </script>
                                                </body>
                                                </html>
