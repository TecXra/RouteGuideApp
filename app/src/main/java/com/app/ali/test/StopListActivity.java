package com.app.ali.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.adapters.StopAdapter;
import com.models.TStop;

import java.util.ArrayList;

public class StopListActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<TStop> ar = new ArrayList<TStop>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_list);

        ar.add(new TStop("1","Thokar"));
        ar.add(new TStop("2","Jinnah"));
        ar.add(new TStop("3","Walton"));
        ar.add(new TStop("4","Model Town"));

        listView = (ListView) findViewById(R.id.stoplist);
        StopAdapter sa = new StopAdapter(ar);
        listView .setAdapter(sa);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
                TextView t = (TextView) v.findViewById(R.id.stoptxt);


                Intent I = new Intent(StopListActivity.this,SpecificStopDetailActivity.class);
                I.putExtra("Name",ar.get(position).getStopname());
                startActivity(I);
                Toast.makeText(getBaseContext(), "select : " + t.getText() + "  " + ar.get(position).getId() , Toast.LENGTH_SHORT).show();




                //    ar.get(position).getId();
               Toast.makeText(getBaseContext(), "select : " + t.getText() + "  " + ar.get(position).getId(), Toast.LENGTH_SHORT).show();
            }
        });






    }
}
