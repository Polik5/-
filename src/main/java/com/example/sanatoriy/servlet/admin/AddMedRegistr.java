package com.example.sanatoriy.servlet.admin;


import com.example.sanatoriy.dao.MedRegistrDao;
import com.example.sanatoriy.db.DBConnect;

import com.example.sanatoriy.entity.MedRegistr;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/addMedRegistr")
public class AddMedRegistr extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String fullName = req.getParameter("fullname");
            String dob = req.getParameter("dob");
            String mobno = req.getParameter("mobno");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            MedRegistr m = new MedRegistr(fullName, dob, mobno, email, password);

            MedRegistrDao dao = new MedRegistrDao(DBConnect.getConn());
            HttpSession session = req.getSession();

            if (dao.registerMedRegistr(m)) {
                session.setAttribute("succMsg", "Медицинский регистратор успешно добавлен");
                resp.sendRedirect("admin/medic_registr.jsp");
            } else {
                session.setAttribute("errorMsg", "Что-то не так на сервере...");
                resp.sendRedirect("admin/medic_registr.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
