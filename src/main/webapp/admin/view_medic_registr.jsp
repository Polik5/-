<%@ page import="java.util.List" %>
<%@ page import="com.example.sanatoriy.dao.MedRegistrDao" %>
<%@ page import="com.example.sanatoriy.db.DBConnect" %>
<%@ page import="com.example.sanatoriy.entity.MedRegistr" %>
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
<div class="container-fluid p-3">
    <div class="row">
        <div class="col-md-12">
            <div class="card paint-card">
                <div class="card-body">
                    <p class="fs-3 text-center">Медицинские регистраторы санатория</p>
                    <c:if test="${not empty errorMsg}">
                        <p class="fs-3 text-center text-danger">${errorMsg}</p>
                        <c:remove var="errorMsg" scope="session" />
                    </c:if>
                    <c:if test="${not empty succMsg}">
                        <div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
                        <c:remove var="succMsg" scope="session" />
                    </c:if>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">ФИО</th>
                            <th scope="col">Дата рождения</th>
                            <th scope="col">Номер телефона</th>
                            <th scope="col">Email</th>
                            <th scope="col">Действие</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            MedRegistrDao dao2 = new MedRegistrDao(DBConnect.getConn());
                            List<MedRegistr> list2 = dao2.getAllMedRegistr();
                            for (MedRegistr m : list2) {
                        %>
                        <tr>
                            <td><%=m.getFullName()%></td>
                            <td><%=m.getDob()%></td>
                            <td><%=m.getMobNo()%></td>
                            <td><%=m.getEmail()%></td>
                            <td><a href="edit_medic_registr.jsp?id=<%=m.getId()%>"
                                   class="btn btn-sm btn-primary">Edit</a>

                                <a
                                        href="../deleteMedRegistr?id=<%=m.getId()%>"
                                        class="btn btn-sm btn-danger">Delete</a></td>
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