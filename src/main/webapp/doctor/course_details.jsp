<%@ page import="com.example.sanatoriy.dao.SpecialistDao" %>
<%@ page import="com.example.sanatoriy.entity.Specalist" %>
<%@ page import="com.example.sanatoriy.entity.Procedure" %>
<%@ page import="com.example.sanatoriy.db.DBConnect" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.sanatoriy.entity.Doctor" %>
<%@ page import="com.example.sanatoriy.dao.DoctorDao" %>
<%@ page import="com.example.sanatoriy.dao.CourseDao" %>
<%@ page import="com.example.sanatoriy.entity.Course" %>
<%@ page import="com.example.sanatoriy.dao.ProcedureDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Insert title here</title>
    <%@include file="../component/allcss.jsp"%>
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
<div class="container-fluid p-3">
    <div class="row">

        <div class="col-md-5 offset-md-4">
            <div class="card paint-card">
                <div class="card-body">
                    <p class="fs-3 text-center">Добавить детали курса</p>
                    <c:if test="${not empty errorMsg}">
                        <p class="fs-3 text-center text-danger">${errorMsg}</p>
                        <c:remove var="errorMsg" scope="session" />
                    </c:if>
                    <c:if test="${not empty succMsg}">
                        <div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
                        <c:remove var="succMsg" scope="session" />
                    </c:if>
                    <form action="../addСourseDetails" method="post">
                        <div class="mb-3">
                            <label class="form-label">Курс</label> <select name="cour_id"
                                                                                    required class="form-control">
                            <option>--select--</option>

                            <option value="">--select--</option>
                            <%
                                CourseDao dao = new CourseDao(DBConnect.getConn());
                                List<Course> list = dao.getAllCourse();
                                for (Course c : list) {
                            %>
                            <option value="<%=c.getId()%>"><%=c.getCourse_name()%>
                            </option>
                            <%
                                }
                            %>
                        </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Процедура</label> <select name="proc_id"
                                                                           required class="form-control">
                            <option>--select--</option>

                            <option value="">--select--</option>
                            <%
                                ProcedureDao dao2 = new ProcedureDao(DBConnect.getConn());
                                List<Procedure> list2 = dao2.getAllProcedure();
                                for (Procedure c : list2) {
                            %>
                            <option value="<%=c.getId()%>"><%=c.getProcedure_name()%>
                            </option>
                            <%
                                }
                            %>
                        </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Количество дней на процедуру</label> <input type="text"
                                                                                    required name="col_day" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-primary">Добавить</button>
                    </form>
                </div>
            </div>
        </div>



    </div>
</div>
</body>
</html>
