package com.models;

/**
 * Created by Ali on 5/25/2016.
 */
public class TStop {


    String id;
    String stopname;
    String longitude;
    String latitude;

    public TStop(String id, String stopname) {
        this.id = id;
        this.stopname = stopname;
    }

    public TStop() {
        // TODO Auto-generated constructor stub
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStopname() {
        return stopname;
    }

    public void setStopname(String stopname ) {
        this.stopname = stopname ;
    }




}
