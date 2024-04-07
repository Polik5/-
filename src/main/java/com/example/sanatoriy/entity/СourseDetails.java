package com.example.sanatoriy.entity;

public class СourseDetails {
    private int id;
    private int cour_id;
    private int proc_id;
    private int col_day;
    public СourseDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCour_id() {
        return cour_id;
    }

    public void setCour_id(int cour_id) {
        this.cour_id = cour_id;
    }

    public int getProc_id() {
        return proc_id;
    }

    public void setProc_id(int proc_id) {
        this.proc_id = proc_id;
    }

    public int getCol_day() {
        return col_day;
    }

    public void setCol_day(int col_day) {
        this.col_day = col_day;
    }

    public СourseDetails(int id, int cour_id, int proc_id, int col_day) {
        super();
        this.id = id;
        this.cour_id = cour_id;
        this.proc_id = proc_id;
        this.col_day = col_day;
    }
    public СourseDetails(int cour_id, int proc_id, int col_day) {
        super();
        this.cour_id = cour_id;
        this.proc_id = proc_id;
        this.col_day = col_day;
    }



}
