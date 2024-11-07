package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RequestAdapterPending extends RecyclerView.Adapter<RequestAdapterPending.RequestViewHolder> {

    private List<RequestItem> requestList;
    private Context context;

    public RequestAdapterPending(List<RequestItem> requestList, Context context) {
        this.requestList = requestList;
        this.context = context;
    }

    @NonNull
    @Override
    public RequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.request_item_pending, parent, false);
        return new RequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestViewHolder holder, int position) {
        RequestItem requestItem = requestList.get(position);

        holder.name.setText("Name: " + requestItem.getName());
        holder.age.setText("Age: " + requestItem.getAge());
        holder.number.setText("Number: " + requestItem.getNumber());
        holder.location.setText("Location: " + requestItem.getLocation());
        holder.image.setImageResource(requestItem.getImageResId());
        holder.status.setText("Status: " + requestItem.getStatus());

        holder.approveButton.setOnClickListener(v -> {
            requestItem.setStatus("Approved");
            notifyDataSetChanged();  // Refresh the view
        });

        holder.rejectButton.setOnClickListener(v -> {
            requestItem.setStatus("Rejected");
            notifyDataSetChanged();  // Refresh the view
        });
    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    public void updateList(List<RequestItem> filteredList) {
        requestList = filteredList;
        notifyDataSetChanged();
    }

    public static class RequestViewHolder extends RecyclerView.ViewHolder {
        TextView name, age, number, location, status;
        ImageView image;
        Button approveButton, rejectButton;

        public RequestViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.request_name);
            age = itemView.findViewById(R.id.request_age);
            number = itemView.findViewById(R.id.request_number);
            location = itemView.findViewById(R.id.request_location);
            status = itemView.findViewById(R.id.request_status);
            image = itemView.findViewById(R.id.request_image);
            approveButton = itemView.findViewById(R.id.approve_button);
            rejectButton = itemView.findViewById(R.id.reject_button);
        }
    }
}
