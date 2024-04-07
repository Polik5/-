<%@ page import="com.example.sanatoriy.db.DBConnect" %>
<%@ page import="com.example.sanatoriy.dao.PatientDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%@include file="navbar.jsp"%>

<c:if test="${ empty medicObj }">
    <c:redirect url="../medic_registr_login.jsp"></c:redirect>
</c:if>

<div class="container p-5">
    <p class="text-center fs-3">Панель медицинского регистратора</p>
    <c:if test="${not empty errorMsg}">
        <p class="fs-3 text-center text-danger">${errorMsg}</p>
        <c:remove var="errorMsg" scope="session" />
    </c:if>
    <c:if test="${not empty succMsg}">
        <div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
        <c:remove var="succMsg" scope="session" />
    </c:if>
    <%
        PatientDao dao = new PatientDao(DBConnect.getConn());
    %>
    <div class="row">
        <div class="col-md-4">
            <div class="card paint-card">
                <div class="card-body text-center text-success">
                    <i class="fas fa-user-md fa-3x"></i><br>
                    <p class="fs-4 text-center">
                        Количество отдыхающих <br><%=dao.countPatient()%>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
