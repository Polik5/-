package com.example.sanatoriy.servlet.medic_registr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/patients-servlet")
public class PatientSearchServlet extends HttpServlet {
    private Connection conn;
    public PatientSearchServlet(Connection conn) {
        super();
        this.conn = conn;
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("full_name");
        try  {
            String sql = "SELECT * FROM patient WHERE full_name LIKE ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,  fullName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                request.setAttribute("full_name", fullName);
                request.setAttribute("patientFound", true);
                request.getRequestDispatcher("view_patients.jsp").forward(request, response);
            } else {
                request.setAttribute("full_name", fullName);
                request.setAttribute("patientFound", false);
                request.getRequestDispatcher("view_patients.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
