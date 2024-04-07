package com.example.sanatoriy.servlet.admin;

import com.example.sanatoriy.dao.MedRegistrDao;
import com.example.sanatoriy.db.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteMedRegistr")
public class DeleteMedRegistr extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        MedRegistrDao dao = new MedRegistrDao(DBConnect.getConn());
        HttpSession session = req.getSession();

        if (dao.deleteMedRegistr(id)) {
            session.setAttribute("succMsg", "Медицинский регистратор удален");
            resp.sendRedirect("admin/view_medic_registr.jsp");
        } else {
            session.setAttribute("errorMsg", "Что-то не так на сервере...");
            resp.sendRedirect("admin/view_medic_registr.jsp");
        }
    }
}
