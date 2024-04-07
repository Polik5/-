<%@ page import="com.example.sanatoriy.entity.Appointment" %>
<%@ page import="com.example.sanatoriy.db.DBConnect" %>
<%@ page import="com.example.sanatoriy.dao.AppointmentDao" %>
<%@ page import="com.example.sanatoriy.dao.DoctorDao" %>
<%@ page import="com.example.sanatoriy.entity.Doctor" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.sanatoriy.dao.PatientDao" %>
<%@ page import="com.example.sanatoriy.entity.Patient" %>
<%@ page import="com.example.sanatoriy.dao.CourseDao" %>
<%@ page import="com.example.sanatoriy.entity.Course" %>
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

        .backImg {
            background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
            url("../img/5.jpeg");
            height: 20vh;
            width: 100%;
            background-size: cover;
            background-repeat: no-repeat;
        }
    </style>
    <%@include file="/component/allcss.jsp"%>
</head>
<body>
<c:if test="${empty doctObj }">
    <c:redirect url="../doctor_login.jsp"></c:redirect>
</c:if>


<%@include file="navbar.jsp"%>
<div class="container-fulid backImg p-5">
    <p class="text-center fs-2 text-white"></p>
</div>
<div class="container p-3">
    <div class="row">

        <div class="col-md-5 offset-md-4">
            <div class="card paint-card">
                <div class="card-body">
                    <p class="fs-3 text-center">Назначение отдыхающему</p>
                    <%
                        int id = Integer.parseInt(request.getParameter("id"));
                        AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
                        Appointment ap = dao.getAppointmentById(id);
                    %>
                    <c:if test="${not empty errorMsg}">
                        <p class="fs-3 text-center text-danger">${errorMsg}</p>
                        <c:remove var="errorMsg" scope="session" />
                    </c:if>
                    <c:if test="${not empty succMsg}">
                        <div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
                        <c:remove var="succMsg" scope="session" />
                    </c:if>
                    <form action="write_appointment.jsp" method="post">
                        <div class="mb-3">
                            <label class="form-label">Врач</label> <select name="doctor_id"
                                                                                    required class="form-control">
                            <%

                                Doctor d = (Doctor) session.getAttribute("doctObj");
                                DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
                                int doctor_id = d.getId();
                                int d_spec = dao2.getSpecialistIdByName(d.getSpecialist());

                            %>
                            <option value="<%=doctor_id%>"><%=d.getFullName()%> (<%=d.getSpecialist()%>)
                            </option>

                            </option>

                        </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Пациент</label> <select name="patient_id"
                                                                           required class="form-control">
                            <%
                                PatientDao dao5 = new PatientDao(DBConnect.getConn());
                                int id3 = Integer.parseInt(request.getParameter("id"));
                                Patient p1 = dao5.getPatientById(id3);

                            %>
                            <option value="<%=p1.getId()%>"><%=p1.getFullName()%>
                            </option>

                        </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Курс</label> <select name=""
                                                                                    required class="form-control">
                            <option>--select--</option>

                            <option value=""></option>
                            <%
                                CourseDao dao3 = new CourseDao(DBConnect.getConn());
                                List<Course> list = dao3.getCoursesByDoctorSpecialtyId(d_spec);
                                for (Course co : list) {
                            %>
                            <option value="<%=co.getId()%>"><%=co.getCourse_name()%>
                            </option>
                            <%
                                }
                            %>
                        </select>
                        </div>
                        <button type="submit" class="btn btn-primary">Назначить</button>
                    </form>
                </div>
            </div>
        </div>



    </div>
</div>



</body>
</html>
