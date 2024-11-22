package com.printadmin.entities;

public class Machine {

   
    //defines machines entity
    private int id;
    private String model;
    private String sn;
    private boolean state;//true/false(avaliable/rented)
    
    public Machine() {// for foreing key
    }

    public Machine(String model, String sn) {// only for creation
        this.model = model;
        this.sn = sn;
        state= true;
    }

    public Machine(int id, String model, String sn, boolean state) {// general reciveve
        this.id = id;
        this.model = model;
        this.sn = sn;
        this.state = state;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getSn() {
        return sn;
    }
    public void setSn(String sn) {
        this.sn = sn;
    }
    public String isState() {
        return (state== true)?"Disponible":"Rentado";
    }
    public void setState(boolean state) {
        this.state = state;
    }
    
    @Override
    public String toString() {
        return "Machine [id=" + id + ", model=" + model + ", sn=" + sn + ", state:" + isState() + "]";
    }
}
