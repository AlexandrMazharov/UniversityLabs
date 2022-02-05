package com.example.m2;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.File;
import java.io.Serializable;

@IgnoreExtraProperties
public class Request implements Serializable {

    public String status;
    public int id_request;
    public String name_work;
    public String fio;
    public String phone;
    public String email;
    public String url_file;
    public File file;
    public String user_id;
    public String lathitude;
    public String longitude;

    public String getLathitude() {
        return lathitude;
    }

    public void setLathitude(String lathitude) {
        this.lathitude = lathitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }



    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId_request() {
        return id_request;
    }

    public void setId_request(int id_request) {
        this.id_request = id_request;
    }





    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getName_work() {
        return name_work;
    }

    public void setName_work(String name_work) {
        this.name_work = name_work;
    }

    public void setName(String name) {
        this.name_work = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUrl_file(String url_file) {
        this.url_file = url_file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getUrl_file() {
        return url_file;
    }

    public File getFile() {
        return file;
    }

    public Request() {

    }
    public Request(String lat,String lon){
        lathitude=lat;
        ;longitude=lon;

    }
}
