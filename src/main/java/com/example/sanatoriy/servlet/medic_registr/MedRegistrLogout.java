package com.example.sanatoriy.servlet.medic_registr;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/medic_registrLogout")
public class MedRegistrLogout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("medicObj");
        session.setAttribute("succMsg", "Мед. регистратор успешно вышел");
        resp.sendRedirect("medic_registr_login.jsp");
    }

}
