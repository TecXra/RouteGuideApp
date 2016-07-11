package com.app.ali.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.models.TBus;
import com.utils.AsyncResponse;
import com.utils.RequestExecutor;

public class SpecificBusDetailActivity extends AppCompatActivity implements AsyncResponse {

    TextView busNubmer;
    TextView status;
    TextView srcTerminal;
    TextView destTerminal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_bus_detail);


        String Id  = getIntent().getStringExtra("Id");

        Toast.makeText(getBaseContext(), "select : " + Id, Toast.LENGTH_SHORT).show();

        busNubmer  = (TextView)findViewById(R.id.busnumber);
        status = (TextView)findViewById(R.id.status);
        srcTerminal = (TextView)findViewById(R.id.srcTerminal);
        destTerminal = (TextView)findViewById(R.id.destTerminal);



        RequestExecutor re = new RequestExecutor(this);
        re.delegate = this;
        re.execute("1",Id);


    }

    @Override
    public void onProcessCompelete(Object result) {

        TBus tBus = (TBus)result;

         busNubmer.setText(tBus.getNumber());
         status.setText(tBus.getStatus());
         srcTerminal.setText(tBus.getSourceterminal());
         destTerminal.setText(tBus.getDestinationterminal());
        Toast.makeText(getBaseContext(), "Result Recived : "+ tBus.getNumber() , Toast.LENGTH_LONG).show();
    }
}
