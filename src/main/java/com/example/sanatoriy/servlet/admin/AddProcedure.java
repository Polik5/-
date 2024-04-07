package com.example.sanatoriy.servlet.admin;

import com.example.sanatoriy.dao.CourseDao;
import com.example.sanatoriy.dao.DoctorDao;
import com.example.sanatoriy.dao.ProcedureDao;
import com.example.sanatoriy.dao.SpecialistDao;
import com.example.sanatoriy.db.DBConnect;
import com.example.sanatoriy.entity.Course;
import com.example.sanatoriy.entity.Doctor;
import com.example.sanatoriy.entity.Procedure;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addProcedure")
public class AddProcedure extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String procedure_name = req.getParameter("procedure_name");
        String office = req.getParameter("office");
        String time = req.getParameter("time");
        Procedure p = new Procedure(procedure_name,office,time);
        ProcedureDao dao = new ProcedureDao(DBConnect.getConn());
        HttpSession session = req.getSession();
        if (dao.addProcedure(p)) {
            session.setAttribute("succMsg", "Процедура добавлена");
            resp.sendRedirect("admin/index.jsp");
        } else {
            session.setAttribute("errorMsg", "Что-то не так на сервере...");
            resp.sendRedirect("admin/index.jsp");
        }
    }
}
