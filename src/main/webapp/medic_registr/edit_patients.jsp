<%@ page import="com.example.sanatoriy.dao.DoctorDao" %>
<%@ page import="com.example.sanatoriy.entity.Doctor" %>
<%@ page import="com.example.sanatoriy.db.DBConnect" %>
<%@ page import="com.example.sanatoriy.dao.SpecialistDao" %>
<%@ page import="com.example.sanatoriy.entity.Specalist" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.sanatoriy.dao.PatientDao" %>
<%@ page import="com.example.sanatoriy.entity.Patient" %>
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
                    <p class="fs-3 text-center">Редактировать сведения об отдыхающем</p>
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
                        PatientDao dao2 = new PatientDao(DBConnect.getConn());
                        Patient p = dao2.getPatientById(id);
                    %>
                    <form action="../updatePatient" method="post">
                        <div class="mb-3">
                            <label class="form-label">ФИО</label> <input type="text"
                                                                         required name="full_name" class="form-control" value="<%=p.getFullName()%>">
                        </div>

                        <%--                        <div class="mb-3">--%>
                        <%--                            <label class="form-label">Пол</label> <input type="text"--%>
                        <%--                                                                         required name="gender" class="form-control">--%>
                        <%--                        </div>--%>

                        <div class="col-md-6">
                            <label>Пол</label> <select class="form-control" name="gender"
                                                       required>
                            <option><%=p.getGender()%></option>
                            <option value="male">М</option>
                            <option value="female">Ж</option>
                        </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Дата рождения</label> <input type="date"
                                                                                   required name="dob" class="form-control" value="<%=p.getDob()%>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Город проживания</label> <input required
                                                                                      name="address" type="text" class="form-control" value="<%=p.getAddress()%>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Дата приезда</label> <input type="date"
                                                                                  required name="arrival" class="form-control" value="<%=p.getArrival()%>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Дата выезда</label> <input type="date"
                                                                                 required name="departure" class="form-control" value="<%=p.getDeparture()%>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Диагноз</label> <input required
                                                                             name="diseases" type="text" class="form-control" value="<%=p.getDiseases()%>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Выбрать врача</label> <select name="doctor_id"
                                                                                    required class="form-control" value="<%=p.getDoctorId()%>">
                            <option><%=p.getDoctorId()%></option>
                            <%
                                DoctorDao dao = new DoctorDao(DBConnect.getConn());
                                List<Doctor> list = dao.getAllDoctor();
                                for (Doctor d : list) {
                            %>
                            <option value="<%=d.getId()%>"><%=d.getFullName()%> (<%=d.getSpecialist()%>)
                            </option>
                            <%
                                }
                            %>
                        </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Дата приема у врача</label> <input type="date"
                                                                                         required name="appoint_date" class="form-control" value="<%=p.getAppoinDate()%>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Номер телефона</label> <input type="text"
                                                                                    required name="mobno" class="form-control" value="<%=p.getMobNo()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Email</label> <input type="text"
                                                                           required name="email" class="form-control" value="<%=p.getEmail()%>">
                        </div>
                        <input type="hidden" name="id" value="<%=p.getId()%>">

                        <button type="submit" class="btn btn-primary">Обновить</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
