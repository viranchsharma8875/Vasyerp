package com.example.vasyerp_task;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Datum{
    public int id;
    public String email;
    public String first_name;
    public String last_name;
    public String avatar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}

class Support{
    public String url;
    public String text;
}

 class Root{
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
     public List<Datum> data;
    public Support support;
}


