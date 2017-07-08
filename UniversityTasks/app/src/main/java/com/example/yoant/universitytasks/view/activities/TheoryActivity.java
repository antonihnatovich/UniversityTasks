package com.example.yoant.universitytasks.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.yoant.universitytasks.R;
import com.example.yoant.universitytasks.helper.Constant;
import com.example.yoant.universitytasks.helper.VariablesHolder;

public class TheoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getIntent().getStringExtra(Constant.KEY));
        TextView textView = (TextView) findViewById(R.id.activity_theory_scrollview_text);
        textView.setText(getIntent().getStringExtra(Constant.KEY).equals(Constant.algorithmSecondName) ?
                VariablesHolder.theoryOfTheCaesarAffineCodeAlgorithm :
                VariablesHolder.theoryOfTheDoublePermutationAlgorithm);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
