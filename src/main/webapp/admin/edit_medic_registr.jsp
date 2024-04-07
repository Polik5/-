<%@ page import="com.example.sanatoriy.db.DBConnect" %>
<%@ page import="com.example.sanatoriy.dao.SpecialistDao" %>
<%@ page import="com.example.sanatoriy.entity.Specalist" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.sanatoriy.dao.MedRegistrDao" %>
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

        <div class="col-md-4 offset-md-4">
            <div class="card paint-card">
                <div class="card-body">
                    <p class="fs-3 text-center">Редактировать сведения о мед.регистраторе</p>
                    <c:if test="${not empty errorMsg}">
                        <p class="fs-3 text-center text-danger">${errorMsg}</p>
                        <c:remove var="errorMsg" scope="session" />
                    </c:if>
                    <c:if test="${not empty succMsg}">
                        <div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
                        <c:remove var="succMsg" scope="session" />
                    </c:if>

                    <%
                        int id = Integer.parseInt(request.getParameter("id"));
                        MedRegistrDao dao2 = new MedRegistrDao(DBConnect.getConn());
                        MedRegistr m = dao2.getMedRegistrById(id);
                    %>


                    <form action="../updateMedRegistr" method="post">
                        <div class="mb-3">
                            <label class="form-label">ФИО</label> <input type="text"
                                                                         required name="fullname" class="form-control"
                                                                         value="<%=m.getFullName()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Дата рождения</label> <input type="date"
                                                                                   value="<%=m.getDob()%>" required name="dob"
                                                                                   class="form-control">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Номер телефона</label> <input type="text"
                                                                                    value="<%=m.getMobNo()%>" required name="mobno"
                                                                                    class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Email</label> <input type="text"
                                                                           value="<%=m.getEmail()%>" required name="email"
                                                                           class="form-control">
                        </div>


                        <div class="mb-3">
                            <label class="form-label">Пароль</label> <input required
                                                                            value="<%=m.getPassword()%>" name="password" type="text"
                                                                            class="form-control">
                        </div>
                        <input type="hidden" name="id" value="<%=m.getId()%>">

                        <button type="submit" class="btn btn-primary col-md-12">Обновить</button>
                    </form>
                </div>
            </div>
        </div>




    </div>
</div>
</body>
</html>
