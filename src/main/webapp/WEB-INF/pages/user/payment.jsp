<%-- 
    Document   : account-bank
    Created on : Aug 27, 2022, 4:13:01 PM
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
        <jsp:include page="../include/user/css/payment-css-page.jsp"/>
    </head>
    <body>


        <div class="mainscreen">

            <div class="card">

                <div class="rightside">

                    <mvc:form action="${pageContext.request.contextPath}/check-card" modelAttribute="accountBank">
                        <h1>CheckOut</h1>
                        <h2>Payment Information</h2>
                        <p>Card Number</p>
                        <div id="card-container">
                            <input type="text" placeholder="0000 0000 0000 0000" value="${accountBank.cardNumber}"  class="inputbox" name="cardNumber" id="card" required />
                            <div id="logo"></div>
                        </div>
                        <p>Cardholder Name</p>

                        <input type="text" placeholder="Holder Name"  class="inputbox" name="cardHolderName" value="${accountBank.cardHolderName}"  required />

                        <div class="expcvv">

                            <p class="expcvv_text">Expiry</p>
                            <input type="number"  max="12" class="inputbox expiry_input" name="expiryDateMonth" value="${accountBank.expiryDate}" id="exp_date" data-mask="00" placeholder="00" required />
                            <input type="number" class="inputbox expiry_input" name="expiryDateYear" value="${accountBank.expiryDate}" id="exp_date" data-mask="00"  placeholder="00" required />
                            <p class="expcvv_text2">CVV</p>
                            <input type="password" class="inputbox" maxlength="3" value="${accountBank.cvvCode}" name="cvvCode" id="cvv" required placeholder="000" />
                        </div>
                        <c:if test="${message!=null && message != ''}">
                            <p style="color: red">${message}</p>   
                        </c:if>

                        <button type="submit" class="button">CheckOut</button>
                    </mvc:form>
                </div>
            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <script src="<c:url value="./././resources/user/js/payment/card-validator.js"/>"></script>
    </body>
</html>
