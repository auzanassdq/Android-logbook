package com.example.logbooklimaapplication;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sprint implements Serializable{
    @SerializedName("id")
    public int id;
    @SerializedName("nama_sprint")
    public  String nama_sprint;
    @SerializedName("desc_sprint")
    public  String desc_sprint;
    @SerializedName("tgl_mulai")
    public  String tgl_mulai;
    @SerializedName("tgl_selesai")
    public  String tgl_selesai;

    //Contructor sprint
    public Sprint(int id, String nama_sprint, String desc_sprint, String tgl_mulai, String tgl_selesai) {
        this.id = id;
        this.nama_sprint = nama_sprint;
        this.desc_sprint = desc_sprint;
        this.tgl_mulai = tgl_mulai;
        this.tgl_selesai = tgl_selesai;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama_sprint(String nama_sprint) {
        this.nama_sprint = nama_sprint;
    }

    public void setDesc_sprint(String desc_sprint) {
        this.desc_sprint = desc_sprint;
    }

    public void setTgl_mulai(String tgl_mulai) {
        this.tgl_mulai = tgl_mulai;
    }

    public void setTgl_selesai(String tgl_selesai) {
        this.tgl_selesai = tgl_selesai;
    }

    public int getId() {
        return id;
    }

    public String getNama_sprint() {
        return nama_sprint;
    }

    public String getDesc_sprint() {
        return desc_sprint;
    }

    public String getTgl_mulai() {
        return tgl_mulai;
    }

    public String getTgl_selesai() {
        return tgl_selesai;
    }
}


