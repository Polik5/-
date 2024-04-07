package com.example.sanatoriy.servlet.admin;

import com.example.sanatoriy.dao.CourseDao;
import com.example.sanatoriy.dao.DoctorDao;
import com.example.sanatoriy.dao.SpecialistDao;
import com.example.sanatoriy.db.DBConnect;
import com.example.sanatoriy.entity.Course;
import com.example.sanatoriy.entity.Doctor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addCourse")
public class AddCourse extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String course_name = req.getParameter("course_name");
        int spec_id = Integer.parseInt(req.getParameter("spec_id"));
        //String col_day = req.getParameter("col_day");
        Course d = new Course(course_name,spec_id);
        CourseDao dao = new CourseDao(DBConnect.getConn());
        HttpSession session = req.getSession();
        if (dao.addCourse(d)) {
            session.setAttribute("succMsg", "Курс добавился");
            resp.sendRedirect("admin/index.jsp");
        } else {
            session.setAttribute("errorMsg", "Что-то не так на сервере...");
            resp.sendRedirect("admin/index.jsp");
        }
    }
}
