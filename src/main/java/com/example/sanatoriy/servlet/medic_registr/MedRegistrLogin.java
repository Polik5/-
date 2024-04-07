package com.example.sanatoriy.servlet.medic_registr;

import com.example.sanatoriy.dao.MedRegistrDao;
import com.example.sanatoriy.db.DBConnect;
import com.example.sanatoriy.entity.MedRegistr;
import com.example.sanatoriy.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/medic_registrLogin")
public class MedRegistrLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        MedRegistrDao dao = new MedRegistrDao(DBConnect.getConn());
        MedRegistr user = dao.login(email, password);
        if (user != null) {
            session.setAttribute("medicObj", user);
            resp.sendRedirect("medic_registr/index.jsp");
        } else {
            session.setAttribute("errorMsg", "Некоректный логин или пароль");
            resp.sendRedirect("medic_registr_login.jsp");
        }
    }
}
