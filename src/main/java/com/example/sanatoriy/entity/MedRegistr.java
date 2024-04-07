package com.example.sanatoriy.entity;

public class MedRegistr {
    private int id;
    private String fullName;
    private String dob;
    private String mobNo;
    private String email;
    private String password;
    public MedRegistr() {
        super();
        // TODO Auto-generated constructor stub
    }
    public MedRegistr(String fullName, String dob, String mobNo, String email,
                  String password) {
        super();
        this.fullName = fullName;
        this.dob = dob;
        this.mobNo = mobNo;
        this.email = email;
        this.password = password;
    }
    public MedRegistr(int id, String fullName, String dob, String mobNo, String email, String password) {
        super();
        this.id = id;
        this.fullName = fullName;
        this.dob = dob;
        this.mobNo = mobNo;
        this.email = email;
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
