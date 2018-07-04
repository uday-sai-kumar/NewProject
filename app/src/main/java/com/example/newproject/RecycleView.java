package com.example.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecycleView extends AppCompatActivity {
RecyclerView recyclerView;
RecyclerAdapt adapter;
String apikey="KmTJIck8DgWEJikNyhwTNF7cy760f9iW";
//RecyclerView.LayoutManager manager;
List<MongoData> mongoData;
private  ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView=findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<MongoData>> call=apiInterface.getData(apikey);
        call.enqueue(new Callback<List<MongoData>>() {
            @Override
            public void onResponse(Call<List<MongoData>> call, Response<List<MongoData>> response) {
                mongoData=response.body();
                adapter=new RecyclerAdapt(mongoData);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<MongoData>> call, Throwable t) {

            }
        });

    }
}
