package com.app.ali.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SpecificStopDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_stop_detail);


        String name  = getIntent().getStringExtra("Name");

        Toast.makeText(getBaseContext(), "select : " + name, Toast.LENGTH_SHORT).show();




    }
}
