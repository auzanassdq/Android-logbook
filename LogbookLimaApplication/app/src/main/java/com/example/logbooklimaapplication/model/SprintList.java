package com.example.logbooklimaapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SprintList {
    @SerializedName("results")
    private ArrayList<Sprint> results;

    public ArrayList<Sprint> getResults() {
        return results;
    }

    public void setResults(ArrayList<Sprint> results) {
        this.results = results;
    }
}
