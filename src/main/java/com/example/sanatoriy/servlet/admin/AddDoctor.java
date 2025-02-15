package com.example.sanatoriy.servlet.admin;

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

@WebServlet("/addDoctor")
public class AddDoctor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String fullName = req.getParameter("fullname");
            String dob = req.getParameter("dob");
            String qualification = req.getParameter("qualification");

            String spec = req.getParameter("spec");

            String email = req.getParameter("email");
            String mobno = req.getParameter("mobno");
            String password = req.getParameter("password");
            //String spec = req.getParameter("spec");
            DoctorDao dao = new DoctorDao(DBConnect.getConn());
            int spec_id = dao.getSpecialistIdByName(spec);
            //int spec_id = Integer.parseInt(req.getParameter("spec_id"));
            Doctor d = new Doctor(fullName, dob, qualification, spec, email, mobno, password, spec_id);
            //DoctorDao dao = new DoctorDao(DBConnect.getConn());
            HttpSession session = req.getSession();
            if (dao.registerDoctor(d)) {
                session.setAttribute("succMsg", "Доктор успешно добавлен");
                resp.sendRedirect("admin/doctor.jsp");
            } else {
                session.setAttribute("errorMsg", "Что-то не так на сервере...");
                resp.sendRedirect("admin/doctor.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}