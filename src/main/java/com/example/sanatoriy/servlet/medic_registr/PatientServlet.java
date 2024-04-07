package com.example.sanatoriy.servlet.medic_registr;


import com.example.sanatoriy.dao.PatientDao;
import com.example.sanatoriy.db.DBConnect;

import com.example.sanatoriy.entity.Patient;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/addPatient")
public class PatientServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("full_name");
        String gender = req.getParameter("gender");
        String dob = req.getParameter("dob");
        String address = req.getParameter("address");
        String arrival = req.getParameter("arrival");
        String departure = req.getParameter("departure");
        String diseases = req.getParameter("diseases");
        int doctorId = Integer.parseInt(req.getParameter("doctor_id"));
        String appointDate = req.getParameter("appoint_date");
        String mobNo = req.getParameter("mobno");
        String email = req.getParameter("email");
        Patient ap = new Patient(fullName, gender, dob,  address,  arrival,  departure,  diseases,  doctorId,  appointDate,  mobNo,  email);
        PatientDao dao = new PatientDao(DBConnect.getConn());
        HttpSession session = req.getSession();
        if (dao.addPatient(ap)) {
            session.setAttribute("succMsg", "Успешно");
            resp.sendRedirect("medic_registr/view_patient.jsp");
        } else {
            session.setAttribute("errorMsg", "Что-то не так на сервере...");
            resp.sendRedirect("medic_registr/view_patient.jsp");
        }
    }
}
