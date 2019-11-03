package com.example.logbooklimaapplication.network;


import com.example.logbooklimaapplication.model.SprintList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by auzan on 7/12/2019.
 * Github: @auzanassdq
 */
public interface GetDataService {
    @GET("sprints")
    Call<SprintList> getAllSprint();
}
