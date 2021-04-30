package com.example.itpg7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class FirestoreAdapterKYC extends FirestoreRecyclerAdapter<ClientModel, FirestoreAdapterKYC.ClientsViewHolder> {


    private OnListItemClick onListItemClick;

    public FirestoreAdapterKYC(@NonNull FirestoreRecyclerOptions<ClientModel> options, OnListItemClick onListItemClick) {
        super(options);
        this.onListItemClick = onListItemClick;
    }

    @Override
    protected void onBindViewHolder(@NonNull ClientsViewHolder holder, int position, @NonNull ClientModel model) {
        holder.list_name.setText(model.getName());

    }

    @NonNull
    @Override
    public ClientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kyccard, parent, false);
        return new ClientsViewHolder(view);
    }

    public class ClientsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView list_name;

        public ClientsViewHolder(@NonNull View itemView) {
            super(itemView);

            list_name = itemView.findViewById(R.id.namekyclist);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            onListItemClick.onItemClick(getItem(getAdapterPosition()), getAdapterPosition());
        }
    }

    public interface OnListItemClick {
        void onItemClick(ClientModel snapshot, int position);
    }
}
