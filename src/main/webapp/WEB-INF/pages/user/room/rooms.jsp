<%-- 
    Document   : rooms
    Created on : Oct 20, 2022, 8:06:02 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                        <span class="subheading-sm">Rooms</span>
                        <h2 class="heading">Rooms &amp; Suites</h2>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row mb-5">
                <div class="col-md-12 mb-12">
                    <form action="<c:url value="/search-room"/>" >
                        <div class="row">
                            <div class="col-md-6     mb-3 mb-lg-0 col-lg-10">
                                <label></label>
                                <div class="field-icon-wrap">

                                    <input type="text"  name="value"value="${value}"  placeholder="Search" class="form-control">
                                </div>
                            </div>

                            <div class="col-md-6 col-lg-2 align-self-end">
                                <button class="btn btn-primary btn-block"><i class="fa-solid fa-magnifying-glass"></i>  Search</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div class="site-section bg-light">
            <div class="container">
                <div class="row mb-5">
                    <div class="col-md-12 mb-5">
                        <c:forEach items="${rooms.content}" var="r">
                            <div class="block-3 d-md-flex">
                                <c:forEach items="${images}" var="i">
                                    <c:if test="${r.id==i.roomCategory.id}">
                                        <div class="image" style="background-image: url('resources/user/images/${i.name}'); "></div>
                                    </c:if>
                                </c:forEach>
                                <div class="text">

                                    <h2 class="heading">${r.name}</h2>
                                    <div class="price"><sup>$</sup><span class="number"><fmt:formatNumber value="${r.price}"/></span><sub>/per night</sub></div>
                                    <ul class="specs mb-5">
                                        <li><strong>Adults:</strong>${r.numberAdult}</li>
                                        <li><strong>Categories:</strong> Single</li>
                                        <li><strong>Facilities:</strong> Closet with hangers, HD flat-screen TV, Telephone</li>
                                        <li><strong>Size:</strong> ${r.area}m<sup>2</sup></li>
                                        <li><strong>Bed Type:</strong> ${r.numberBed}</li>
                                    </ul>

                                   

                                </div>
                            </div>
                            <br>
                        </c:forEach>

                    </div>  







                </div>


                <div class="row mb-5 pt-5 justify-content-center">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">

                            <li class="page-item <c:if test="${currentPage==1}">
                                disabled
                                </c:if>"
                                ><a class="page-link" href="${pageContext.request.contextPath}/<c:if test="${action=='view'}">rooms?</c:if><c:if test="${action=='search'}">search-room?value=${value}&</c:if>page=${currentPage - 1}&size=${pageSize}">Previous</a>
                            </li>
                            <c:forEach var="page" begin="1" end="${totalPages}">
                                <li class="page-item disable"><a class="page-link" href="${pageContext.request.contextPath}/<c:if test="${action=='view'}">rooms?</c:if><c:if test="${action=='search'}">search-room?value=${value}&</c:if>page=${page}&size=${pageSize}">${page}</a></li>
                            </c:forEach>

                            <li class="page-item <c:if test="${currentPage==totalPages}">
                                disabled</c:if>"
                                "><a class="page-link" href="${pageContext.request.contextPath}/<c:if test="${action=='view'}">rooms?</c:if><c:if test="${action=='search'}">search-room?value=${value}&</c:if>page=${currentPage + 1}&size=${pageSize}">Next</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="row mb-5 pt-5 justify-content-center">
                    <div class="col-md-7 text-center section-heading">
                        <h2 class="heading">More Rooms</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reprehenderit, iusto, omnis! Quidem, sint, impedit? Dicta eaque delectus tempora hic, corporis velit doloremque quod quam laborum, nobis iusto autem culpa quaerat!</p>
                    </div>
                </div>


            </div>
        </div>

        <jsp:include page="../../include/user/footer.jsp"/>

        <jsp:include page="../../include/user/js-page.jsp"/>
    </body>
</html>
