package com.example.newproject;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by udaysaikumar on 11/06/18.
 */

public interface ApiInterfacePut {
    @POST("collections/newuskproj?apiKey=KmTJIck8DgWEJikNyhwTNF7cy760f9iW")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> savePost(@Body String body);
}
