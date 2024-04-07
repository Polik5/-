package com.example.sanatoriy.dao;

import com.example.sanatoriy.entity.Doctor;
import com.example.sanatoriy.entity.MedRegistr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedRegistrDao {
    private Connection conn;
    public MedRegistrDao(Connection conn) {
        super();
        this.conn = conn;
    }
    public boolean registerMedRegistr(MedRegistr m) {
        boolean f = false;
        try {
            String sql = "insert into medic_registr(full_name,dob,mobno,email,password) values(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, m.getFullName());
            ps.setString(2, m.getDob());
            ps.setString(3, m.getEmail());
            ps.setString(4, m.getMobNo());
            ps.setString(5, m.getPassword());
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    public List<MedRegistr> getAllMedRegistr() {
        List<MedRegistr> list = new ArrayList<MedRegistr>();
        MedRegistr m = null;
        try {
            String sql = "select * from medic_registr order by id desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new MedRegistr();
                m.setId(rs.getInt(1));
                m.setFullName(rs.getString(2));
                m.setDob(rs.getString(3));
                m.setMobNo(rs.getString(4));
                m.setEmail(rs.getString(5));
                m.setPassword(rs.getString(6));
                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public MedRegistr getMedRegistrById(int id) {
        MedRegistr m = null;
        try {
            String sql = "select * from medic_registr where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                m = new MedRegistr();
                m.setId(rs.getInt(1));
                m.setFullName(rs.getString(2));
                m.setDob(rs.getString(3));
                m.setMobNo(rs.getString(4));
                m.setEmail(rs.getString(5));
                m.setPassword(rs.getString(6));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    public boolean updateMedRegistr(MedRegistr m) {
        boolean f = false;

        try {
            String sql = "update medic_registr set full_name=?,dob=?,mobno=?,email=?,password=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, m.getFullName());
            ps.setString(2, m.getDob());
            ps.setString(3, m.getMobNo());
            ps.setString(4, m.getEmail());
            ps.setString(5, m.getPassword());
            ps.setInt(6, m.getId());
            int i = ps.executeUpdate();

            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public boolean deleteMedRegistr(int id) {
        boolean f = false;
        try {
            String sql = "delete from medic_registr where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
    public MedRegistr login(String email, String psw) {
        MedRegistr m = null;
        try {
            String sql = "select * from medic_registr where email=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, psw);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new MedRegistr();
                m = new MedRegistr();
                m.setId(rs.getInt(1));
                m.setFullName(rs.getString(2));
                m.setDob(rs.getString(3));
                m.setEmail(rs.getString(4));
                m.setMobNo(rs.getString(5));
                m.setPassword(rs.getString(6));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return m;
    }

    public int countMedRegistr() {
        int i = 0;
        try {
            String sql = "select * from medic_registr";
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


//    public int countAppointmentByMedRegistrd(int did) {
//        int i = 0;
//        try {
//            String sql = "select * from appointment where doctor_id=?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, did);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                i++;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return i;
//    }
    public boolean checkOldPassword(int userid, String oldPassword) {
        boolean f = false;

        try {
            String sql = "select * from doctor where id=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userid);
            ps.setString(2, oldPassword);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public boolean changePassword(int userid, String newPassword) {
        boolean f = false;

        try {
            String sql = "update doctor set password=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setInt(2, userid);

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public boolean editDoctorProfile(Doctor d) {
        boolean f = false;

        try {
            String sql = "update doctor set full_name=?,dob=?,qualification=?,specialization=?,email=?,mobno=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getFullName());
            ps.setString(2, d.getDob());
            ps.setString(3, d.getQualification());
            ps.setString(4, d.getSpecialist());
            ps.setString(5, d.getEmail());
            ps.setString(6, d.getMobNo());
            ps.setInt(7, d.getId());
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
