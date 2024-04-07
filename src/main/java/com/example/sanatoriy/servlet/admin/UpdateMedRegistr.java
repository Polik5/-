package com.example.sanatoriy.servlet.admin;

import com.example.sanatoriy.dao.DoctorDao;
import com.example.sanatoriy.dao.MedRegistrDao;
import com.example.sanatoriy.db.DBConnect;
import com.example.sanatoriy.entity.Doctor;
import com.example.sanatoriy.entity.MedRegistr;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/updateMedRegistr")
public class UpdateMedRegistr extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String fullName = req.getParameter("fullname");
            String dob = req.getParameter("dob");
            String mobno = req.getParameter("mobno");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            int id = Integer.parseInt(req.getParameter("id"));

            MedRegistr m = new MedRegistr(id,fullName, dob, mobno, email, password);

            MedRegistrDao dao = new MedRegistrDao(DBConnect.getConn());
            HttpSession session = req.getSession();

            if (dao.updateMedRegistr(m)) {
                session.setAttribute("succMsg", "Успешно редактирован");
                resp.sendRedirect("admin/view_medic_registr.jsp");
            } else {
                session.setAttribute("errorMsg", "Что-то не так на сервере...");
                resp.sendRedirect("admin/view_medic_registr.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
