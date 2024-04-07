<%@ page import="com.example.sanatoriy.dao.DoctorDao" %>
<%@ page import="com.example.sanatoriy.entity.Doctor" %>
<%@ page import="com.example.sanatoriy.db.DBConnect" %>
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
        .search-form {
            display: flex;
            width: 100%;
        }

        input[type="text"] {
            flex: 1;
            padding: 10px;
            border-radius: 5px 0 0 5px;
            border: 1px solid #ccc;
        }

        input[type="submit"] {
            padding: 10px 20px;
            border-radius: 0 5px 5px 0;
            background-color: #4CAF50;
            color: white;
            border: none;
            box-shadow: 2px 2px 5px #888888;
        }
    </style>
<%--    <script>--%>
<%--        document.getElementById('downloadBtn').addEventListener('click', function() {--%>
<%--            var table = document.querySelector('table');--%>
<%--            var html = table.outerHTML;--%>
<%--            var blob = new Blob([html], { type: 'application/vnd.ms-excel' });--%>
<%--            var filename = 'patients_table.xls';--%>
<%--            if (window.navigator.msSaveOrOpenBlob) {--%>
<%--                window.navigator.msSaveOrOpenBlob(blob, filename);--%>
<%--            } else {--%>
<%--                var elem = window.document.createElement('a');--%>
<%--                elem.href = window.URL.createObjectURL(blob);--%>
<%--                elem.download = filename;--%>
<%--                document.body.appendChild(elem);--%>
<%--                elem.click();--%>
<%--                document.body.removeChild(elem);--%>
<%--            }--%>
<%--        });--%>

<%--        function hidePatient(patientId) {--%>
<%--            var patientRow = document.getElementById('patient_' + patientId);--%>
<%--            patientRow.style.display = 'none';--%>
<%--        }--%>
<%--    </script>--%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container-fluid p-3">
    <div class="row">
        <div class="col-md-12">
            <div class="card paint-card">
                <div class="card-body">

                    <p class="fs-3 text-center">Отдыхающие санатория</p>
                    <c:if test="${not empty errorMsg}">
                        <p class="fs-3 text-center text-danger">${errorMsg}</p>
                        <c:remove var="errorMsg" scope="session" />
                    </c:if>
                    <c:if test="${not empty succMsg}">
                        <div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
                        <c:remove var="succMsg" scope="session" />
                    </c:if>
                    <form action="view_patients.jsp" method="get">
                        <input type="text" name="full_name" placeholder="Поиск по ФИО" />
                        <input type="submit" value="Поиск" />
                    </form>
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
                            <th scope="col">Врач</th>
                            <th scope="col">Прием</th>
                            <th scope="col">Телефон</th>
                            <th scope="col">Email</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%

                            String fullName = request.getParameter("full_name");
                            PatientDao dao2 = new PatientDao(DBConnect.getConn());
                            DoctorDao dao = new DoctorDao(DBConnect.getConn());
                            List<Patient> list2;
                            if (fullName != null && !fullName.isEmpty()) {
                                list2 = dao2.getPatientsByName(fullName);
                            } else {
                                list2 = dao2.getAllPatient();
                            }
                            for (Patient p : list2) {
                                Doctor d = dao.getDoctorById(p.getDoctorId());
                        %>
                        <tr id="patient_<%=p.getId()%>">
                            <td><%=p.getFullName()%></td>
                            <td><%=p.getGender()%></td>
                            <td><%=p.getDob()%></td>
                            <td><%=p.getAddress()%></td>
                            <td><%=p.getArrival()%></td>
                            <td><%=p.getDeparture()%></td>
                            <td><%=p.getDiseases()%></td>
                            <td><%=d.getFullName()%></td>
                            <td><%=p.getAppoinDate()%></td>
                            <td><%=p.getMobNo()%></td>
                            <td><%=p.getEmail()%></td>

                            <td><a href="edit_patients.jsp?id=<%=p.getId()%>" class="btn btn-sm btn-primary">Edit</a>
                                <a class="btn btn-sm btn-danger" onclick="hidePatient('<%=p.getId()%>')">Выезд</a>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                    <button id="downloadBtn">Скачать отчет об отдыхающих</button>
                    <script>
                        document.getElementById('downloadBtn').addEventListener('click', function() {
                            var table = document.querySelector('table');
                            var html = table.outerHTML;
                            var blob = new Blob([html], { type: 'application/vnd.ms-excel' });
                            var filename = 'patients_table.xls';
                            if (window.navigator.msSaveOrOpenBlob) {
                                window.navigator.msSaveOrOpenBlob(blob, filename);
                            } else {
                                var elem = window.document.createElement('a');
                                elem.href = window.URL.createObjectURL(blob);
                                elem.download = filename;
                                document.body.appendChild(elem);
                                elem.click();
                                document.body.removeChild(elem);
                            }
                        });
                        function hidePatient(patientId) {
                            var patientRow = document.getElementById('patient_' + patientId);
                            patientRow.style.display = 'none';
                        }
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
