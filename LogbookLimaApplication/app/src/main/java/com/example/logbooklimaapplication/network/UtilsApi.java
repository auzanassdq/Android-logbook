package com.example.logbooklimaapplication.network;

import com.example.logbooklimaapplication.BuildConfig;

public class UtilsApi {
    public static final String BASE_URL_API = BuildConfig.API_URL;

    // Mendeklarasikan Interface BaseApiService
    public static GetDataService getAPIService(){
        return RetrofitClientInstance.getClient(BASE_URL_API).create(GetDataService.class);
    }
}
