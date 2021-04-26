package com.example.itpg7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapterClient extends RecyclerView.Adapter<MyAdapterClient.MyViewHolder> {

    ArrayList<ClientModel> cList;
    Context context;

     public MyAdapterClient(Context context, ArrayList<ClientModel> cList){
         this.cList = cList;
         this.context = context;

     }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.kyccard, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

         ClientModel clientModel = cList.get(position);
         holder.name.setText(clientModel.getName());

    }

    @Override
    public int getItemCount() {
        return cList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.namekyclist);

        }
    }
}
