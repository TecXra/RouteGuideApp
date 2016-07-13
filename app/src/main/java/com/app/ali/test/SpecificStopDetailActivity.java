package com.app.ali.test;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.adapters.BusAdapter;
import com.adapters.BusNewAdapter;
import com.models.TBus;
import com.models.TStop;
import com.utils.AsyncResponse;
import com.utils.RequestExecutor;

import java.util.ArrayList;

public class SpecificStopDetailActivity extends AppCompatActivity implements AsyncResponse {
    private ProgressDialog progress;

    ListView listView;
    ArrayList<TBus> stopbusList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_stop_detail);
        String Id  = getIntent().getStringExtra("Id");


        progress = new ProgressDialog(this);
        progress.setTitle("Please Wait !!!");
        progress.setMessage(" Loading ...");
        progress.setCancelable(false);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.show();




//        Toast.makeText(getBaseContext(), "select : " + Id, Toast.LENGTH_SHORT).show();

        RequestExecutor re = new RequestExecutor(this);
        re.delegate = this;
        re.execute("4",Id);



    }

    @Override
    public void onProcessCompelete(Object result) {

       TStop stop = (TStop)result;

        progress.dismiss();

        listView = (ListView) findViewById(R.id.stopbusList);
        BusNewAdapter ba = new BusNewAdapter(stop.busList);
        listView.setAdapter(ba);
/*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
                TextView t = (TextView) v.findViewById(R.id.bustxt);
                Intent I = new Intent(SpecificStopDetailActivity.this,SpecificBusDetailActivity.class);
                I.putExtra("Id",stopbusList.get(position).getId());
                startActivity(I);

            }
        });

*/
    }
}
