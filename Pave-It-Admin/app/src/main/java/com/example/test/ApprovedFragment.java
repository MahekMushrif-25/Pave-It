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

public class ApprovedFragment extends Fragment {

    private RecyclerView recyclerView;
    private RequestAdapterApproved requestAdapter;
    private List<RequestItem> requestList;

    public ApprovedFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate fragment_approved.xml
        View view = inflater.inflate(R.layout.fragment_approved, container, false);

        // Setup RecyclerView
        recyclerView = view.findViewById(R.id.requests_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sample data for approved requests
        requestList = new ArrayList<>();
        requestList.add(new RequestItem("Mahek", 20, "1234567890", "Navi Mumbai", R.drawable.img3, "Approved"));
        requestList.add(new RequestItem("Manasvi", 25, "9876543210", "New Delhi", R.drawable.img4, "Approved"));

        // Set up the adapter
        requestAdapter = new RequestAdapterApproved(requestList, getContext());
        recyclerView.setAdapter(requestAdapter);

        return view;
    }
}
