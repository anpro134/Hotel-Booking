<%-- 
    Document   : login
    Created on : Oct 5, 2022, 10:30:35 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../include/user/css/login-css-page.jsp"/>
        <script src="https://kit.fontawesome.com/8cd8834013.js" crossorigin="anonymous"></script>
    </head>
    <body >
        <div class="limiter">
            <div class="container-login100" style="background-image: url('resources/user/images/bg_2.jpg');">
                <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">

                    <form class="login100-form validate-form" action="<c:url value="j_spring_security_check"/>" method="post">
                        <span class="login100-form-title p-b-49">
                            Login
                        </span>
                        <c:if test="${message!=null && message !=''}" >
                            <c:if test="${typeMessage=='success'}">
                                <div style="color: #73fbaf;" class="alert alert-danger" role="alert">
                                    ${message}
                                </div>
                            </c:if>
                            <c:if test="${typeMessage=='fail'}">
                                <div style="color: red;" class="alert alert-danger" role="alert">
                                    ${message}
                                </div>
                            </c:if>
                        </c:if>
                        <div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
                            <i class="fa-solid fa-user"></i> <span class="label-input100">Username</span></i>
                            <input class="input100 f007" type="text" name="username" placeholder=" Type your username">

                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Password is required">
                            <i class="fa-solid fa-lock"></i> <span class="label-input100">Password</span>
                            <input class="input100" type="password" name="password" placeholder="Type your password">

                        </div>

                        <div class="text-right p-t-8 p-b-31">
                            <a href="#">
                                Forgot password?
                            </a>
                        </div>
                        <span>Remember me?</span>
                        <input type="checkbox" name="remember-me">
                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button class="login100-form-btn">
                                    Login
                                </button>
                            </div>
                        </div>
                        <div class="flex-col-c p-t-155">
                            <span class="txt1 p-b-17">
                                Or Sign Up Using
                            </span>

                            <a href="<c:url value="/register"/>" class="txt2">
                                Sign Up
                            </a>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
