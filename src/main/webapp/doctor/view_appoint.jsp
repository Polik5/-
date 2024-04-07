<%@ page import="com.example.sanatoriy.entity.Doctor" %>
<%@ page import="com.example.sanatoriy.db.DBConnect" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.sanatoriy.dao.PatientDao" %>
<%@ page import="com.example.sanatoriy.entity.Patient" %>
<%@ page import="com.example.sanatoriy.dao.AppointmentDao" %>
<%@ page import="com.example.sanatoriy.entity.Appointment" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Insert title here</title>
    <%@include file="/component/allcss.jsp"%>
    <style type="text/css">
        .paint-card {
            box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body>
<c:if test="${empty doctObj }">
    <c:redirect url="../doctor_login.jsp"></c:redirect>
</c:if>


<%@include file="navbar.jsp"%>
<div class="container p-3">
    <div class="row">

        <div class="col-md-12">
            <div class="card paint-card">
                <div class="card-body">
                    <p class="fs-3 text-center">Мои пациенты</p>
                    <c:if test="${not empty errorMsg}">
                        <p class="fs-4 text-center text-danger">${errorMsg}</p>
                        <c:remove var="errorMsg" scope="session" />
                    </c:if>
                    <c:if test="${not empty succMsg}">
                        <p class=" fs-4 text-center text-success">${succMsg}</p>
                        <c:remove var="succMsg" scope="session" />
                    </c:if>

                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Врач</th>
                            <th scope="col">Пациент</th>
                            <th scope="col">Лечение</th>
                            <th scope="col">Дней прошло</th>
                            <th scope="col">Дней всего</th>
                            <th scope="col">Дата назначения</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
