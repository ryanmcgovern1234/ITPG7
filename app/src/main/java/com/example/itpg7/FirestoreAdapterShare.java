package com.example.itpg7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class FirestoreAdapterShare extends FirestoreRecyclerAdapter<ShareModel, FirestoreAdapterShare.ShareViewHolder> {


    public FirestoreAdapterShare(@NonNull FirestoreRecyclerOptions<ShareModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull FirestoreAdapterShare.ShareViewHolder holder, int position, @NonNull ShareModel model) {
        holder.list_name.setText(model.getName());
        holder.list_price.setText("Price: " + model.getPrice());
        holder.list_volume.setText("Volume: " + model.getVolume());


    }

    @NonNull
    @Override
    public FirestoreAdapterShare.ShareViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sharecardview, parent, false);
        return new FirestoreAdapterShare.ShareViewHolder(view);
    }

    public class ShareViewHolder extends RecyclerView.ViewHolder {

        private TextView list_name;
        private TextView list_price;
        private TextView list_volume;


        public ShareViewHolder(@NonNull View itemView) {
            super(itemView);

            list_name = itemView.findViewById(R.id.nameshare);
            list_price = itemView.findViewById(R.id.priceshare);
            list_volume = itemView.findViewById(R.id.volumeshare);


        }

    }
}
