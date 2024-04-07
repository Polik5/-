package com.example.sanatoriy.entity;

public class Course {
    private int id;
    private String course_name;
    private int spec_id;
    ///private String col_day;
    public Course() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Course(int id, String course_name, int spec_id) {
        super();
        this.id = id;
        this.course_name = course_name;
        this.spec_id = spec_id;
        ///this.col_day = col_day;
    }
    public Course(String course_name, int spec_id) {
        super();
        this.course_name = course_name;
        this.spec_id = spec_id;
        ///this.col_day = col_day;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getSpec_id() {
        return spec_id;
    }

    public void setSpec_id(int spec_id) {
        this.spec_id = spec_id;
    }
//    public String getCol_day() {
//        return col_day;
//    }
//
//    public void setCol_day(String col_day) {
//        this.col_day = col_day;
//    }

}
