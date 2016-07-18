package com.app.ali.test;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.adapters.BusNewAdapter;
import com.adapters.StopNewAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.models.TBus;
import com.models.TStop;
import com.utils.AsyncResponse;
import com.utils.DirectionsJSONParser;
import com.utils.RequestExecutor;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpecificBusDetailActivity extends AppCompatActivity implements AsyncResponse {

    private ProgressDialog progress;
    TextView busNubmer;
    TextView status;
    TextView srcTerminal;
    TextView destTerminal;
    ListView listView;
    TBus tBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_bus_detail);
        String Id  = getIntent().getStringExtra("Id");
  //      Toast.makeText(getBaseContext(), "select : " + Id, Toast.LENGTH_SHORT).show();
        busNubmer  = (TextView)findViewById(R.id.busnumber);
        status = (TextView)findViewById(R.id.status);
        srcTerminal = (TextView)findViewById(R.id.srcTerminal);
        destTerminal = (TextView)findViewById(R.id.destTerminal);



        progress = new ProgressDialog(this);
         progress.setTitle("Please Wait !!!");
         progress.setMessage(" Loading ...");
         progress.setCancelable(false);
         progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
         progress.show();

        RequestExecutor re = new RequestExecutor(this);
        re.delegate = this;
        re.execute("1",Id);





    }



    public void routeshow(View v)
    {
        Intent i = new Intent(this, BusRouteMapActivity.class);
        i.putExtra("LatitudeLongitude", tBus.stopList);
        startActivity(i);
    }


    @Override
    public void onProcessCompelete(Object result) {

        tBus = (TBus)result;

/*
        for (int i=0;i<tBus.stopList.size();i++)
        {
            double lat = Double.parseDouble(tBus.stopList.get(i).getLatitude());
            double lng = Double.parseDouble(tBus.stopList.get(i).getLongitude());
            LatLng stops = new LatLng(lat, lng);

            setmarker(stops);
        }

*/


        progress.dismiss();
        busNubmer.setText(tBus.getNumber());
        status.setText(tBus.getStatus());
        srcTerminal.setText(tBus.getSourceterminal());
        destTerminal.setText(tBus.getDestinationterminal());

        listView = (ListView) findViewById(R.id.busstoplistview);
        StopNewAdapter ba = new StopNewAdapter(tBus.stopList);
        listView.setAdapter(ba);




    }





}
