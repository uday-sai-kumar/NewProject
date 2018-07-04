package com.example.newproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by udaysaikumar on 11/06/18.
 */

public interface ApiInterface {
    @GET("collections/usknames")
    Call<List<MongoData>> getData(@Query("apiKey") String key);
}
