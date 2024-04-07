package com.example.sanatoriy.dao;

import com.example.sanatoriy.entity.Course;
import com.example.sanatoriy.entity.Doctor;
import com.example.sanatoriy.entity.Patient;
import com.example.sanatoriy.entity.Specalist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    private Connection conn;

    public CourseDao(Connection conn) {
        super();
        this.conn = conn;
    }
    public boolean addCourse(Course c) {
        boolean f = false;
        try {
            String sql = "insert into course(course_name, spec_id) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getCourse_name());
            ps.setInt(2, c.getSpec_id());
            //ps.setString(3, c.getCol_day());
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    public List<Course> getAllCourse() {
        List<Course> list = new ArrayList<Course>();
        Course s = null;
        try {
            String sql = "select * from course";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                s = new Course();
                s.setId(rs.getInt(1));
                s.setCourse_name(rs.getString(2));
                s.setSpec_id(rs.getInt(3));
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public int countCourse() {
        int i = 0;
        try {
            String sql = "select * from course";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }
    public Course getCourseById(int id) {

        Course d = null;
        try {
            String sql = "select * from course where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                d = new Course();
                d.setId(rs.getInt(1));
                d.setCourse_name(rs.getString(2));
                d.setSpec_id(rs.getInt(3));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }
    public List<Course> getCoursesByDoctorSpecialtyId(int doctorSpecialtyId) {
        List<Course> courses = new ArrayList<>();
        try {
            String sql = "select * from course WHERE spec_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, doctorSpecialtyId);
            //System.out.println(doctorSpecialtyId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt(1));
                course.setCourse_name(rs.getString(2));
                course.setSpec_id(rs.getInt(3));
                courses.add(course);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }
    public int getCoursesByDoctorSpecialtyId2(int doctorSpecialtyId) {
        int id = 0;
        try {
            String sql = "select id from course where course_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, doctorSpecialtyId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

}
