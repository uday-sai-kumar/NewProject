package com.example.newproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by udaysaikumar on 11/06/18.
 */

public class RecyclerAdapt extends RecyclerView.Adapter<RecyclerAdapt.ViewHolder> {
private List<MongoData> list;

    public RecyclerAdapt(List<MongoData> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.listlayout,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
holder.email.setText(list.get(position).getEmail());
holder.phone.setText(list.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
TextView email,phone;
        public ViewHolder(View itemView) {
            super(itemView);
            email=itemView.findViewById(R.id.name);
            phone=itemView.findViewById(R.id.phoneno);
        }
    }
}
