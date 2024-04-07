package com.example.sanatoriy.entity;

public class Appointment {
    private int id;
    private int doctor_id;
    private int patient_id;
    private int procedur_id;
    private int been_days;
    private int just_days;
    private int appoin_data;
    private boolean commentAdded;
    public Appointment() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Appointment(int id, int doctor_id, int patient_id, int procedur_id, int been_days, int just_days, int appoin_data) {
        super();
        this.id = id;
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;
        this.procedur_id = procedur_id;
        this.been_days = been_days;
        this.just_days = just_days;
        this.appoin_data = appoin_data;
    }
    public Appointment(int doctor_id, int patient_id, int procedur_id, int been_days, int just_days, int appoin_data) {
        super();
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;
        this.procedur_id = procedur_id;
        this.been_days = been_days;
        this.just_days = just_days;
        this.appoin_data = appoin_data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }



    public int getBeen_days() {
        return been_days;
    }

    public void setBeen_days(int been_days) {
        this.been_days = been_days;
    }

    public int getJust_days() {
        return just_days;
    }

    public void setJust_days(int just_days) {
        this.just_days = just_days;
    }

    public int getAppoin_data() {
        return appoin_data;
    }

    public void setAppoin_data(int appoin_data) {
        this.appoin_data = appoin_data;
    }
    public boolean isCommentAdded() {
        return commentAdded;
    }

    public void setCommentAdded(boolean commentAdded) {
        this.commentAdded = commentAdded;
    }

    public int getProcedur_id() {
        return procedur_id;
    }

    public void setProcedur_id(int procedur_id) {
        this.procedur_id = procedur_id;
    }
}
