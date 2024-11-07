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

public class RequestAdapterApproved extends RecyclerView.Adapter<RequestAdapterApproved.RequestViewHolder> {

    private List<RequestItem> requestList;
    private Context context;

    public RequestAdapterApproved(List<RequestItem> requestList, Context context) {
        this.requestList = requestList;
        this.context = context;
    }

    @NonNull
    @Override
    public RequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout defined in request_item_approved.xml
        View view = LayoutInflater.from(context).inflate(R.layout.request_item_approved, parent, false);
        return new RequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestViewHolder holder, int position) {
        RequestItem requestItem = requestList.get(position);

        // Bind the data to the views
        holder.name.setText("Name: " + requestItem.getName());
        holder.age.setText("Age: " + requestItem.getAge());
        holder.number.setText("Number: " + requestItem.getNumber());
        holder.location.setText("Location: " + requestItem.getLocation());
        holder.image.setImageResource(requestItem.getImageResId());
        holder.status.setText("Status: " + requestItem.getStatus());

        // Optional: Handle completed button actions if needed
        holder.approveButton.setOnClickListener(v -> {
            requestItem.setStatus("Completed");
            notifyDataSetChanged(); // Refresh the adapter to show updated status
        });
    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    // ViewHolder class for RecyclerView
    public static class RequestViewHolder extends RecyclerView.ViewHolder {
        TextView name, age, number, location, status;
        ImageView image;
        Button approveButton;

        public RequestViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.request_name);
            age = itemView.findViewById(R.id.request_age);
            number = itemView.findViewById(R.id.request_number);
            location = itemView.findViewById(R.id.request_location);
            image = itemView.findViewById(R.id.request_image);
            status = itemView.findViewById(R.id.request_status);
            approveButton = itemView.findViewById(R.id.approve_button);
        }
    }
}
