package com.example.sanatoriy.dao;

import com.example.sanatoriy.entity.Course;
import com.example.sanatoriy.entity.СourseDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class СourseDetailsDao {
    private Connection conn;
    public СourseDetailsDao(Connection conn) {
        super();
        this.conn = conn;
    }
    public boolean addСourseDetails(СourseDetails c) {
        boolean f = false;
        try {
            String sql = "insert into course_details(cour_id, proc_id,col_day) values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, c.getCour_id());
            ps.setInt(2, c.getProc_id());
            ps.setInt(3, c.getCol_day());
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

}
