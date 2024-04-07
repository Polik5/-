<%@ page import="com.example.sanatoriy.entity.Doctor" %>
<%@ page import="com.example.sanatoriy.db.DBConnect" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.sanatoriy.dao.PatientDao" %>
<%@ page import="com.example.sanatoriy.entity.Patient" %>
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
                            <th scope="col">ФИО</th>
                            <th scope="col">Пол</th>
                            <th scope="col">Дата рождения</th>
                            <th scope="col">Город</th>
                            <th scope="col">Приезд</th>
                            <th scope="col">Выезд</th>
                            <th scope="col">Диагноз</th>
                            <th scope="col">Прием</th>
                            <th scope="col">Телефон</th>
                            <th scope="col">Email</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            Doctor d = (Doctor) session.getAttribute("doctObj");
                            //Appointment ap = (Appointment) session.getAttribute("doctObj");
                            PatientDao dao = new PatientDao(DBConnect.getConn());
                            List<Patient> list = dao.getAllPatientByDoctorLogin(d.getId());
                            for (Patient p : list) {
                        %>
                        <tr>
                            <td><%=p.getFullName()%></td>
                            <td><%=p.getGender()%></td>
                            <td><%=p.getDob()%></td>
                            <td><%=p.getAddress()%></td>
                            <td><%=p.getArrival()%></td>
                            <td><%=p.getDeparture()%></td>
                            <td><%=p.getDiseases()%></td>
                            <td><%=p.getAppoinDate()%></td>
                            <td><%=p.getMobNo()%></td>
                            <td><%=p.getEmail()%></td>

                            <td>
                                <a href="comment.jsp?id=<%=p.getId()%>"
                                   class="btn btn-success btn-sm">Дать назначение</a>
                            </td>

                            </td>
                        </tr>
                        <%
                            }
                        %>



                        </tbody>
                    </table>

                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>
