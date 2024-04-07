<%@ page import="com.example.sanatoriy.db.DBConnect" %>
<%@ page import="com.example.sanatoriy.entity.Specalist" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.sanatoriy.dao.*" %>
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

<c:if test="${ empty adminObj }">
    <c:redirect url="../admin_login.jsp"></c:redirect>
</c:if>

<div class="container p-5">
    <p class="text-center fs-3">Панель управляющего</p>
    <c:if test="${not empty errorMsg}">
        <p class="fs-3 text-center text-danger">${errorMsg}</p>
        <c:remove var="errorMsg" scope="session" />
    </c:if>
    <c:if test="${not empty succMsg}">
        <div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
        <c:remove var="succMsg" scope="session" />
    </c:if>
    <%
        DoctorDao dao = new DoctorDao(DBConnect.getConn());
        MedRegistrDao dao1 = new MedRegistrDao(DBConnect.getConn());
        CourseDao dao2 = new CourseDao(DBConnect.getConn());
        ProcedureDao dao4 = new ProcedureDao(DBConnect.getConn());
    %>
    <div class="row">
        <div class="col-md-4">
            <div class="card paint-card">
                <div class="card-body text-center text-success">
                    <i class="fas fa-user-md fa-3x"></i><br>
                    <p class="fs-4 text-center">
                        Количество врачей <br><%=dao.countDoctor()%>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card paint-card">
                <div class="card-body text-center text-success">
                    <i class="fas fa-user-circle fa-3x"></i><br>
                    <p class="fs-4 text-center">
                        Количество мед. регистраторов <br><%=dao1.countMedRegistr()%>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-md-4 mt-2">

            <div class="card paint-card " data-bs-toggle="modal"
                 data-bs-target="#exampleModal">
                <div class="card-body text-center text-success">
                    <i class="far fa-calendar-check fa-3x"></i><br>
                    <p class="fs-4 text-center">
                        Количество специализаций врачей <br><%=dao.countSpecialist()%>
                    </p>
                </div>
            </div>

        </div>
        <div class="col-md-4 mt-2">
            <div class="card paint-card " data-bs-toggle="modal"
                 data-bs-target="#exampleModal2">
                <div class="card-body text-center text-success">
                    <i class="far fa-calendar-check fa-3x"></i><br>
                    <p class="fs-4 text-center">
                        Количество курсов в санатории <br><%=dao2.countCourse()%>
                    </p>
                </div>
            </div>

        </div>
        <div class="col-md-4 mt-2">
            <div class="card paint-card " data-bs-toggle="modal"
                 data-bs-target="#exampleModal3">
                <div class="card-body text-center text-success">
                    <i class="far fa-calendar-check fa-3x"></i><br>
                    <p class="fs-4 text-center">
                        Количество процедур в санатории <br><%=dao4.countProcedure()%>
                    </p>
                </div>
            </div>

        </div>

    </div>
</div>

<!-- Modal1 -->
<div class="modal fade" id="exampleModal" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="../addSpecialist" method="post">

                    <div class="form-group">
                        <label>Введите специализацию</label> <input type="text"
                                                                    name="specName" class="form-control">
                    </div>
                    <div class="text-center mt-3">
                        <button type="submit" class="btn btn-primary">Добавить</button>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary"
                        data-bs-dismiss="modal">Закрыть</button>

            </div>
        </div>
    </div>
</div>

<!-- Modal2 -->
<div class="modal fade" id="exampleModal2" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel2">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="../addCourse" method="post">

                    <div class="form-group">
                        <label>Введите название курса</label> <input type="text"
                                                                    name="course_name" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Специализация курса</label> <select name="spec_id"
                                                                                required class="form-control">
                        <option>--select--</option>
                        <option value="">--select--</option>
                        <%
                            SpecialistDao dao3 = new SpecialistDao(DBConnect.getConn());
                            List<Specalist> list = dao3.getAllSpecialist();
                            for (Specalist s : list) {
                        %>
                        <option value="<%=s.getId()%>"><%=s.getSpecialistName()%></option>
                        <%
                            }
                        %>
                    </select>
                    </div>
<%--                    <div class="form-group">--%>
<%--                        <label>Количество дней курса</label> <input type="text"--%>
<%--                                                                     name="col_day" class="form-control">--%>
<%--                    </div>--%>
                    <div class="text-center mt-3">
                        <button type="submit" class="btn btn-primary">Добавить</button>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary"
                        data-bs-dismiss="modal">Закрыть</button>

            </div>
        </div>
    </div>
</div>

<!-- Modal3 -->
<div class="modal fade" id="exampleModal3" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel3">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="../addProcedure" method="post">

                    <div class="form-group">
                        <label>Введите название процедуры</label> <input type="text"
                                                                    name="procedure_name" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Кабинет</label> <input type="text"
                                                                    name="office" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Время на одну процедуру(часы)</label> <input type="text"
                                                                         name="time" class="form-control">
                    </div>
                    <div class="text-center mt-3">
                        <button type="submit" class="btn btn-primary">Добавить</button>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary"
                        data-bs-dismiss="modal">Закрыть</button>

            </div>
        </div>
    </div>
</div>
</body>
</html>
