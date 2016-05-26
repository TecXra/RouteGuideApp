package com.app.ali.test;

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

import java.util.ArrayList;

public class BusListActivity extends AppCompatActivity  {
    ListView listView;
    ArrayList<TBus> ar = new ArrayList<TBus>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);


        ar.add(new TBus("1","23"));
        ar.add(new TBus("2","22"));
        ar.add(new TBus("3", "36"));
        ar.add(new TBus("4", "51"));

        listView= (ListView) findViewById(R.id.buslist);
        BusAdapter ba = new BusAdapter(ar);
        listView.setAdapter(ba);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
                TextView t = (TextView) v.findViewById(R.id.bustxt);
          Intent I = new Intent(BusListActivity.this,SpecificBusDetailActivity.class);
                I.putExtra("Id",ar.get(position).getId());
                startActivity(I);
                Toast.makeText(getBaseContext(), "select : " + t.getText() + "  " + ar.get(position).getId() , Toast.LENGTH_SHORT).show();
            }
        });



    }

}
