package com.example.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecycleActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapt adapter;
    String apikey="KmTJIck8DgWEJikNyhwTNF7cy760f9iW";
    //RecyclerView.LayoutManager manager;
    List<MongoData> mongoData;
    private  ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        recyclerView=findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        System.out.println("hello");
        Call<List<MongoData>> call=apiInterface.getData(apikey);
        System.out.println("mongo");

        call.enqueue(new Callback<List<MongoData>>() {
            @Override
            public void onResponse(Call<List<MongoData>> call, Response<List<MongoData>> response) {
                mongoData=response.body();
                System.out.println("mongo "+mongoData);

                adapter=new RecyclerAdapt(mongoData);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<MongoData>> call, Throwable t) {
System.out.println("hello failure");
            }
        });
    }
}
