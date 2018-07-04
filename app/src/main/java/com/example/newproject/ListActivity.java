package com.example.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.newproject.MongoDB.SaveAsyncTask;

public class ListActivity extends AppCompatActivity {
static public ListView l;
String[] a=new String[]{"uday","sai","kumar"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        l=findViewById(R.id.list);
        SaveAsyncTask s=new SaveAsyncTask(ListActivity.this);
       // System.out.println("value1");
        s.execute();
        //l.setAdapter(new ListAdapter(a,getApplicationContext()));
    }

}
