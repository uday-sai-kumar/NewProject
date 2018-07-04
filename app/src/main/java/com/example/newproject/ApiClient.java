package com.example.newproject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by udaysaikumar on 11/06/18.
 */

public class ApiClient {
    public static final String BASE_URL="https://api.mongolab.com/api/1/databases/usk/";
    public static Retrofit retrofit=null;
    public static Retrofit getApiClient(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
