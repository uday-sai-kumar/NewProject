package com.example.newproject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by udaysaikumar on 11/06/18.
 */

public class MongoData {
    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @SerializedName("email")
    private String email;
    @SerializedName("phone")
    private String phone;



}
