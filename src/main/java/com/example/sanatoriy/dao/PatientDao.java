package com.example.sanatoriy.dao;

import com.example.sanatoriy.entity.Doctor;
import com.example.sanatoriy.entity.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class PatientDao {
    private Connection conn;
    public PatientDao(Connection conn) {
        super();
        this.conn = conn;
    }
    public boolean addPatient(Patient p) {
        boolean f = false;
        try {
            String sql = "insert into patient(full_name, gender, dob,  address,  arrival,  departure,  diseases,  doctor_id,  appoint_date,  mobno,  email) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getFullName());
            ps.setString(2, p.getGender());
            ps.setString(3, p.getDob());
            ps.setString(4, p.getAddress());
            ps.setString(5, p.getArrival());
            ps.setString(6, p.getDeparture());
            ps.setString(7, p.getDiseases());
            ps.setInt(8, p.getDoctorId());
            ps.setString(9, p.getAppoinDate());
            ps.setString(10, p.getMobNo());
            ps.setString(11, p.getEmail());

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }


    public List<Patient> getAllPatient() {
        List<Patient> list = new ArrayList<Patient>();
        Patient p = null;
        try {
            String sql = "select * from patient order by id desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p = new Patient();
                p.setId(rs.getInt(1));
                p.setFullName(rs.getString(2));
                p.setGender(rs.getString(3));
                p.setDob(rs.getString(4));
                p.setAddress(rs.getString(5));
                p.setArrival(rs.getString(6));
                p.setDeparture(rs.getString(7));
                p.setDiseases(rs.getString(8));
                p.setDoctorId(rs.getInt(9));
                p.setAppoinDate(rs.getString(10));
                p.setMobNo(rs.getString(11));
                p.setEmail(rs.getString(12));
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Patient> getPatientsByName(String fullName) {
        List<Patient> patients = new ArrayList<>();
        try {
            String query = "SELECT * FROM patient WHERE full_name LIKE ?";
            PreparedStatement pst = this.conn.prepareStatement(query);
            pst.setString(1, "%" + fullName + "%");
            ResultSet req = pst.executeQuery();
            while (req.next()) {
                System.out.println(req.getInt(1));
                int id = req.getInt("id");
                String fullN__ame = req.getString("full_name");
                String gender = req.getString("gender");
                String dob = req.getString("dob");
                String address = req.getString("address");
                String arrival = req.getString("arrival");
                String departure = req.getString("departure");
                String diseases = req.getString("diseases");
                int doctorId = Integer.parseInt(req.getString("doctor_id"));
                String appointDate = req.getString("appoint_date");
                String mobNo = req.getString("mobno");
                String email = req.getString("email");
                Patient patient = new Patient(id, fullN__ame, gender, dob,  address,  arrival,  departure,  diseases,  doctorId,  appointDate,  mobNo,  email);
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    public Patient getPatientById(int id) {
        Patient p = null;
        try {
            String sql = "select * from patient where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p = new Patient();
                p.setId(rs.getInt(1));
                p.setFullName(rs.getString(2));
                p.setGender(rs.getString(3));
                p.setDob(rs.getString(4));
                p.setAddress(rs.getString(5));
                p.setArrival(rs.getString(6));
                p.setDeparture(rs.getString(7));
                p.setDiseases(rs.getString(8));
                p.setDoctorId(rs.getInt(9));
                p.setAppoinDate(rs.getString(10));
                p.setMobNo(rs.getString(11));
                p.setEmail(rs.getString(12));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public boolean updatePatient(Patient p) {
        boolean f = false;

        try {
            String sql = "update patient set full_name=?,gender=?,dob=?,address=?,arrival=?,departure=?,diseases=?,doctor_id=?,appoint_date=?,mobno=?,email=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getFullName());
            ps.setString(2, p.getGender());
            ps.setString(3, p.getDob());
            ps.setString(4, p.getAddress());
            ps.setString(5, p.getArrival());
            ps.setString(6, p.getDeparture());
            ps.setString(7, p.getDiseases());
            ps.setInt(8, p.getDoctorId());
            ps.setString(9, p.getAppoinDate());
            ps.setString(10, p.getMobNo());
            ps.setString(11, p.getEmail());
            ps.setInt(12, p.getId());
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }


    public int countPatient() {
        int i = 0;
        try {
            String sql = "select * from patient";
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
    public List<Patient> getAllPatientByDoctorLogin(int doctorId) {
        List<Patient> list = new ArrayList<Patient>();
        Patient p = null;
        try {
            String sql = "select * from patient where doctor_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p = new Patient();
                p.setId(rs.getInt(1));
                p.setFullName(rs.getString(2));
                p.setGender(rs.getString(3));
                p.setDob(rs.getString(4));
                p.setAddress(rs.getString(5));
                p.setArrival(rs.getString(6));
                p.setDeparture(rs.getString(7));
                p.setDiseases(rs.getString(8));
                p.setDoctorId(rs.getInt(9));
                p.setAppoinDate(rs.getString(10));
                p.setMobNo(rs.getString(11));
                p.setEmail(rs.getString(12));
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }





}
