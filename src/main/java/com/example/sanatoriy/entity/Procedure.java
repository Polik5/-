package com.example.sanatoriy.entity;

public class Procedure {
    private int id;
    private String procedure_name;
    private String office;
    private String time;
    public Procedure() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProcedure_name() {
        return procedure_name;
    }

    public void setProcedure_name(String procedure_name) {
        this.procedure_name = procedure_name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Procedure(int id, String procedure_name, String office, String time) {
        super();
        this.id = id;
        this.procedure_name = procedure_name;
        this.office = office;
        this.time = time;
    }
    public Procedure(String procedure_name, String office,String time) {
        super();
        this.procedure_name = procedure_name;
        this.office = office;
        this.time = time;
    }


}
