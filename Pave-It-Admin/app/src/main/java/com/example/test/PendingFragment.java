package com.example.test;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PendingFragment extends Fragment {

    private RecyclerView recyclerView;
    private RequestAdapterPending requestAdapter;
    private List<RequestItem> requestList;

    public PendingFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pending, container, false);
        recyclerView = view.findViewById(R.id.requests_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sample data for pending requests
        requestList = new ArrayList<>();
        requestList.add(new RequestItem("John Doe", 30, "1234567890", "Mumbai", R.drawable.img1, "Pending"));
        requestList.add(new RequestItem("Jane Smith", 25, "9876543210", "Delhi", R.drawable.img2, "Pending"));

        requestAdapter = new RequestAdapterPending(requestList, getContext());
        recyclerView.setAdapter(requestAdapter);

        return view;
    }
}
