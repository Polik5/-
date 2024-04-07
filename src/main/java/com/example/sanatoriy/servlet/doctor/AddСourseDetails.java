package com.example.sanatoriy.servlet.doctor;

import com.example.sanatoriy.dao.CourseDao;
import com.example.sanatoriy.dao.DoctorDao;
import com.example.sanatoriy.dao.SpecialistDao;
import com.example.sanatoriy.dao.СourseDetailsDao;
import com.example.sanatoriy.db.DBConnect;
import com.example.sanatoriy.entity.Course;
import com.example.sanatoriy.entity.Doctor;
import com.example.sanatoriy.entity.СourseDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addСourseDetails")
public class AddСourseDetails extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cour_id = Integer.parseInt(req.getParameter("cour_id"));
        int proc_id = Integer.parseInt(req.getParameter("proc_id"));
        int col_day = Integer.parseInt(req.getParameter("col_day"));
        СourseDetails d = new СourseDetails(cour_id,proc_id,col_day);
        СourseDetailsDao dao = new СourseDetailsDao(DBConnect.getConn());
        HttpSession session = req.getSession();
        if (dao.addСourseDetails(d)) {
            session.setAttribute("succMsg", "Курсу добавлена процедура");
            resp.sendRedirect("doctor/course_details.jsp");
        } else {
            session.setAttribute("errorMsg", "Что-то не так на сервере...");
            resp.sendRedirect("doctor/course_details.jsp");
        }
    }
}
