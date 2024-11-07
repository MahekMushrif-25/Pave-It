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

public class RejectedFragment extends Fragment {

    private RecyclerView recyclerView;
    private RequestAdapterRejected requestAdapter;
    private List<RequestItem> requestList;

    public RejectedFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rejected, container, false);
        recyclerView = view.findViewById(R.id.requests_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sample data for rejected requests
        requestList = new ArrayList<>();
        requestList.add(new RequestItem("Kusum P", 18, "1234567890", "Kandivali", R.drawable.img7, "Rejected"));
        requestList.add(new RequestItem("Anshu Mehta", 28, "9876543210", "Gujarat", R.drawable.img8, "Rejected"));

        requestAdapter = new RequestAdapterRejected(requestList, getContext());
        recyclerView.setAdapter(requestAdapter);

        return view;
    }
}
