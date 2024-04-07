package com.example.sanatoriy.servlet.doctor;

import com.example.sanatoriy.dao.DoctorDao;
import com.example.sanatoriy.db.DBConnect;
import com.example.sanatoriy.entity.Doctor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/doctorLogin")
public class DoctorLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        DoctorDao dao = new DoctorDao(DBConnect.getConn());
        Doctor doctor = dao.login(email, password);

        if (doctor != null) {
            session.setAttribute("doctObj", doctor);
            resp.sendRedirect("doctor/index.jsp");
        } else {
            session.setAttribute("errorMsg", "Неверный пароль и адрес");
            resp.sendRedirect("doctor_login.jsp");
        }

    }

}