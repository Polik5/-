package com.example.sanatoriy.servlet.doctor;

import com.example.sanatoriy.dao.AppointmentDao;
import com.example.sanatoriy.dao.PatientDao;
import com.example.sanatoriy.db.DBConnect;
import com.example.sanatoriy.entity.Appointment;
import com.example.sanatoriy.entity.Patient;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addAppointment")
public class AddAppointment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int doctor_id = Integer.parseInt(req.getParameter("doctor_id"));
        int patient_id = Integer.parseInt(req.getParameter("patient_id"));
        int procedur_id = Integer.parseInt(req.getParameter("procedur_id"));
        int been_days = Integer.parseInt(req.getParameter("been_days"));
        int just_days = Integer.parseInt(req.getParameter("just_days"));
        int appoin_data = Integer.parseInt(req.getParameter("appoin_data"));
        Appointment ap = new Appointment(doctor_id, patient_id, procedur_id,  been_days,  just_days,  appoin_data);
        AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
        HttpSession session = req.getSession();
        if (dao.addAppointment(ap)) {
            session.setAttribute("succMsg", "Назначено");
            resp.sendRedirect("doctor/write_appointment.jsp");
            ap.setCommentAdded(false);
        } else {
            session.setAttribute("errorMsg", "Что-то не так на сервере...");
            resp.sendRedirect("doctor/write_appointment.jsp");
        }
    }
}
