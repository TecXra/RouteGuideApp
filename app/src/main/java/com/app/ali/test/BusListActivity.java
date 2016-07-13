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
import com.models.TBus;
import com.utils.AsyncResponse;
import com.utils.RequestExecutor;

import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class BusListActivity extends AppCompatActivity implements AsyncResponse {

    private ProgressDialog progress;


    ListView listView;
    ArrayList<TBus> busList ;
//    ArrayList<TBus> ar = new ArrayList<TBus>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);

        progress = new ProgressDialog(this);
        progress.setTitle("Please Wait !!!");
        progress.setMessage(" Loading ...");
        progress.setCancelable(false);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.show();




        RequestExecutor re = new RequestExecutor(this);
        re.delegate = this;
        re.execute("2");



/*

        busList.add(new TBus("1","23"));
        busList.add(new TBus("2","22"));
        busList.add(new TBus("3", "36"));
        busList.add(new TBus("4", "51"));



        listView= (ListView) findViewById(R.id.buslist);
        BusAdapter ba = new BusAdapter(busList);
        listView.setAdapter(ba);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
                TextView t = (TextView) v.findViewById(R.id.bustxt);
          Intent I = new Intent(BusListActivity.this,SpecificBusDetailActivity.class);
                I.putExtra("Id",busList.get(position).getId());
                startActivity(I);
                Toast.makeText(getBaseContext(), "select : " + t.getText() + "  " + busList.get(position).getId() , Toast.LENGTH_SHORT).show();
            }
        });


*/
    }


    @Override
    public void onProcessCompelete(Object result) {


        progress.dismiss();


        busList = (ArrayList<TBus>)result;

        listView= (ListView) findViewById(R.id.buslist);
        BusAdapter ba = new BusAdapter(busList);
        listView.setAdapter(ba);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
                TextView t = (TextView) v.findViewById(R.id.bustxt);
                Intent I = new Intent(BusListActivity.this,SpecificBusDetailActivity.class);
                I.putExtra("Id",busList.get(position).getId());
                startActivity(I);
//                Toast.makeText(getBaseContext(), "select : " + t.getText() + "  " + busList.get(position).getId() , Toast.LENGTH_SHORT).show();
            }
        });






    }
}
