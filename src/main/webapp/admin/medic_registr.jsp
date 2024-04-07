<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%@include file="navbar.jsp"%>
<div class="container-fluid p-3">
    <div class="row">
        <div class="col-md-5 offset-md-4">
            <div class="card paint-card">
                <div class="card-body">
                    <p class="fs-3 text-center">Добавить медицинского регистратора</p>
                    <c:if test="${not empty errorMsg}">
                        <p class="fs-3 text-center text-danger">${errorMsg}</p>
                        <c:remove var="errorMsg" scope="session" />
                    </c:if>
                    <c:if test="${not empty succMsg}">
                        <div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
                        <c:remove var="succMsg" scope="session" />
                    </c:if>
                    <form action="../addMedRegistr" method="post">
                        <div class="mb-3">
                            <label class="form-label">ФИО</label> <input type="text"
                                                                         required name="fullname" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Дата рождения</label> <input type="date"
                                                                                   required name="dob" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Номер телефона</label> <input type="text"
                                                                                    required name="mobno" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Email</label> <input type="text"
                                                                           required name="email" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Пароль</label> <input required
                                                                            name="password" type="password" class="form-control">
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