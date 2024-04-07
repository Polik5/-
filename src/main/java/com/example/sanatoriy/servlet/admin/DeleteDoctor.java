package com.example.sanatoriy.servlet.admin;

import com.example.sanatoriy.dao.DoctorDao;
import com.example.sanatoriy.db.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/deleteDoctor")
public class DeleteDoctor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        DoctorDao dao = new DoctorDao(DBConnect.getConn());
        HttpSession session = req.getSession();

        if (dao.deleteDoctor(id)) {
            session.setAttribute("succMsg", "Врач удален");
            resp.sendRedirect("admin/view_doctor.jsp");
        } else {
            session.setAttribute("errorMsg", "Что-то не так на сервере...");
            resp.sendRedirect("admin/view_doctor.jsp");
        }


    }

}