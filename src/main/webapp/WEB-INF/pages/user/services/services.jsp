<%-- 
    Document   : rooms
    Created on : Oct 20, 2022, 8:06:02 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rooms Page</title>
        <jsp:include page="../../include/user/css-page.jsp"/>
        <script src="https://kit.fontawesome.com/8cd8834013.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <jsp:include page="../../include/user/header.jsp"/>

        <div class="block-30 block-30-sm item" style="background-image: url('resources/user/images/bg_2.jpg');" data-stellar-background-ratio="0.5">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-10">
                        <span class="subheading-sm">Services</span>
                        <h2 class="heading">Facilities &amp; Services</h2>
                    </div>
                </div>
            </div>
        </div>



        <div class="site-section bg-light">
            
                


                <div class="container">
                    <c:forEach items="${services}" var="s">
                        <div class="row site-section">
                            <div class="col-lg-7 mb-5">
                                <c:forEach items="${images}" var="i">
                                    <c:if test="${s.id==i.service.id}">
                                        <img src="<c:url value="resources/user/images/${i.name}"/>" alt="Image placeholder" class="img-fluid img-shadow">
                                    </c:if>
                                </c:forEach>
                            </div>
                            <div class="col-lg-5 pl-md-5">

                                <div class="media block-6">
                                    
                                    <div class="media-body">
                                        <h3 class="heading border-bottom">${s.name}</h3>
                                        <p>${s.description}.</p>
                                    </div>
                                </div>     


                            </div>

                        </div>
                    </c:forEach>
                </div>
                <div class="row mb-5 pt-5 justify-content-center">
                    <div class="col-md-7 text-center section-heading">
                        <h2 class="heading">More Services</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reprehenderit, iusto, omnis! Quidem, sint, impedit? Dicta eaque delectus tempora hic, corporis velit doloremque quod quam laborum, nobis iusto autem culpa quaerat!</p>
                    </div>
                </div>


            </div>
        

        <jsp:include page="../../include/user/footer.jsp"/>

        <jsp:include page="../../include/user/js-page.jsp"/>
    </body>
</html>
