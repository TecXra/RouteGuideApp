package com.models;

/**
 * Created by Ali on 5/24/2016.
 */
public class TBus

{


    String id;
    String number;
    String sourceterminal;
    String destinationterminal;
    String companyname;
    String farelist;
    String status;
    String starttime;
    String endtime;



    public TBus(String id, String number) {
        this.id = id;
        this.number = number;
    }

    public TBus() {
        // TODO Auto-generated constructor stub
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
