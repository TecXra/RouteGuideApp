package com.app.ali.test;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.adapters.BusNewAdapter;
import com.adapters.StopNewAdapter;
import com.models.TBus;
import com.utils.AsyncResponse;
import com.utils.RequestExecutor;

public class SpecificBusDetailActivity extends AppCompatActivity implements AsyncResponse {

    private ProgressDialog progress;

    TextView busNubmer;
    TextView status;
    TextView srcTerminal;
    TextView destTerminal;
    ListView listView;

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

    @Override
    public void onProcessCompelete(Object result) {


        progress.dismiss();



        TBus tBus = (TBus)result;

         busNubmer.setText(tBus.getNumber());
         status.setText(tBus.getStatus());
         srcTerminal.setText(tBus.getSourceterminal());
         destTerminal.setText(tBus.getDestinationterminal());

        listView = (ListView) findViewById(R.id.busstoplistview);
        StopNewAdapter ba = new StopNewAdapter(tBus.stopList);
        listView.setAdapter(ba);




//        Toast.makeText(getBaseContext(), "Result Recived : "+ tBus.getNumber() , Toast.LENGTH_LONG).show();
    }
}
