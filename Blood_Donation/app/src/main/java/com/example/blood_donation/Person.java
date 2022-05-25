package com.example.blood_donation;

public class Person {
    String d_Name;
    String d_bgroup;
    String d_dphon;
    String d_dloc;

    public Person(String d_Name, String d_bgroup, String d_dphon, String d_dloc) {
        this.d_Name = d_Name;
        this.d_bgroup = d_bgroup;
        this.d_dphon = d_dphon;
        this.d_dloc = d_dloc;
    }

    public String getD_Name() {
        return d_Name;
    }

    public void setD_Name(String d_Name) {
        this.d_Name = d_Name;
    }

    public String getD_bgroup() {
        return d_bgroup;
    }

    public void setD_bgroup(String d_bgroup) {
        this.d_bgroup = d_bgroup;
    }

    public String getD_dphon() {
        return d_dphon;
    }

    public void setD_dphon(String d_dphon) {
        this.d_dphon = d_dphon;
    }

    public String getD_dloc() {
        return d_dloc;
    }

    public void setD_dloc(String d_dloc) {
        this.d_dloc = d_dloc;
    }
}
