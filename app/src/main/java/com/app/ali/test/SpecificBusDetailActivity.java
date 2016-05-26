package com.app.ali.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.utils.AsyncResponse;
import com.utils.RequestExecutor;

public class SpecificBusDetailActivity extends AppCompatActivity implements AsyncResponse {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_bus_detail);


        String Id  = getIntent().getStringExtra("Id");

        Toast.makeText(getBaseContext(), "select : " + Id, Toast.LENGTH_SHORT).show();

        RequestExecutor re = new RequestExecutor(this);
        re.delegate = this;
        re.execute("1",Id);


    }

    @Override
    public void onProcessCompelete(Object result) {
        Toast.makeText(getBaseContext(), "Result Recived : "+ (String)result , Toast.LENGTH_LONG).show();
    }
}
