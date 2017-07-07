package com.example.yoant.universitytasks.view.activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.yoant.universitytasks.R;
import com.example.yoant.universitytasks.adapters.viewpager.ViewPagerAdapter;
import com.example.yoant.universitytasks.helper.Constant;

public class ProgressActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        mTabLayout = (TabLayout) findViewById(R.id.menu_tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.menu_viewpager);
        mToolBar = (Toolbar) findViewById(R.id.menu_toolbar);

        mToolBar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Algorithms at work");

        FragmentPagerAdapter mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.addTab(mTabLayout.newTab().setText(Constant.algorithmFirstName));
        mTabLayout.addTab(mTabLayout.newTab().setText(Constant.algorithmSecondName));
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
