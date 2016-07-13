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

    public TBus(String id) {
        this.id = id;

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

    public String getSourceterminal() {
        return sourceterminal;
    }

    public void setSourceterminal(String sourceterminal) {
        this.sourceterminal = sourceterminal;
    }

    public String getDestinationterminal() {
        return destinationterminal;
    }

    public void setDestinationterminal(String destinationterminal) {
        this.destinationterminal = destinationterminal;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getFarelist() {
        return farelist;
    }

    public void setFarelist(String farelist) {
        this.farelist = farelist;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
}
