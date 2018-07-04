package com.example.newproject.MongoDB;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.newproject.ListActivity;
import com.example.newproject.ListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by udaysaikumar on 09/06/18.
 */

public class SaveAsyncTask extends AsyncTask<String,String,String>{
    String s="https://api.mongolab.com/api/1/databases/usk/collections/usknames?apiKey=KmTJIck8DgWEJikNyhwTNF7cy760f9iW";
   private ProgressDialog d;
   ArrayList<HashMap<String,String>> list;
private Context c;
private String val,json;
    public SaveAsyncTask(Context cc) {
        this.d = d;
        this.c=cc;
    }

    @Override
    protected void onPreExecute() {
d=new ProgressDialog(c);
d.setCancelable(false);
d.setProgressStyle(ProgressDialog.STYLE_SPINNER);
d.setIndeterminate(true);
d.setMessage("please wait");
d.show();
    }
    @Override
    protected String doInBackground(String... strings) {
        System.out.println("value2");

        try {
            URL u=new URL(s);
            HttpURLConnection con=(HttpURLConnection) u.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            //res= String.valueOf(con.getResponseCode());
            BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
             val=br.readLine();
            System.out.println("value is"+val);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



    @Override
    protected void onPostExecute(String s) {
        ArrayList<JSONObject> list=new ArrayList<>();
        if(d.isShowing()){
            d.dismiss();
        }
        super.onPostExecute(s);
       // json="{\"hello\":"+val+"}";
        try {
         //   JSONObject j=new JSONObject(json);
            JSONArray a=new JSONArray(val);
          //  JSONArray a=j.getJSONArray("hello");
            for(int i=0;i<a.length();i++){
                JSONObject jsonObject=a.getJSONObject(i);
               // String email=jsonObject.getString("email");
                //String phone=jsonObject.getString("phone");
                list.add(jsonObject);
               // System.out.println("123usk"+list.get(i));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ListAdapter adapter=new ListAdapter(c,0,list);
ListActivity.l.setAdapter(adapter);

    }


}
