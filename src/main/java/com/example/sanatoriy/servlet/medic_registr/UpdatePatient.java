package com.example.sanatoriy.servlet.medic_registr;

import com.example.sanatoriy.dao.DoctorDao;
import com.example.sanatoriy.dao.PatientDao;
import com.example.sanatoriy.db.DBConnect;
import com.example.sanatoriy.entity.Doctor;
import com.example.sanatoriy.entity.Patient;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/updatePatient")
public class UpdatePatient extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
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
            int id = Integer.parseInt(req.getParameter("id"));
            Patient p = new Patient(id, fullName, gender, dob,  address,  arrival,  departure,  diseases,  doctorId,  appointDate,  mobNo,  email);
            PatientDao dao = new PatientDao(DBConnect.getConn());
            HttpSession session = req.getSession();
            if (dao.updatePatient(p)) {
                session.setAttribute("succMsg", "Успешно обнавлены");
                resp.sendRedirect("medic_registr/view_patients.jsp");
            } else {
                session.setAttribute("errorMsg", "Что-то не так на сервере...");
                resp.sendRedirect("medic_registr/view_patients.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}