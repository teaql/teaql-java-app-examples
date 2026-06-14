package com.teaql.taskboard.ui;

import com.teaql.taskboard.R;
import com.teaql.taskboard.logic.TeaQLManager;
import com.teaql.taskboard.logic.TeaQLLogSinkImpl;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize TeaQL Engine with Native SQLite and CustomLogSink
        TeaQLManager.init(this, TeaQLLogSinkImpl.getInstance());

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        viewPager.setAdapter(new TaskPagerAdapter(this));

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 0) {
                tab.setText(getString(R.string.tab_board));
            } else {
                tab.setText(getString(R.string.tab_logs));
            }
        }).attach();
    }

    private static class TaskPagerAdapter extends FragmentStateAdapter {
        public TaskPagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            if (position == 0) return new BoardFragment();
            return new LogsFragment();
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }
}
