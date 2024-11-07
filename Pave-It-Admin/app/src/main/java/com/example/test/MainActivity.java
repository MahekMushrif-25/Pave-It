package com.example.test;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tab_layout);

        // Set up the ViewPager with a FragmentStateAdapter
        viewPager.setAdapter(new FragmentAdapter(this));

        // Link TabLayout with ViewPager
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Pending");
                            break;
                        case 1:
                            tab.setText("Approved");
                            break;
                        case 2:
                            tab.setText("Rejected");
                            break;
                        case 3:
                            tab.setText("Completed");
                            break;
                    }
                }).attach();
    }

    private static class FragmentAdapter extends FragmentStateAdapter {
        public FragmentAdapter(MainActivity fa) {
            super(fa);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new PendingFragment();
                case 1:
                    return new ApprovedFragment();
                case 2:
                    return new RejectedFragment();
                case 3:
                    return new CompletedFragment();
                default:
                    return new PendingFragment();
            }
        }

        @Override
        public int getItemCount() {
            return 4; // Number of tabs
        }
    }
}
