package com.example.sanatoriy.dao;

import com.example.sanatoriy.entity.Doctor;
import com.example.sanatoriy.entity.Specalist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SpecialistDao {

    private Connection conn;

    public SpecialistDao(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean addSpecialist(String spec) {
        boolean f = false;
        try {
            String sql = "insert into specialization(spec_name) values(?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, spec);

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public List<Specalist> getAllSpecialist() {
        List<Specalist> list = new ArrayList<Specalist>();
        Specalist s = null;

        try {
            String sql = "select * from specialization";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                s = new Specalist();
                s.setId(rs.getInt(1));
                s.setSpecialistName(rs.getString(2));
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public Specalist getSpecalistById(int id) {

        Specalist d = null;
        try {
            String sql = "select * from specialization where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                d = new Specalist();
                d.setId(rs.getInt(1));
                d.setSpecialistName(rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }
//    public int getSpecialistIdByName(String specName) {
//        int id = 0;
//        try {
//            String sql = "select id from specialization where spec_name = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, specName);
//
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                id = rs.getInt(1);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return id;
//    }


}