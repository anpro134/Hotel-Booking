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
    </head>
    <body>
        <h1>Login</h1>
        <form action="<c:url value="j_spring_security_check"/>" method="post">
            Email: <input type="text" name="username">
            Password: <input type="password" name="password">
            <input type="submit" name="name" value="Login">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            
        </form>
    </body>
</html>
