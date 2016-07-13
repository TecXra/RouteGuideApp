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

    public TStop(String id) {
        this.id = id;

    }



    public TStop() {
        // TODO Auto-generated constructor stub
    }

    public String getStopname() {
        return stopname;
    }

    public void setStopname(String stopname) {
        this.stopname = stopname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
