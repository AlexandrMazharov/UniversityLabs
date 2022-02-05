package com.example.m2;

import java.io.File;

public class RecyclerItem {
    public String name_work;
    public String fio;
    public String phone;
    public String email;
    public String url_file;
    public String status;
    public String user_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName_work() {
        return name_work;
    }

    public void setName_work(String name_work) {
        this.name_work = name_work;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl_file() {
        return url_file;
    }

    public void setUrl_file(String url_file) {
        this.url_file = url_file;
    }

    public RecyclerItem(String nw, String f, String p, String em, String url,String st,String id) {
        this.name_work = nw;
        this.fio = f;
        this.email = em;
        this.phone = p;
        this.url_file = url;
        this.status = st;
        this.user_id = id;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
