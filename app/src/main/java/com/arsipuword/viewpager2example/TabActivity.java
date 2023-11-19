package com.arsipuword.viewpager2example;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;


import com.arsipuword.viewpager2example.ui.main.SectionsPagerAdapter;
import com.arsipuword.viewpager2example.databinding.ActivityTabBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class TabActivity extends AppCompatActivity {

    private ActivityTabBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //inflate view untuk binding
        binding = ActivityTabBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Section Pager for viewpager
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, this);
        ViewPager2 viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        //TabMediator untuk viewpager2
        new TabLayoutMediator(tabs, viewPager, (tab, position) -> {
            tab.setText(getString(SectionsPagerAdapter.TAB_TITLES[position]));
        }).attach();

        FloatingActionButton fab = binding.fab;

    }
}