package com.example.newproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.newproject.MongoDB.SaveAsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
EditText   name,phone,addr,issue;
Button submit;
ArrayList<HashMap<String,String>> list;
private  ApiInterfacePut clients;
String val;
ConnectivityManager  manager;
    NetworkInfo networkInfo;
    Map<String,String> map;
    JSONObject j;
   ProgressBar progressBar;
private ApiInterfacePut apiInterfacePut;
//String s="https://api.mongolab.com/api/1/databases/usk/collections/usknames?apiKey=KmTJIck8DgWEJikNyhwTNF7cy760f9iW";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.nameET);
        phone=findViewById(R.id.phoneET);
        addr=findViewById(R.id.addressET);
        issue=findViewById(R.id.issueET);
        submit=findViewById(R.id.submit);
        progressBar=findViewById(R.id.progressBar);
        System.out.println("value");
        list=new ArrayList<>();
        System.out.println("baseurl");
         manager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert manager != null;
        networkInfo=manager.getActiveNetworkInfo();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().isEmpty() || phone.getText().toString().isEmpty() ||  issue.getText().toString().isEmpty()|| addr.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this,"please provide",Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        if (networkInfo.isConnected()) {
progressBar.setVisibility(View.VISIBLE);
getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                            j = new JSONObject();
                            j.put("name", name.getText().toString());
                            j.put("phone", phone.getText().toString());
                            j.put("issue", issue.getText().toString());
                            j.put("address", addr.getText().toString());


                            clients = ApiService.getService().create(ApiInterfacePut.class);
                            Call<ResponseBody> body = clients.savePost(j.toString());
                            body.enqueue(new Callback<ResponseBody>() {
                                @Override
                                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onFailure(Call<ResponseBody> call, Throwable t) {
                                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                    progressBar.setVisibility(View.INVISIBLE);

                                }
                            });
                        }
                    } catch(Exception e){

                    }

                    }


            }
        });
    }
}
