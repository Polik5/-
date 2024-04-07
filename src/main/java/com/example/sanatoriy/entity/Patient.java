package com.example.sanatoriy.entity;

public class Patient {
    private int id;
    private String fullName;
    private String gender;
    private String dob;
    private String address;
    private String arrival;
    private String departure;
    private String diseases;
    private int doctorId;
    private String appoinDate;
    private String mobNo;
    private String email;
    public Patient() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Patient(int id, String fullName, String gender, String dob, String address, String arrival, String departure, String diseases, int doctorId, String appoinDate, String mobNo, String email) {
        super();
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.arrival = arrival;
        this.departure = departure;
        this.diseases = diseases;
        this.doctorId = doctorId;
        this.appoinDate = appoinDate;
        this.mobNo = mobNo;
        this.email = email;
    }

    public Patient(String fullName, String gender, String dob, String address, String arrival, String departure, String diseases, int doctorId, String appoinDate, String mobNo, String email) {
        super();
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.arrival = arrival;
        this.departure = departure;
        this.diseases = diseases;
        this.doctorId = doctorId;
        this.appoinDate = appoinDate;
        this.mobNo = mobNo;
        this.email = email;
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
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDiseases() {
        return diseases;
    }
    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }
    public int getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
    public String getAppoinDate() {
        return appoinDate;
    }
    public void setAppoinDate(String appoinDate) {
        this.appoinDate = appoinDate;
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

}
