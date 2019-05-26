package com.example.v3rlu.iaeste;

import android.util.Log;

public class MyDataSetGet {

    String compname ;
    String status ;

    public String getStatus() {
        //Log.d("compname",compname) ;
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompname() {

        //Log.d("compname",compname) ;
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }
}
