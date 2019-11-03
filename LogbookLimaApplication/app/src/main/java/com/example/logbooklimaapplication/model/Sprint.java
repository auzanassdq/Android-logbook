package com.example.logbooklimaapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Sprint {

    @SerializedName("id")
    private int id;

    @SerializedName("nama_sprint")
    private String title;

    @SerializedName("desc_sprint")
    private String desc;

    @SerializedName("tgl_mulai")
    private String dateStart;

    @SerializedName("tgl_selesai")
    private String dateEnd;

    public Sprint() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
}
