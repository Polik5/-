<%@ page import="java.sql.Connection" %>
<%@ page import="com.example.sanatoriy.db.DBConnect" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<%@include file="/component/navbar.jsp"%>
<%Connection conn = DBConnect.getConn();
    System.out.println(conn);%>
<div id="carouselExampleIndicators" class="carousel slide"
     data-bs-ride="carousel">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="0" class="active" aria-current="true"
                aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="img/11.png" class="d-block w-100" alt="..."
                 height="500px">
        </div>
        <div class="carousel-item">
            <img src="img/22.png" class="d-block w-100" alt="..."
                 height="500px">
        </div>
        <div class="carousel-item">
            <img src="img/33.png" class="d-block w-100" alt="..."
                 height="500px">
        </div>
    </div>
    <button class="carousel-control-prev" type="button"
            data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
            class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button"
            data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span> <span
            class="visually-hidden">Next</span>
    </button>
</div>
<div class="container p-3">
    <p class="text-center fs-2 ">Что дает санаторно-курортное лечение?</p>

    <div class="row">
        <div class="col-md-8 p-5">
            <div class="row">
                <div class="col-md-6">
                    <div class="card paint-card">
                        <div class="card-body">
                            <p class="fs-5">Укрепление иммунитета</p>
                            <p>Специальные процедуры и методы, направленные на укрепление иммунной системы и защиту организма от различных заболеваний</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card paint-card">
                        <div class="card-body">
                            <p class="fs-5">Снятие стресса и усталости</p>
                            <p>Различные методы релаксации, медитации, массажа и другие способы, направленные на устранение стресса и усталости</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 mt-2">
                    <div class="card paint-card">
                        <div class="card-body">
                            <p class="fs-5">Повышение жизненного тонуса</p>
                            <p>Комплекс мероприятий, направленных на улучшение общего самочувствия, повышение энергии и жизненного тонуса</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 mt-2">
                    <div class="card paint-card">
                        <div class="card-body">
                            <p class="fs-5">Лечение различных заболеваний</p>
                            <p>Проводится с использованием современных методов и технологий, а также природных лечебных ресурсов, таких как минеральные воды, грязи и климатические условия</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <img alt="" src="img/4.png">
        </div>

    </div>

</div>
<hr>
<%@include file="component/footer.jsp" %>
</body>
</html>