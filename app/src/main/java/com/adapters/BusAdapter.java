package com.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.app.ali.test.R;
import com.models.TBus;
import com.models.TStop;

import java.util.ArrayList;

/**
 * Created by Ali on 5/24/2016.
 */
public class BusAdapter extends BaseAdapter {



    ArrayList<TBus> ar = new ArrayList<TBus>();

    public BusAdapter() {

    }

    public BusAdapter(ArrayList<TBus> ar1) {
        this.ar = ar1;
    }

    @Override
    public int getCount() {
        return ar.size();
    }

    @Override
    public Object getItem(int position) {
        return ar.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {


        if(view==null){
            LayoutInflater inflater =
                    LayoutInflater.from(parent.getContext());
            view=inflater.inflate(
                    R.layout.custom_bus_item_list,parent,false);
        }

        TBus c = ar.get(position);

        TextView btn = (TextView) view.findViewById(R.id.bustxt);
        btn.setText(c.getNumber());

        return view;
    }




}
