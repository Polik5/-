<%@ page import="com.example.sanatoriy.entity.Doctor" %>
<%@ page import="com.example.sanatoriy.dao.DoctorDao" %>
<%@ page import="com.example.sanatoriy.db.DBConnect" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Insert title here</title>
    <style type="text/css">
        .paint-card {
            box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
        }
    </style>
    <%@include file="/component/allcss.jsp"%>
</head>
<body>
<c:if test="${empty doctObj }">
    <c:redirect url="../doctor_login.jsp"></c:redirect>
</c:if>


<%@include file="navbar.jsp"%>

<p class="text-center fs-3">Панель доктора</p>

<%
    Doctor d = (Doctor) session.getAttribute("doctObj");
    DoctorDao dao = new DoctorDao(DBConnect.getConn());
%>
<div class="container p-5">
    <div class="row">
        <div class="col-md-4 offset-md-2">
            <div class="card paint-card">
                <div class="card-body text-center text-success">
                    <i class="fas fa-user-md fa-3x"></i><br>
                    <p class="fs-4 text-center">
                        Количество пациентов <br> <%=dao.countAppointmentByDocotrId(d.getId())%>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
