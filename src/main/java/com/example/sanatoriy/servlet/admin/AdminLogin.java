package com.example.sanatoriy.servlet.admin;

import com.example.sanatoriy.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.IOException;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            HttpSession session = req.getSession();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sanatoriy", "root", "000573000");

            String query = "SELECT * FROM management WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                session.setAttribute("adminObj", new User());
                resp.sendRedirect("admin/index.jsp");
            }else{
                    session.setAttribute("errorMsg", "Неверный адрес электронной почты и пароль");
                    resp.sendRedirect("admin_login.jsp");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}