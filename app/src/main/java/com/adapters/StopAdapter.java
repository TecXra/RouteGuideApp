package com.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.ali.test.R;
import com.models.TStop;

import java.util.ArrayList;

/**
 * Created by Ali on 5/25/2016.
 */
public class StopAdapter extends BaseAdapter {

    ArrayList<TStop> ar = new ArrayList<TStop>();

    public StopAdapter() {

    }

    public StopAdapter(ArrayList<TStop> ar1) {
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
                    R.layout.custom_stop_item_list,parent,false);
        }

        TStop c = ar.get(position);

        TextView btn = (TextView) view.findViewById(R.id.stoptxt);
        btn.setText(c.getStopname ());

        return view;
    }



}
