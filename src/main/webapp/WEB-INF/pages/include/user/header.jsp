<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  uri="http://www.springframework.org/security/tags" 
           prefix="sec" %>
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="<c:url value="/home"/>">BrightHotel</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a href="<c:url value="/home"/>" class="nav-link">Home</a></li>
                <li class="nav-item"><a href="<c:url value="/rooms"/>" class="nav-link">Rooms</a></li>
                <li class="nav-item"><a href="<c:url value="/services"/>" class="nav-link">Services</a></li>
                

                <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item"><a href="<c:url value="/register"/> " class="nav-link">Register</a></li>
                    <li class="nav-item " ><a href="<c:url value="/login"/> " class="nav-link">  Login</a></li>

                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item "  >

                        <div class="dropdown nav-link">
                            <a class= " active a  dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                              <i class="fa-solid fa-user"></i>  Account
                            </a>

                            <div class="dropdown-menu">
                                <a class=" dropdown-item" href="<c:url value="/manage-account"/>"><i class="fas fa-user"></i>  Account Infor</a>

                                <a class=" dropdown-item" href="<c:url value="/manage-user-booking"/>"><i class="fas fa-history"></i> Manage Booking</a>
                                <a class=" dropdown-item" href="<c:url value="/logout"/>"><i class="fas fa-sign-out-alt"></i> Logout</a>
                            </div>
                        </div>


                    </li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>
