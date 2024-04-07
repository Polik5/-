<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp"><i
                class="fas fa-clinic-medical"></i>   Southern Sanatorium</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <c:if test="${empty userObj }">
                    <li class="nav-item"><a class="nav-link active"
                                            aria-current="page" href="admin_login.jsp"><i
                            class="fas fa-sign-in-alt"></i> УПРАВЛЯЮЩИЙ</a></li>
                    <li class="nav-item"><a class="nav-link active"
                                            aria-current="page" href="doctor_login.jsp">ВРАЧ</a></li>
<%--                    <li class="nav-item"><a class="nav-link active"--%>
<%--                                            aria-current="page" href="user_appointment.jsp">APPOINTMENT</a></li>--%>
                    <li class="nav-item"><a class="nav-link active"
                                            aria-current="page" href="medic_registr_login.jsp">РЕГИСТРАТОР</a></li>

                </c:if>







            </ul>
        </div>
    </div>
</nav>