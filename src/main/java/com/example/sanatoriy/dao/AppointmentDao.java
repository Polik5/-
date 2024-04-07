package com.example.sanatoriy.dao;

import com.example.sanatoriy.entity.Appointment;
import com.example.sanatoriy.entity.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDao {
    private Connection conn;

    public AppointmentDao(Connection conn) {
        super();
        this.conn = conn;
    }
    public boolean addAppointment(Appointment ap) {
        boolean f = false;
        try {
            String sql = "insert into appointment(doctor_id,patient_id,procedur_id,been_days,just_days,appoin_data) values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ap.getDoctor_id());
            ps.setInt(2, ap.getPatient_id());
            ps.setInt(3, ap.getProcedur_id());
            ps.setInt(4, ap.getBeen_days());
            ps.setInt(5, ap.getJust_days());
            ps.setInt(6, ap.getAppoin_data());
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
    public Appointment getAppointmentById(int id) {
        Appointment ap = null;
        try {

            String sql = "select * from appointment where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ap = new Appointment();
                ap.setId(rs.getInt(1));
                ap.setDoctor_id(rs.getInt(2));
                ap.setPatient_id(rs.getInt(3));
                ap.setProcedur_id(rs.getInt(4));
                ap.setBeen_days(rs.getInt(5));
                ap.setJust_days(rs.getInt(6));
                ap.setAppoin_data(rs.getInt(7));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ap;
    }
    public List<Appointment> getAllAppointmentByPatientLogin(int patient_id) {
        List<Appointment> list = new ArrayList<Appointment>();
        Appointment ap = null;

        try {

            String sql = "select * from appointment where patient_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, patient_id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ap = new Appointment();
                ap.setId(rs.getInt(1));
                ap.setDoctor_id(rs.getInt(2));
                ap.setPatient_id(rs.getInt(3));
                ap.setProcedur_id(rs.getInt(4));
                ap.setBeen_days(rs.getInt(5));
                ap.setJust_days(rs.getInt(6));
                ap.setAppoin_data(rs.getInt(7));
                list.add(ap);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }



}
