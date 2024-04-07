package com.example.sanatoriy.dao;

import com.example.sanatoriy.entity.Course;
import com.example.sanatoriy.entity.Doctor;
import com.example.sanatoriy.entity.Procedure;
import com.example.sanatoriy.entity.Specalist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProcedureDao {
    private Connection conn;

    public ProcedureDao(Connection conn) {
        super();
        this.conn = conn;
    }
    public boolean addProcedure(Procedure p) {
        boolean f = false;
        try {
            String sql = "insert into procedure_sanatoriy(procedure_name, office, time) values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getProcedure_name());
            ps.setString(2, p.getOffice());
            ps.setString(3, p.getTime());
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    public int countProcedure() {
        int i = 0;
        try {
            String sql = "select * from procedure_sanatoriy";
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
    public List<Procedure> getAllProcedure() {
        List<Procedure> list = new ArrayList<Procedure>();
        Procedure d = null;
        try {

            String sql = "select * from procedure_sanatoriy order by id desc";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                d = new Procedure();
                d.setId(rs.getInt(1));
                d.setProcedure_name(rs.getString(2));
                d.setOffice(rs.getString(3));
                d.setTime(rs.getString(4));
                list.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
