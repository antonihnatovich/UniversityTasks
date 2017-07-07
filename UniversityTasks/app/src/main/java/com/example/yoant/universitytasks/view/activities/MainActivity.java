package com.example.yoant.universitytasks.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.yoant.universitytasks.R;
import com.example.yoant.universitytasks.helper.Constant;
import com.example.yoant.universitytasks.helper.VariablesHolder;
import com.example.yoant.universitytasks.logic.VariablesGenerator;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //    private TabLayout mTabLayout;
//    private ViewPager mViewPager;
//    private Toolbar mToolBar;
    private EditText mWordTextInput;
    private EditText mKeyTextInput;
    private CheckBox mRandomWordCheckbox;
    private CheckBox mRandomKeyCheckbox;
    private Button mCryptButton;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        //TODO MOVE THIS TO ANOTHER TAB LAYOUT VIEW
//        mTabLayout = (TabLayout)findViewById(R.id.tabs);
//        mViewPager = (ViewPager) findViewById(R.id.viewPager);
//        FragmentPagerAdapter mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//        mViewPager.setAdapter(mAdapter);
//        mTabLayout.addTab(mTabLayout.newTab().setText(Constant.algorithmFirstName));
//        mTabLayout.addTab(mTabLayout.newTab().setText(Constant.algorithmSecondName));
//        mTabLayout.setupWithViewPager(mViewPager);

        mIntent = new Intent(this, ProgressActivity.class);
        mWordTextInput = (EditText) findViewById(R.id.activity_edittext_word);
        mKeyTextInput = (EditText) findViewById(R.id.activity_edittext_key);
        mRandomWordCheckbox = (CheckBox) findViewById(R.id.activity_checkbox_word);
        mRandomKeyCheckbox = (CheckBox) findViewById(R.id.activity_checkbox_key);
        mCryptButton = (Button) findViewById(R.id.activity_button_crypt);

        mCryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text;
                int key;
                if (!mRandomWordCheckbox.isChecked()) {
                    text = mWordTextInput.getText().toString();
                } else {
                    text = VariablesGenerator.createRandomWord();
                }

                if (!mRandomKeyCheckbox.isChecked()) {
                    key = Integer.parseInt(mKeyTextInput.getText().toString());
                } else {
                    key = VariablesGenerator.createRandomKey();
                }

                //TODO MOVE TO THE NEW VIEW
                VariablesHolder.word = text;
                VariablesHolder.key = key;
                startActivity(mIntent);
                Log.d("-----Activity : ", "word = " + text + " key = " + key);
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
