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
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link" href="index.jsp">ГЛАВНАЯ</a></li>
                <li class="nav-item"><a class="nav-link" href="view_patient.jsp">МОИ ПАЦИЕНТЫ</a></li>
                <li class="nav-item"><a class="nav-link" href="write_appointment.jsp">НАЗНАЧЕНИЯ</a></li>
                <li class="nav-item"><a class="nav-link" href="course_details.jsp">ДЕТАЛИ КУРСОВ</a></li>
            </ul>
            <form class="d-flex">
                <div class="dropdown">
                    <button class="btn btn-light dropdown-toggle" type="button"
                            id="dropdownMenuButton1" data-bs-toggle="dropdown"
                            aria-expanded="false">
                        <i class="fas fa-user-circle"></i> ${doctObj.fullName }
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                        <li><a class="dropdown-item" href="../doctorLogout">Выход</a></li>
                    </ul>
                </div>
            </form>
        </div>
    </div>
</nav>