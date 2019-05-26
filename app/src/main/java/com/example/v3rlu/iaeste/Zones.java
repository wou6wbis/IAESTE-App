package com.example.v3rlu.iaeste;
//package com.example.v3rlu.iaestejobraising;

public class Zones {

    private String  compname ;
    private String addresse ;
    private String tel ;
    private String status ;
    private String zone ;
    private String user ;

    public Zones(){

    }

    public Zones(String compname, String addresse, String tel, String status, String zone, String user) {
        this.compname = compname;
        this.addresse = addresse;
        this.tel = tel;
        this.status = status;
        this.zone = zone;
        this.user = user;
    }

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
