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

public class CompletedFragment extends Fragment {

    private RecyclerView recyclerView;
    private RequestAdapterRejected requestAdapter;
    private List<RequestItem> requestList;

    public CompletedFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_completed, container, false);
        recyclerView = view.findViewById(R.id.requests_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sample data for pending requests
        requestList = new ArrayList<>();
        requestList.add(new RequestItem("Atharv Bheda", 30, "1234567890", "Kutch", R.drawable.img5, "Completed"));
        requestList.add(new RequestItem("Riya Shah", 25, "9876543210", "Rajasthan", R.drawable.img6, "Completed"));

        requestAdapter = new RequestAdapterRejected(requestList, getContext());
        recyclerView.setAdapter(requestAdapter);

        return view;
    }
}

