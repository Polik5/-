package com.example.sanatoriy.servlet.admin;

import com.example.sanatoriy.dao.SpecialistDao;
import com.example.sanatoriy.db.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/addSpecialist")
public class AddSpecialist extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String specName = req.getParameter("specName");
        SpecialistDao dao = new SpecialistDao(DBConnect.getConn());
        boolean f = dao.addSpecialist(specName);
        HttpSession session = req.getSession();
        if (f) {
            session.setAttribute("succMsg", "Специализация добавилась");
            resp.sendRedirect("admin/index.jsp");
        } else {
            session.setAttribute("errorMsg", "Что-то не так на сервере...");
            resp.sendRedirect("admin/index.jsp");
        }
    }
}