package com.app.ali.test;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.adapters.BusAdapter;
import com.adapters.BusNewAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.models.TBus;
import com.models.TStop;
import com.utils.AsyncResponse;
import com.utils.RequestExecutor;

import java.util.ArrayList;

public class SpecificStopDetailActivity extends FragmentActivity implements AsyncResponse ,OnMapReadyCallback {
    private ProgressDialog progress;
    private GoogleMap mMap;
    ListView listView;
    TStop stop;

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

       stop = (TStop)result;

        progress.dismiss();

        listView = (ListView) findViewById(R.id.stopbusList);
        BusNewAdapter ba = new BusNewAdapter(stop.busList);
        listView.setAdapter(ba);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.smap);
        mapFragment.getMapAsync(this);
        ViewGroup.LayoutParams params = mapFragment.getView().getLayoutParams();
        params.height = 650;
        mapFragment.getView().setLayoutParams(params);



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


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        Double lat = Double.parseDouble(stop.getLatitude());
        Double lng = Double.parseDouble(stop.getLongitude());

        // Add a marker in Sydney and move the camera
        LatLng stoplocation = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(stoplocation).title(stop.getStopname()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(stoplocation,15));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12), 1500, null);

    }


}
