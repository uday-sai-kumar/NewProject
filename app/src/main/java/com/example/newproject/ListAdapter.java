package com.example.newproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by udaysaikumar on 10/06/18.
 */

public class ListAdapter extends ArrayAdapter<JSONObject> {
    Context c;
    String k[];
    int res;
    ArrayList<JSONObject> list;

    public ListAdapter( Context context, int rs,ArrayList<JSONObject> objects) {
        super(context,rs,objects);
        this.c=context;
       // this.res=resource;
        this.list=objects;

    }


   /* public ListAdapter(ArrayList<JSONObject> list,Context c){
        super(list,c);
        this.list=list;
this.c=c;
    }*/
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view= LayoutInflater.from(c).inflate(R.layout.listlayout,viewGroup,false);
        }
        TextView email=view.findViewById(R.id.name);
        TextView phone=view.findViewById(R.id.phoneno);
        try {
            email.setText(list.get(i).getString("email"));
            phone.setText(list.get(i).getString("phone"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return view;
    }
}
