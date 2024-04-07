<%@ page import="com.example.sanatoriy.dao.DoctorDao" %>
<%@ page import="com.example.sanatoriy.entity.Doctor" %>
<%@ page import="com.example.sanatoriy.db.DBConnect" %>
<%@ page import="com.example.sanatoriy.dao.SpecialistDao" %>
<%@ page import="com.example.sanatoriy.entity.Specalist" %>
<%@ page import="java.util.List" %>
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
                    <p class="fs-3 text-center">Редактировать сведения о враче</p>
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
                        DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
                        Doctor d = dao2.getDoctorById(id);
                    %>


                    <form action="../updateDoctor" method="post">
                        <div class="mb-3">
                            <label class="form-label">ФИО</label> <input type="text"
                                                                               required name="fullname" class="form-control"
                                                                               value="<%=d.getFullName()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Дата рождения</label> <input type="date"
                                                                         value="<%=d.getDob()%>" required name="dob"
                                                                         class="form-control">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Классификация</label> <input required
                                                                                   value="<%=d.getQualification()%>" name="qualification"
                                                                                   type="text" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Специализация</label> <select name="spec"
                                                                                 required class="form-control">
                            <option><%=d.getSpecialist()%></option>

                            <%
                                SpecialistDao dao = new SpecialistDao(DBConnect.getConn());
                                List<Specalist> list = dao.getAllSpecialist();
                                for (Specalist s : list) {
                            %>
                            <option><%=s.getSpecialistName()%></option>
                            <%
                                }
                            %>


                        </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Email</label> <input type="text"
                                                                           value="<%=d.getEmail()%>" required name="email"
                                                                           class="form-control">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Номер телефона</label> <input type="text"
                                                                            value="<%=d.getMobNo()%>" required name="mobno"
                                                                            class="form-control">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Пароль</label> <input required
                                                                              value="<%=d.getPassword()%>" name="password" type="text"
                                                                              class="form-control">
                        </div>
                        <input type="hidden" name="id" value="<%=d.getId()%>">

                        <button type="submit" class="btn btn-primary col-md-12">Обновить</button>
                    </form>
                </div>
            </div>
        </div>




    </div>
</div>
</body>
</html>
